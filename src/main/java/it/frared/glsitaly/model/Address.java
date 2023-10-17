package it.frared.glsitaly.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Address {

	private String SiglaRegione;
	private String DescrizioneRegione;
	private String SiglaProvincia;
	private String DescrizioneProvincia;
	private String Cap;
	private String Frazione;
	private String Comune;
	private String Indirizzo;
	private String InoltroInProvincia;
	private String KmDistanzaSede;
	private String Sede;
	private String Zona;
	private String TempoDiResa;
	private String LocalitaDisagiata;
	private String ZTL;
	private String Express12;
	private String IdentPIN;
	private String LocalitaSaturdayExpress;
	private String GiorniPercorso;
	private String SaturdayExpressEffettuabile;
}
