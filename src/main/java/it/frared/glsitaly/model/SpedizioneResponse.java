package it.frared.glsitaly.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class SpedizioneResponse {

	public static class SpedizioneStatus {
		public static final String NON_CONSEGNATO = "Non consegnato";
		public static final String CONSEGNATO = "Consegnato";
	}

	@JacksonXmlProperty(localName = "NumSped")
	private String numSped;
	@JacksonXmlProperty(localName = "Bda")
	private String bda;
	@JacksonXmlProperty(localName = "DataPartenza")
	private String dataPartenza;
	@JacksonXmlProperty(localName = "StatoSpedizione")
	private String statoSpedizione;
	@JacksonXmlProperty(localName = "Firma")
	private String firma;
	@JacksonXmlProperty(localName = "NumeroColli")
	private String numeroColli;
	@JacksonXmlProperty(localName = "Peso")
	private String peso;


	public String getNumSped() {
		return this.numSped;
	}

	public String getBda() {
		return this.bda;
	}

	public String getDataPartenza() {
		return this.dataPartenza;
	}

	public String getStatoSpedizione() {
		return this.statoSpedizione;
	}

	public String getFirma() {
		return this.firma;
	}

	public String getNumeroColli() {
		return this.numeroColli;
	}

	public String getPeso() {
		return this.peso;
	}
}