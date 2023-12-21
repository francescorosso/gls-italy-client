package it.frared.glsitaly.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TrackingResponse {

	private String Data;
	private String Ora;
	private String Luogo;
	private String Stato;
	private String Note;
	private String Codice;
}