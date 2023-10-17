package it.frared.glsitaly.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

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

	public String getSedeGls() {
		return this.sedeGls;
	}

	public void setSedeGls(String sedeGls) {
		this.sedeGls = sedeGls;
	}

	public String getCodiceClienteGls() {
		return this.codiceClienteGls;
	}

	public void setCodiceClienteGls(String codiceClienteGls) {
		this.codiceClienteGls = codiceClienteGls;
	}

	public String getPasswordClienteGls() {
		return this.passwordClienteGls;
	}

	public void setPasswordClienteGls(String passwordClienteGls) {
		this.passwordClienteGls = passwordClienteGls;
	}

	public String getAddParcelResult() {
		return this.addParcelResult;
	}

	public void setAddParcelResult(String addParcelResult) {
		this.addParcelResult = addParcelResult;
	}

	public List<Parcel> getParcels() {
		return this.parcels;
	}

	public void setParcels(List<Parcel> parcels) {
		this.parcels = parcels;
	}

	public List<Pickup> getPickups() {
		return this.pickups;
	}

	public void setPickups(List<Pickup> pickups) {
		this.pickups = pickups;
	}

	public List<DeletePickup> getDeletePickups() {
		return this.deletePickups;
	}

	public void setDeletePickups(List<DeletePickup> deletePickups) {
		this.deletePickups = deletePickups;
	}

	public Info sedeGls(String sedeGls) {
		setSedeGls(sedeGls);
		return this;
	}

	public Info codiceClienteGls(String codiceClienteGls) {
		setCodiceClienteGls(codiceClienteGls);
		return this;
	}

	public Info passwordClienteGls(String passwordClienteGls) {
		setPasswordClienteGls(passwordClienteGls);
		return this;
	}

	public Info addParcelResult(String addParcelResult) {
		setAddParcelResult(addParcelResult);
		return this;
	}

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