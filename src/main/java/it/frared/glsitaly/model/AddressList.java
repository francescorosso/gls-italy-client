package it.frared.glsitaly.model;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressList {

	@JacksonXmlProperty(localName = "Esito")
	private String esito;

	@JacksonXmlProperty(localName = "Address")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<Address> addresses;
}
