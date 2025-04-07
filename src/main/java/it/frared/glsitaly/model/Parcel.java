package it.frared.glsitaly.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Parcel {

	@JacksonXmlProperty(localName = "CodiceContrattoGls")
	private String codiceContrattoGls;
	@JacksonXmlProperty(localName = "RagioneSociale")
	private String ragioneSociale;
	@JacksonXmlProperty(localName = "Indirizzo")
	private String indirizzo;
	@JacksonXmlProperty(localName = "Localita")
	private String localita;
	@JacksonXmlProperty(localName = "Zipcode")
	private String zipcode;
	@JacksonXmlProperty(localName = "Provincia")
	private String provincia;
	@JacksonXmlProperty(localName = "Colli")
	public int colli;
	@JacksonXmlProperty(localName = "PesoReale")
	public double pesoReale;
	@JacksonXmlProperty(localName = "NoteSpedizione")
	private String noteSpedizione;
	@JacksonXmlProperty(localName = "TipoPorto")
	private String tipoPorto;
	@JacksonXmlProperty(localName = "RiferimentoCliente")
	private String riferimentoCliente;
	@JacksonXmlProperty(localName = "Bda")
	private String bda;
	@JacksonXmlProperty(localName = "NoteAggiuntive")
	private String noteAggiuntive;
	@JacksonXmlProperty(localName = "TipoCollo")
	public int tipoCollo;
	@JacksonXmlProperty(localName = "Email")
	private String email;
	@JacksonXmlProperty(localName = "Cellulare1")
	private String cellulare1;
	@JacksonXmlProperty(localName = "GeneraPdf")
	public int generaPdf;
	@JacksonXmlProperty(localName = "FormatoPdf")
	private String formatoPdf;
	@JacksonXmlProperty(localName = "TipoSpedizione")
	private String tipoSpedizione;
	@JacksonXmlProperty(localName = "TelefonoDestinatario")
	private String telefonoDestinatario;
	@JacksonXmlProperty(localName = "TelefonoMittente")
	private String telefonoMittente;

	@JacksonXmlProperty(localName = "ImportoContrassegno")
	private String importoContrassegno;

	@JacksonXmlProperty(localName = "NumeroDiSpedizioneGLSDaConfermare")
	private String numeroDiSpedizioneGLSDaConfermare;

}