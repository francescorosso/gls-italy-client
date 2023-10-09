package it.frared.glsitaly.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class RitiroResponse {

	public static class RitiroStatus {
		public static final String NON_EFFETTUATO = "Non effettuato";
		public static final String EFFETTUATO = "Effettuato";
	}

	@JacksonXmlProperty(localName = "NumeroRitiro")
	private String numeroRitiro;
	@JacksonXmlProperty(localName = "DataRitiro")
	private String dataRitiro;
	@JacksonXmlProperty(localName = "DalleMattina")
	private String dalleMattina;
	@JacksonXmlProperty(localName = "AlleMattina")
	private String alleMattina;
	@JacksonXmlProperty(localName = "DallePomeriggio")
	private String dallePomeriggio;
	@JacksonXmlProperty(localName = "AllePomeriggio")
	private String allePomeriggio;
	@JacksonXmlProperty(localName = "StatoRitiro")
	private String statoRitiro;
	@JacksonXmlProperty(localName = "DataUltimoEsito")
	private String dataUltimoEsito;
	@JacksonXmlProperty(localName = "OraUltimoEsito")
	private String oraUltimoEsito;
	@JacksonXmlProperty(localName = "NumeroColli")
	private String numeroColli;
	@JacksonXmlProperty(localName = "Peso")
	private String peso;

	public String getNumeroRitiro() {
		return this.numeroRitiro;
	}

	public String getDataRitiro() {
		return this.dataRitiro;
	}

	public String getDalleMattina() {
		return this.dalleMattina;
	}

	public String getAlleMattina() {
		return this.alleMattina;
	}

	public String getDallePomeriggio() {
		return this.dallePomeriggio;
	}

	public String getAllePomeriggio() {
		return this.allePomeriggio;
	}

	public String getStatoRitiro() {
		return this.statoRitiro;
	}

	public String getDataUltimoEsito() {
		return this.dataUltimoEsito;
	}

	public String getOraUltimoEsito() {
		return this.oraUltimoEsito;
	}

	public String getNumeroColli() {
		return this.numeroColli;
	}

	public String getPeso() {
		return this.peso;
	}
}