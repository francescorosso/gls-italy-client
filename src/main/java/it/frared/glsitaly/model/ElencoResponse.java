package it.frared.glsitaly.model;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "ELENCO")
public class ElencoResponse {

	@JacksonXmlProperty(localName = "SPEDIZIONE")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<SpedizioneResponse> spedizioni;

	@JacksonXmlProperty(localName = "RITIRO")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<RitiroResponse> ritiri;


	public List<SpedizioneResponse> getSpedizioni() {
		return this.spedizioni;
	}

	public List<RitiroResponse> getRitiri() {
		return this.ritiri;
	}
}