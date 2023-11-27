package it.frared.glsitaly.model;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class SpedizioneResponse {

	@JacksonXmlProperty(localName = "NumSped")
	private String numSped;
	@JacksonXmlProperty(localName = "Bda")
	private String bda;
	@JacksonXmlProperty(localName = "DataPartenza")
	private String dataPartenza;
	@JacksonXmlProperty(localName = "StatoSpedizione")
	private String statoSpedizione;
	@JacksonXmlProperty(localName = "Firma")
	private String firma;
	@JacksonXmlProperty(localName = "NumeroColli")
	private String numeroColli;
	@JacksonXmlProperty(localName = "Peso")
	private String peso;

	@JacksonXmlProperty(localName = "TRACKING")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<Stato> tracking;
}