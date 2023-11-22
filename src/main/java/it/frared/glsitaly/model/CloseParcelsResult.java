package it.frared.glsitaly.model;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JacksonXmlRootElement(localName = "CloseWorkDayByShipmentNumberResult")
public class CloseParcelsResult {
	
	@JacksonXmlProperty(localName = "Parcel")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<ParcelResponse> parcels;
}
