package it.frared.glsitaly.model;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "RisultatiRitiri")
public class PickupsResponse {

	@JacksonXmlElementWrapper(useWrapping = false)
	@JacksonXmlProperty(localName = "RitiroCreato")
	private List<PickupResponse> pickups;

	public List<PickupResponse> getPickups() {
		return this.pickups;
	}
}
