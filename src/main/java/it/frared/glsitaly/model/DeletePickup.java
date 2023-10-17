package it.frared.glsitaly.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class DeletePickup {
	
	@JacksonXmlProperty(localName = "CodiceContrattoGls")
	private String codiceContrattoGls;
	@JacksonXmlProperty(localName = "NumeroRitiro")
	private String numeroRitiro;
	@JacksonXmlProperty(localName = "NomeCognome")
	private String nomeCognome;
	@JacksonXmlProperty(localName = "Email")
	private String email;


	public String getCodiceContrattoGls() {
		return this.codiceContrattoGls;
	}

	public void setCodiceContrattoGls(String codiceContrattoGls) {
		this.codiceContrattoGls = codiceContrattoGls;
	}

	public String getNumeroRitiro() {
		return this.numeroRitiro;
	}

	public void setNumeroRitiro(String numeroRitiro) {
		this.numeroRitiro = numeroRitiro;
	}

	public String getNomeCognome() {
		return this.nomeCognome;
	}

	public void setNomeCognome(String nomeCognome) {
		this.nomeCognome = nomeCognome;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public DeletePickup codiceContrattoGls(String codiceContrattoGls) {
		setCodiceContrattoGls(codiceContrattoGls);
		return this;
	}

	public DeletePickup numeroRitiro(String numeroRitiro) {
		setNumeroRitiro(numeroRitiro);
		return this;
	}

	public DeletePickup nomeCognome(String nomeCognome) {
		setNomeCognome(nomeCognome);
		return this;
	}

	public DeletePickup email(String email) {
		setEmail(email);
		return this;
	}
}