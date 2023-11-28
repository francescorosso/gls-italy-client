package it.frared.glsitaly;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import it.frared.glsitaly.model.AddressList;
import it.frared.glsitaly.model.Base64Binary;
import it.frared.glsitaly.model.CloseParcelsResult;
import it.frared.glsitaly.model.DeletePickup;
import it.frared.glsitaly.model.ElencoResponse;
import it.frared.glsitaly.model.Info;
import it.frared.glsitaly.model.InfoResponse;
import it.frared.glsitaly.model.Parcel;
import it.frared.glsitaly.model.ParcelResponse;
import it.frared.glsitaly.model.Pickup;
import it.frared.glsitaly.model.PickupsResponse;
import it.frared.glsitaly.model.RitiroResponse;
import it.frared.glsitaly.model.SpedizioneResponse;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

@Slf4j
public class GlsDAO {

	private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH");

	private String sedeGls;
	private String codiceClienteGls;
	private String passwordClienteGls;
	private String codiceContrattoGls;
	
	private ObjectMapper jsonMapper;
	private XmlMapper xmlMapper;

	private GlsAddressService addressService;
	private GlsLabelService labelService;
	private GlsTrackingService trackingService;

	public GlsDAO(String sedeGls, String codiceClienteGls, String passwordClienteGls, String codiceContrattoGls) {
		this.sedeGls = sedeGls;
		this.codiceClienteGls = codiceClienteGls;
		this.passwordClienteGls = passwordClienteGls;
		this.codiceContrattoGls = codiceContrattoGls;

		jsonMapper = new ObjectMapper()
			.registerModule(new JavaTimeModule())
			.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
			.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

		xmlMapper = XmlMapper.builder()
			.defaultUseWrapper(false)
			.serializationInclusion(JsonInclude.Include.NON_DEFAULT)
			.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
			.addModule(new JavaTimeModule())
			.build();

		OkHttpClient httpClient = new OkHttpClient.Builder().build();

		this.addressService = new Retrofit.Builder()
			.baseUrl("https://checkaddress.gls-italy.com/wsCheckAddress.asmx/")
			.addConverterFactory(ScalarsConverterFactory.create())
			.client(httpClient)
			.build()
			.create(GlsAddressService.class);

		this.labelService = new Retrofit.Builder()
			.baseUrl("https://labelservice.gls-italy.com/ilswebservice.asmx/")
			.addConverterFactory(JacksonConverterFactory.create(xmlMapper))
			.client(httpClient)
			.build()
			.create(GlsLabelService.class);

		this.trackingService = new Retrofit.Builder()
			.baseUrl("https://infoweb.gls-italy.com/XML/")
			.addConverterFactory(ScalarsConverterFactory.create())
			.client(httpClient)
			.build()
			.create(GlsTrackingService.class);
	}

	public String getSede() {
		return this.sedeGls;
	}

	public String getNumeroSpedizione(String trackingNumber) {
		if (trackingNumber.startsWith(this.sedeGls)) {
			return trackingNumber.substring(this.sedeGls.length());
		} else {
			return trackingNumber;
		}
	}

	public AddressList checkAddress(
		String siglaProvincia,
		String cap,
		String localita,
		String indirizzo) throws GlsServiceException {

		try {
			Response<String> response = addressService.checkAddress(sedeGls, codiceClienteGls, passwordClienteGls, siglaProvincia, cap, localita, indirizzo)
				.execute();
			if (!response.isSuccessful()) {
				throw new GlsServiceException("WS error");
			}
			log.debug("addressList\n{}", response.body());
			AddressList infoResponse = xmlMapper.readValue(response.body(), AddressList.class);
			return infoResponse;
		} catch (Exception e) {
			throw new GlsServiceException("Unable to check Address", e);
		}
	}

