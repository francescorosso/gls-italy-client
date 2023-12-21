package it.frared.glsitaly.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Pickup {

	@JacksonXmlProperty(localName = "CodiceContrattoGls")
	private String codiceContrattoGls;
	@JacksonXmlProperty(localName = "NomeRichiedente")
	private String nomeRichiedente;
	@JacksonXmlProperty(localName = "Colli")
	private int colli;
	@JacksonXmlProperty(localName = "PesoReale")
	private double pesoReale;
	@JacksonXmlProperty(localName = "DataRitiro")
	private String dataRitiro;
	@JacksonXmlProperty(localName = "Dalle1")
	private String dalle1;
	@JacksonXmlProperty(localName = "Alle1")
	private String alle1;
	@JacksonXmlProperty(localName = "Dalle2")
	private String dalle2;
	@JacksonXmlProperty(localName = "Alle2")
	private String alle2;
	@JacksonXmlProperty(localName = "TipoCollo")
	private String tipoCollo;
	@JacksonXmlProperty(localName = "Clienteritiro")
	private String clienteRitiro;
	@JacksonXmlProperty(localName = "Indirizzoritiro")
	private String indirizzoRitiro;
	@JacksonXmlProperty(localName = "Localitaritiro")
	private String localitaRitiro;
	@JacksonXmlProperty(localName = "CAPritiro")
	private String capRitiro;
	@JacksonXmlProperty(localName = "Provinciaritiro")
	private String provinciaRitiro;
	@JacksonXmlProperty(localName = "EmailLuogoritiro")
	private String emailLuogoRitiro;
}