package it.frared.glsitaly.model;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "InfoLabel")
public class InfoResponse {

	@JacksonXmlProperty(localName = "Parcel")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<ParcelResponse> parcels;

	public List<ParcelResponse> getParcels() {
		return this.parcels;
	}

	public void setParcels(List<ParcelResponse> parcels) {
		this.parcels = parcels;
	}
}