	public String addParcel(
		String ragioneSociale,
		String indirizzo,
		String localita,
		String zipCode,
		String provincia,
		String riferimentoCliente,
		String email,
		String cellulare,
		int colli,
		double peso) throws GlsServiceException {

		if (colli < 1 || colli > 99) {
			throw new GlsServiceException("Colli must be >= 1");
		}

		try {
			Info info = new Info()
				.setSedeGls(sedeGls)
				.setCodiceClienteGls(codiceClienteGls)
				.setPasswordClienteGls(passwordClienteGls)
				.setAddParcelResult("S");
			for (int i = 0; i < colli; i++) {
				Parcel parcel = new Parcel()
					.setCodiceContrattoGls(codiceContrattoGls)
					.setTipoPorto("F")
					.setTipoCollo(0)
					.setGeneraPdf(4)
					.setFormatoPdf("A6")
					.setTipoSpedizione("N")

					.setRagioneSociale(ragioneSociale)
					.setIndirizzo(indirizzo)
					.setLocalita(localita)
					.setZipcode(zipCode)
					.setProvincia(provincia)
					.setRiferimentoCliente(riferimentoCliente)
					.setBda(riferimentoCliente)
					.setEmail(email)
					.setCellulare1(cellulare)
					.setTelefonoDestinatario(cellulare)
					.setColli(i)
					.setPesoReale(peso);

				info.parcel(parcel);
			}

			String xml = xmlMapper.writeValueAsString(info);
			log.debug("addParcel\n{}", xml);

			Response<InfoResponse> response = labelService.addParcel(xml)
				.execute();
			if (!response.isSuccessful()) {
				throw new GlsServiceException("WS error");
			}

			ParcelResponse parcelResponse = response.body().getParcels().get(0);
			if (parcelResponse.isError()) {
				log.warn("address not valid");
				throw new GlsServiceAddressException("address not valid for order " + riferimentoCliente);
			}

			String numeroSpedizione = parcelResponse.getNumeroSpedizione();
			log.info("Added new Parcel {}", numeroSpedizione);

			return this.getSede() + numeroSpedizione;
		} catch (IOException e) {
			throw new GlsServiceException("Unable to add Parcel", e);
		}
	}

	public void deleteParcel(String numeroSpedizione) throws GlsServiceException {
		numeroSpedizione = this.getNumeroSpedizione(numeroSpedizione);

		try {
			Response<Void> response = labelService.deleteParcel(sedeGls, codiceClienteGls, passwordClienteGls, numeroSpedizione)
				.execute();
			if (!response.isSuccessful()) {
				throw new GlsServiceException("WS error");
			}
			log.debug("deleteParcelResponse\n{}", response.body());

			//TODO check result

			log.info("Deleted Parcel {}", numeroSpedizione);
		} catch (Exception e) {
			throw new GlsServiceException("Unable to delete Parcel", e);
		}
	}

	public void confirmParcel(String numeroSpedizione) throws GlsServiceException {
		numeroSpedizione = this.getNumeroSpedizione(numeroSpedizione);

		try {
			Info info = new Info()
				.setSedeGls(sedeGls)
				.setCodiceClienteGls(codiceClienteGls)
				.setPasswordClienteGls(passwordClienteGls);

			Parcel parcel = new Parcel()
				.setNumeroDiSpedizioneGLSDaConfermare(numeroSpedizione);

			info.parcel(parcel);

			String xml = xmlMapper.writeValueAsString(info);
			log.debug("confirmParcel\n{}", xml);

			Response<CloseParcelsResult> response = labelService.confirmParcel(xml)
				.execute();
			if (!response.isSuccessful()) {
				throw new GlsServiceException("WS error");
			}
			
			log.debug("confirmParcelResponse\n{}", response.body());

			if (!"OK".equals(response.body().getParcels().get(0).getEsito())) {
				throw new GlsServiceException("WS error");
			}

			log.info("Confirmed Parcel {}", numeroSpedizione);
		} catch (Exception e) {
			throw new GlsServiceException("Unable to confirm Parcel", e);
		}
	}

	public SpedizioneResponse getParcelStatus(String numeroSpedizione) throws GlsServiceException {
		numeroSpedizione = this.getNumeroSpedizione(numeroSpedizione);

		try {
			Response<String> response = trackingService.getRitiroStatus(sedeGls, codiceContrattoGls, numeroSpedizione)
				.execute();
			if (!response.isSuccessful()) {
				throw new GlsServiceException("WS error");
			}
			log.debug("elencoResponse\n{}", response.body());
			ElencoResponse e = xmlMapper.readValue(response.body(), ElencoResponse.class);
			return e.getSpedizioni().get(0);
		} catch (Exception e) {
			throw new GlsServiceException("Unable to retrieve spedizione status", e);
		}
	}

