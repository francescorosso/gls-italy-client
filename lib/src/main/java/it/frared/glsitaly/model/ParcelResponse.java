package it.frared.glsitaly.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class ParcelResponse {

	@JacksonXmlProperty(localName = "Result", isAttribute = true)
	private String result;
	@JacksonXmlProperty(localName = "WarningDescription", isAttribute = true)
	private String warningDescription;
	@JacksonXmlProperty(localName = "Code", isAttribute = true)
	private String code;
	@JacksonXmlProperty(localName = "NumeroSpedizione")
	private String numeroSpedizione;
	@JacksonXmlProperty(localName = "TotaleColli")
	private int totaleColli;
	@JacksonXmlProperty(localName = "ProgressivoCollo")
	private int progressivoCollo;

	public String getResult() {
		return this.result;
	}

	public String getWarningDescription() {
		return this.warningDescription;
	}

	public String getCode() {
		return this.code;
	}

	public String getNumeroSpedizione() {
		return this.numeroSpedizione;
	}

	public int getTotaleColli() {
		return this.totaleColli;
	}

	public int getProgressivoCollo() {
		return this.progressivoCollo;
	}
}