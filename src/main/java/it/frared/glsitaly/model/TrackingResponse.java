package it.frared.glsitaly.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class TrackingResponse {

	private String Data;
	private String Ora;
	private String Luogo;
	private String Stato;
	private String Note;
	private String Codice;
}