package it.frared.glsitaly.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Pickup {

	@JacksonXmlProperty(localName = "CodiceContrattoGls")
	private String codiceContrattoGls;
	@JacksonXmlProperty(localName = "NomeRichiedente")
	private String nomeRichiedente;
	@JacksonXmlProperty(localName = "Colli")
	private int colli;
	@JacksonXmlProperty(localName = "PesoReale")
	private double pesoReale;
	@JacksonXmlProperty(localName = "DataRitiro")
	private String dataRitiro;
	@JacksonXmlProperty(localName = "Dalle1")
	private String dalle1;
	@JacksonXmlProperty(localName = "Alle1")
	private String alle1;
	@JacksonXmlProperty(localName = "Dalle2")
	private String dalle2;
	@JacksonXmlProperty(localName = "Alle2")
	private String alle2;
	@JacksonXmlProperty(localName = "TipoCollo")
	private String tipoCollo;
	@JacksonXmlProperty(localName = "Clienteritiro")
	private String clienteRitiro;
	@JacksonXmlProperty(localName = "Indirizzoritiro")
	private String indirizzoRitiro;
	@JacksonXmlProperty(localName = "Localitaritiro")
	private String localitaRitiro;
	@JacksonXmlProperty(localName = "CAPritiro")
	private String capRitiro;
	@JacksonXmlProperty(localName = "Provinciaritiro")
	private String provinciaRitiro;
	@JacksonXmlProperty(localName = "EmailLuogoritiro")
	private String emailLuogoRitiro;


	public String getCodiceContrattoGls() {
		return this.codiceContrattoGls;
	}

	public void setCodiceContrattoGls(String codiceContrattoGls) {
		this.codiceContrattoGls = codiceContrattoGls;
	}

	public String getNomeRichiedente() {
		return this.nomeRichiedente;
	}

	public void setNomeRichiedente(String nomeRichiedente) {
		this.nomeRichiedente = nomeRichiedente;
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

	public String getDataRitiro() {
		return this.dataRitiro;
	}

	public void setDataRitiro(String dataRitiro) {
		this.dataRitiro = dataRitiro;
	}

	public String getDalle1() {
		return this.dalle1;
	}

	public void setDalle1(String dalle1) {
		this.dalle1 = dalle1;
	}

	public String getAlle1() {
		return this.alle1;
	}

	public void setAlle1(String alle1) {
		this.alle1 = alle1;
	}

	public String getDalle2() {
		return this.dalle2;
	}

	public void setDalle2(String dalle2) {
		this.dalle2 = dalle2;
	}

	public String getAlle2() {
		return this.alle2;
	}

	public void setAlle2(String alle2) {
		this.alle2 = alle2;
	}

	public String getTipoCollo() {
		return this.tipoCollo;
	}

	public void setTipoCollo(String tipoCollo) {
		this.tipoCollo = tipoCollo;
	}

	public String getClienteRitiro() {
		return this.clienteRitiro;
	}

	public void setClienteRitiro(String clienteRitiro) {
		this.clienteRitiro = clienteRitiro;
	}

	public String getIndirizzoRitiro() {
		return this.indirizzoRitiro;
	}

	public void setIndirizzoRitiro(String indirizzoRitiro) {
		this.indirizzoRitiro = indirizzoRitiro;
	}

	public String getLocalitaRitiro() {
		return this.localitaRitiro;
	}

	public void setLocalitaRitiro(String localitaRitiro) {
		this.localitaRitiro = localitaRitiro;
	}

	public String getCapRitiro() {
		return this.capRitiro;
	}

	public void setCapRitiro(String capRitiro) {
		this.capRitiro = capRitiro;
	}

	public String getProvinciaRitiro() {
		return this.provinciaRitiro;
	}

	public void setProvinciaRitiro(String provinciaRitiro) {
		this.provinciaRitiro = provinciaRitiro;
	}

	public String getEmailLuogoRitiro() {
		return this.emailLuogoRitiro;
	}

	public void setEmailLuogoRitiro(String emailLuogoRitiro) {
		this.emailLuogoRitiro = emailLuogoRitiro;
	}

	public Pickup codiceContrattoGls(String codiceContrattoGls) {
		setCodiceContrattoGls(codiceContrattoGls);
		return this;
	}

	public Pickup nomeRichiedente(String nomeRichiedente) {
		setNomeRichiedente(nomeRichiedente);
		return this;
	}

	public Pickup colli(int colli) {
		setColli(colli);
		return this;
	}

	public Pickup pesoReale(double pesoReale) {
		setPesoReale(pesoReale);
		return this;
	}

	public Pickup dataRitiro(String dataRitiro) {
		setDataRitiro(dataRitiro);
		return this;
	}

	public Pickup dalle1(String dalle1) {
		setDalle1(dalle1);
		return this;
	}

	public Pickup alle1(String alle1) {
		setAlle1(alle1);
		return this;
	}

	public Pickup dalle2(String dalle2) {
		setDalle2(dalle2);
		return this;
	}

	public Pickup alle2(String alle2) {
		setAlle2(alle2);
		return this;
	}

	public Pickup tipoCollo(String tipoCollo) {
		setTipoCollo(tipoCollo);
		return this;
	}

	public Pickup clienteRitiro(String clienteRitiro) {
		setClienteRitiro(clienteRitiro);
		return this;
	}

	public Pickup indirizzoRitiro(String indirizzoRitiro) {
		setIndirizzoRitiro(indirizzoRitiro);
		return this;
	}

	public Pickup localitaRitiro(String localitaRitiro) {
		setLocalitaRitiro(localitaRitiro);
		return this;
	}

	public Pickup capRitiro(String capRitiro) {
		setCapRitiro(capRitiro);
		return this;
	}

	public Pickup provinciaRitiro(String provinciaRitiro) {
		setProvinciaRitiro(provinciaRitiro);
		return this;
	}

	public Pickup emailLuogoRitiro(String emailLuogoRitiro) {
		setEmailLuogoRitiro(emailLuogoRitiro);
		return this;
	}

}