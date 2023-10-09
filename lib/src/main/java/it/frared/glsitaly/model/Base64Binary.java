package it.frared.glsitaly.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

@JacksonXmlRootElement(namespace = "https://labelservice.gls-italy.com/", localName = "base64Binary")
public class Base64Binary {

	@JacksonXmlText
	public String text;

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Base64Binary text(String text) {
		setText(text);
		return this;
	}
}