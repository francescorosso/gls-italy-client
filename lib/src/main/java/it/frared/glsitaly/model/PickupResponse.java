package it.frared.glsitaly.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class PickupResponse {

	@JacksonXmlProperty(localName = "NumeroRitiro", isAttribute = true)
	private String numeroRitiro;

	public String getNumeroRitiro() {
		return this.numeroRitiro;
	}
}