	public byte[] getPdfBySped(String numeroSpedizione, String bda, int numeroCollo, String tipoPorto) throws GlsServiceException {
		numeroSpedizione = this.getNumeroSpedizione(numeroSpedizione);

		try {
			Response<Base64Binary> response = labelService.getPdfBySped(
				sedeGls,
				codiceClienteGls,
				passwordClienteGls,
				codiceContrattoGls,
				numeroSpedizione,
				bda,
				numeroCollo,
				tipoPorto)
				.execute();
			if (!response.isSuccessful()) {
				throw new GlsServiceException("WS error");
			}
			return Base64.getDecoder().decode(response.body().getText());
		} catch (Exception e) {
			throw new GlsServiceException("Unable to get Parcel PDF " + numeroSpedizione + "/" + numeroCollo, e);
		}
	}

	//PICKUP
	public String requestPickup(
		int colli,
		double peso,
		LocalDate data,
		LocalTime dalleMattino,
		LocalTime alleMattino,
		LocalTime dallePomeriggio,
		LocalTime allePomeriggio) throws GlsServiceException {
		try {
			Info info = new Info()
				.setSedeGls(sedeGls)
				.setCodiceClienteGls(codiceClienteGls)
				.setPasswordClienteGls(passwordClienteGls);

			Pickup pickup = new Pickup()
				.setCodiceContrattoGls(codiceContrattoGls)
				.setTipoCollo("0")
				.setNomeRichiedente("Magazzino")
				.setClienteRitiro("Azienda Agrimontana SpA")
				.setIndirizzoRitiro("Via Camillo Benso conte di Cavour, 185")
				.setLocalitaRitiro("Borgo San Dalmazzo")
				.setCapRitiro("12011")
				.setProvinciaRitiro("CN")
				.setEmailLuogoRitiro("agrimontana@agrimontana.it")

				.setColli(colli)
				.setPesoReale(peso)
				.setDataRitiro(dateFormatter.format(data))
				.setDalle1(timeFormatter.format(dalleMattino))
				.setAlle1(timeFormatter.format(alleMattino))
				.setDalle2(timeFormatter.format(dallePomeriggio))
				.setAlle2(timeFormatter.format(allePomeriggio));

			info.pickup(pickup);

			String xml = xmlMapper.writeValueAsString(info);
			log.debug("requestPickup\n{}", xml);
			Response<PickupsResponse> response = labelService.requestPickup(xml)
				.execute();
			if (!response.isSuccessful()) {
				throw new GlsServiceException("WS error");
			}
			log.debug("requestPickupResponse\n{}", response.body());
			return response.body().getPickups().get(0).getNumeroRitiro();
		} catch (Exception e) {
			throw new GlsServiceException("Unable to request a new pickup", e);
		}
	}

	public void deletePickup(String numeroRitiro) throws GlsServiceException {
		try {
			Info info = new Info()
				.setSedeGls(sedeGls)
				.setCodiceClienteGls(codiceClienteGls)
				.setPasswordClienteGls(passwordClienteGls);

			DeletePickup pickup = new DeletePickup()
				.codiceContrattoGls(codiceContrattoGls)
				.nomeCognome("Magazzino")
				.email("agrimontana@agrimontana.it")

				.numeroRitiro(numeroRitiro);

			info.deletePickup(pickup);

			String xml = xmlMapper.writeValueAsString(info);
			log.debug("deletePickup\n{}", xml);
			Response<PickupsResponse> response = labelService.deletePickup(xml)
				.execute();
			if (!response.isSuccessful()) {
				throw new GlsServiceException("WS error");
			}
			log.debug("deletePickupResponse\n{}", response.body());
			//PickupsResponse pickups = xmlMapper.readValue(response.body(), PickupsResponse.class);
			//return pickups.getPickups().get(0).getNumeroRitiro();
		} catch (Exception e) {
			throw new GlsServiceException("Unable to delete pickup", e);
		}
	}

	public RitiroResponse getRitiroStatus(String numeroRitiro) throws GlsServiceException {
		try {
			Response<String> response = trackingService.getRitiroStatus(sedeGls, codiceContrattoGls, numeroRitiro)
				.execute();
			if (!response.isSuccessful()) {
				throw new GlsServiceException("WS error");
			}
			ElencoResponse e = xmlMapper.readValue(response.body(), ElencoResponse.class);
			return e.getRitiri().get(0);
		} catch (Exception e) {
			throw new GlsServiceException("Unable to retrieve ritiro status", e);
		}
	}
}