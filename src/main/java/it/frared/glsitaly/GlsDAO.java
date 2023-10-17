package it.frared.glsitaly;

import java.util.Base64;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

import it.frared.glsitaly.model.AddressList;
import it.frared.glsitaly.model.Base64Binary;
import it.frared.glsitaly.model.DeletePickup;
import it.frared.glsitaly.model.ElencoResponse;
import it.frared.glsitaly.model.Info;
import it.frared.glsitaly.model.InfoResponse;
import it.frared.glsitaly.model.Parcel;
import it.frared.glsitaly.model.Pickup;
import it.frared.glsitaly.model.PickupsResponse;
import it.frared.glsitaly.model.RitiroResponse;
import it.frared.glsitaly.model.SpedizioneResponse;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

@Slf4j
public class GlsDAO {

	private String sedeGls;
	private String codiceClienteGls;
	private String passwordClienteGls;
	private String codiceContrattoGls;

	private GlsAddressService addressService;
	private GlsLabelService labelService;
	private GlsTrackingService trackingService;
	private XmlMapper xmlMapper;

	public GlsDAO(String sedeGls, String codiceClienteGls, String passwordClienteGls, String codiceContrattoGls) {
		this.sedeGls = sedeGls;
		this.codiceClienteGls = codiceClienteGls;
		this.passwordClienteGls = passwordClienteGls;
		this.codiceContrattoGls = codiceContrattoGls;

		OkHttpClient httpClient = new OkHttpClient.Builder().build();

		this.addressService = new Retrofit.Builder()
			.baseUrl("https://checkaddress.gls-italy.com/wsCheckAddress.asmx/")
			.addConverterFactory(ScalarsConverterFactory.create())
			.client(httpClient)
			.build()
			.create(GlsAddressService.class);

		this.labelService = new Retrofit.Builder()
			.baseUrl("https://labelservice.gls-italy.com/ilswebservice.asmx/")
			//.addConverterFactory(JacksonConverterFactory.create())
			.addConverterFactory(ScalarsConverterFactory.create())
			.client(httpClient)
			.build()
			.create(GlsLabelService.class);

		this.trackingService = new Retrofit.Builder()
			.baseUrl("https://infoweb.gls-italy.com/XML/")
			.addConverterFactory(ScalarsConverterFactory.create())
			.client(httpClient)
			.build()
			.create(GlsTrackingService.class);

		xmlMapper = new XmlMapper();
		xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		xmlMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
		xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, false);
		xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_1_1, false);
		xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
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

	public InfoResponse addParcel(
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
				.sedeGls(sedeGls)
				.codiceClienteGls(codiceClienteGls)
				.passwordClienteGls(passwordClienteGls)
				.addParcelResult("S");

			for (int i = 0; i < colli; i++) {
				Parcel parcel = new Parcel()
					.codiceContrattoGls(codiceContrattoGls)
					.tipoPorto("F")
					.tipoCollo(0)
					.generaPdf(3)
					.formatoPdf("A6")
					.tipoSpedizione("N")

					.ragioneSociale(ragioneSociale)
					.indirizzo(indirizzo)
					.localita(localita)
					.zipcode(zipCode)
					.provincia(provincia)
					.riferimentoCliente(riferimentoCliente)
					.bda(riferimentoCliente)
					.email(email)
					.cellulare1(cellulare)
					.telefonoDestinatario(cellulare)
					.colli(colli)
					.pesoReale(peso);

				info.parcel(parcel);
			}

			String xml = xmlMapper.writeValueAsString(info);
			log.debug("addParcel\n{}", xml);

			Response<String> response = labelService.addParcel(xml)
				.execute();
			if (!response.isSuccessful()) {
				throw new GlsServiceException("WS error");
			}
			log.debug("addParcelResponse\n{}", response.body());
			InfoResponse infoResponse = xmlMapper.readValue(response.body(), InfoResponse.class);
			return infoResponse;

		} catch (Exception e) {
			throw new GlsServiceException("Unable to add Parcel", e);
		}
	}

	public void deleteParcel(String numeroSpedizione) throws GlsServiceException {
		try {
			Response<Void> response = labelService.deleteParcel(sedeGls, codiceClienteGls, passwordClienteGls, numeroSpedizione)
				.execute();
			if (!response.isSuccessful()) {
				throw new GlsServiceException("WS error");
			}
			log.debug("deleteParcelResponse\n{}", response.body());
			log.debug("Deleted Parcel {}", numeroSpedizione);
		} catch (Exception e) {
			throw new GlsServiceException("Unable to delete Parcel", e);
		}
	}

	public void confirmParcel() {
		//TODO
	}

	public SpedizioneResponse getSpedizioneStatus(String numeroSpedizione) throws GlsServiceException {
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

	public byte[] getPdfBySped(String numeroSpedizione, int numeroCollo) throws GlsServiceException {
		try {
			Response<String> response = labelService.getPdfBySped(sedeGls, codiceClienteGls, passwordClienteGls, codiceContrattoGls, numeroSpedizione, "1", numeroCollo)
				.execute();
			if (!response.isSuccessful()) {
				throw new GlsServiceException("WS error");
			}
			Base64Binary base64 = xmlMapper.readValue(response.body(), Base64Binary.class);
			return Base64.getDecoder().decode(base64.getText());
		} catch (Exception e) {
			throw new GlsServiceException("Unable to get Parcel PDF", e);
		}
	}

	//PICKUP
	public String requestPickup(
		int colli,
		double peso,
		String data,
		String dalleMattino,
		String alleMattino,
		String dallePomeriggio,
		String allePomeriggio) throws GlsServiceException {
		try {
			Info info = new Info()
				.sedeGls(sedeGls)
				.codiceClienteGls(codiceClienteGls)
				.passwordClienteGls(passwordClienteGls);

			Pickup pickup = new Pickup()
				.codiceContrattoGls(codiceContrattoGls)
				.tipoCollo("0")
				.nomeRichiedente("Magazzino")
				.clienteRitiro("Azienda Agrimontana SpA")
				.indirizzoRitiro("Via Camillo Benso conte di Cavour, 185")
				.localitaRitiro("Borgo San Dalmazzo")
				.capRitiro("12011")
				.provinciaRitiro("CN")
				.emailLuogoRitiro("agrimontana@agrimontana.it")

				.colli(colli)
				.pesoReale(peso)
				.dataRitiro(data)
				.dalle1(dalleMattino)
				.alle1(alleMattino)
				.dalle2(dallePomeriggio)
				.alle2(allePomeriggio);

			info.pickup(pickup);

			String xml = xmlMapper.writeValueAsString(info);
			log.debug("requestPickup\n{}", xml);
			Response<String> response = labelService.requestPickup(xml)
				.execute();
			if (!response.isSuccessful()) {
				throw new GlsServiceException("WS error");
			}
			log.debug("requestPickupResponse\n{}", response.body());
			PickupsResponse pickups = xmlMapper.readValue(response.body(), PickupsResponse.class);
			return pickups.getPickups().get(0).getNumeroRitiro();
		} catch (Exception e) {
			throw new GlsServiceException("Unable to request a new pickup", e);
		}
	}

	public void deletePickup(String numeroRitiro) throws GlsServiceException {
		try {
			Info info = new Info()
				.sedeGls(sedeGls)
				.codiceClienteGls(codiceClienteGls)
				.passwordClienteGls(passwordClienteGls);

			DeletePickup pickup = new DeletePickup()
				.codiceContrattoGls(codiceContrattoGls)
				.nomeCognome("Magazzino")
				.email("agrimontana@agrimontana.it")

				.numeroRitiro(numeroRitiro);

			info.deletePickup(pickup);

			String xml = xmlMapper.writeValueAsString(info);
			log.debug("deletePickup\n{}", xml);
			Response<String> response = labelService.deletePickup(xml)
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