package it.frared.glsitaly.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JacksonXmlRootElement(localName = "Info")
public class Info {

	@JacksonXmlProperty(localName = "SedeGls")
	private String sedeGls;
	@JacksonXmlProperty(localName = "CodiceClienteGls")
	private String codiceClienteGls;
	@JacksonXmlProperty(localName = "PasswordClienteGls")
	private String passwordClienteGls;
	@JacksonXmlProperty(localName = "AddParcelResult")
	private String addParcelResult;
	@JacksonXmlProperty(localName = "Parcel")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<Parcel> parcels;
	@JacksonXmlProperty(localName = "PickUpRequest")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<Pickup> pickups;
	@JacksonXmlProperty(localName = "DeletePickUp")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<DeletePickup> deletePickups;

	public Info parcel(Parcel parcel) {
		if (this.parcels == null) {
			this.parcels = new ArrayList<>();
		}
		this.parcels.add(parcel);
		return this;
	}

	public Info pickup(Pickup pickup) {
		if (this.pickups == null) {
			this.pickups = new ArrayList<>();
		}
		this.pickups.add(pickup);
		return this;
	}

	public Info deletePickup(DeletePickup pickup) {
		if (this.deletePickups == null) {
			this.deletePickups = new ArrayList<>();
		}
		this.deletePickups.add(pickup);
		return this;
	}
}