package it.frared.glsitaly.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ParcelResponse {

	@JacksonXmlProperty(localName = "Result", isAttribute = true)
	private String result;
	@JacksonXmlProperty(localName = "WarningDescription", isAttribute = true)
	private String warningDescription;
	@JacksonXmlProperty(localName = "Code", isAttribute = true)
	private String code;
	@JacksonXmlProperty(localName = "NumeroSpedizione")
	private String numeroSpedizione;
	@JacksonXmlProperty(localName = "TotaleColli")
	private int totaleColli;
	@JacksonXmlProperty(localName = "ProgressivoCollo")
	private int progressivoCollo;
	@JacksonXmlProperty(localName = "DescrizioneSedeDestino")
	private String descrizioneSedeDestino;

	@JacksonXmlProperty(localName = "NumeroDiSpedizioneGLSDaConfermare")
	private String numeroDiSpedizioneGLSDaConfermare;
	@JacksonXmlProperty(localName = "esito")
	private String esito;

	public boolean isError() {
		return "ERRORE".equals(descrizioneSedeDestino);
	}
}