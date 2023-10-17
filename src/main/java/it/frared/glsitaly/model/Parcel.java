package it.frared.glsitaly.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

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


	public String getCodiceContrattoGls() {
		return this.codiceContrattoGls;
	}

	public void setCodiceContrattoGls(String codiceContrattoGls) {
		this.codiceContrattoGls = codiceContrattoGls;
	}

	public String getRagioneSociale() {
		return this.ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public String getIndirizzo() {
		return this.indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getLocalita() {
		return this.localita;
	}

	public void setLocalita(String localita) {
		this.localita = localita;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public int getColli() {
		return this.colli;
	}

	public void setColli(int colli) {
		this.colli = colli;
	}

	public double getPesoReale() {
		return this.pesoReale;
	}

	public void setPesoReale(double pesoReale) {
		this.pesoReale = pesoReale;
	}

	public String getNoteSpedizione() {
		return this.noteSpedizione;
	}

	public void setNoteSpedizione(String noteSpedizione) {
		this.noteSpedizione = noteSpedizione;
	}

	public String getTipoPorto() {
		return this.tipoPorto;
	}

	public void setTipoPorto(String tipoPorto) {
		this.tipoPorto = tipoPorto;
	}

	public String getRiferimentoCliente() {
		return this.riferimentoCliente;
	}

	public void setRiferimentoCliente(String riferimentoCliente) {
		this.riferimentoCliente = riferimentoCliente;
	}

	public String getBda() {
		return this.bda;
	}

	public void setBda(String bda) {
		this.bda = bda;
	}

	public String getNoteAggiuntive() {
		return this.noteAggiuntive;
	}

	public void setNoteAggiuntive(String noteAggiuntive) {
		this.noteAggiuntive = noteAggiuntive;
	}

	public int getTipoCollo() {
		return this.tipoCollo;
	}

	public void setTipoCollo(int tipoCollo) {
		this.tipoCollo = tipoCollo;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCellulare1() {
		return this.cellulare1;
	}

	public void setCellulare1(String cellulare1) {
		this.cellulare1 = cellulare1;
	}

	public int getGeneraPdf() {
		return this.generaPdf;
	}

	public void setGeneraPdf(int generaPdf) {
		this.generaPdf = generaPdf;
	}

	public String getFormatoPdf() {
		return this.formatoPdf;
	}

	public void setFormatoPdf(String formatoPdf) {
		this.formatoPdf = formatoPdf;
	}

	public String getTipoSpedizione() {
		return this.tipoSpedizione;
	}

	public void setTipoSpedizione(String tipoSpedizione) {
		this.tipoSpedizione = tipoSpedizione;
	}

	public String getTelefonoDestinatario() {
		return this.telefonoDestinatario;
	}

	public void setTelefonoDestinatario(String telefonoDestinatario) {
		this.telefonoDestinatario = telefonoDestinatario;
	}

	public String getTelefonoMittente() {
		return this.telefonoMittente;
	}

	public void setTelefonoMittente(String telefonoMittente) {
		this.telefonoMittente = telefonoMittente;
	}

	public Parcel codiceContrattoGls(String codiceContrattoGls) {
		setCodiceContrattoGls(codiceContrattoGls);
		return this;
	}

	public Parcel ragioneSociale(String ragioneSociale) {
		setRagioneSociale(ragioneSociale);
		return this;
	}

	public Parcel indirizzo(String indirizzo) {
		setIndirizzo(indirizzo);
		return this;
	}

	public Parcel localita(String localita) {
		setLocalita(localita);
		return this;
	}

	public Parcel zipcode(String zipcode) {
		setZipcode(zipcode);
		return this;
	}

	public Parcel provincia(String provincia) {
		setProvincia(provincia);
		return this;
	}

	public Parcel colli(int colli) {
		setColli(colli);
		return this;
	}

	public Parcel pesoReale(double pesoReale) {
		setPesoReale(pesoReale);
		return this;
	}

	public Parcel noteSpedizione(String noteSpedizione) {
		setNoteSpedizione(noteSpedizione);
		return this;
	}

	public Parcel tipoPorto(String tipoPorto) {
		setTipoPorto(tipoPorto);
		return this;
	}

	public Parcel riferimentoCliente(String riferimentoCliente) {
		setRiferimentoCliente(riferimentoCliente);
		return this;
	}

	public Parcel bda(String bda) {
		setBda(bda);
		return this;
	}

	public Parcel noteAggiuntive(String noteAggiuntive) {
		setNoteAggiuntive(noteAggiuntive);
		return this;
	}

	public Parcel tipoCollo(int tipoCollo) {
		setTipoCollo(tipoCollo);
		return this;
	}

	public Parcel email(String email) {
		setEmail(email);
		return this;
	}

	public Parcel cellulare1(String cellulare1) {
		setCellulare1(cellulare1);
		return this;
	}

	public Parcel generaPdf(int generaPdf) {
		setGeneraPdf(generaPdf);
		return this;
	}

	public Parcel formatoPdf(String formatoPdf) {
		setFormatoPdf(formatoPdf);
		return this;
	}

	public Parcel tipoSpedizione(String tipoSpedizione) {
		setTipoSpedizione(tipoSpedizione);
		return this;
	}

	public Parcel telefonoDestinatario(String telefonoDestinatario) {
		setTelefonoDestinatario(telefonoDestinatario);
		return this;
	}

	public Parcel telefonoMittente(String telefonoMittente) {
		setTelefonoMittente(telefonoMittente);
		return this;
	}
}