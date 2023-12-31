package it.frared.glsitaly.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SpedizioneStatoResponse {

	public static final class SpedizioneStatus {
		public static final String TRASMESSA = "909";
		public static final String PARTITA_SEDE_MITTENTE = "902";
		public static final String IN_TRANSITO = "903";
		public static final String ARRIVATA_SEDE_DESTINATARIO = "904";
		public static final String IN_CONSEGNA = "905";
		public static final String CONSEGNA_CONCORDATA = "14";
		public static final String CONSEGNA_PREVISTA = "17";
		public static final String CONSEGNA_PREVISTA_GS = "28";
		public static final String DISPONIBILE_PER_RITIRO = "80";
		
		public static final String CONSEGNATA = "906";
	}
	
	private LocalDateTime datetime;
	private String luogo;
	private String stato;
	private String note;
	private String codice;

	
}
