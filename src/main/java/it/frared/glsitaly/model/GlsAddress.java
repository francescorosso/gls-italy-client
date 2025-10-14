package it.frared.glsitaly.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GlsAddress {

    @JacksonXmlProperty(localName = "SiglaRegione")
    private String SiglaRegione;

    @JacksonXmlProperty(localName = "DescrizioneRegione")
    private String DescrizioneRegione;

    @JacksonXmlProperty(localName = "SiglaProvincia")
    private String SiglaProvincia;

    @JacksonXmlProperty(localName = "DescrizioneProvincia")
    private String DescrizioneProvincia;

    @JacksonXmlProperty(localName = "Cap")
    private String Cap;

    @JacksonXmlProperty(localName = "Frazione")
    private String Frazione;

    @JacksonXmlProperty(localName = "Comune")
    private String Comune;

    @JacksonXmlProperty(localName = "Indirizzo")
    private String Indirizzo;

    @JacksonXmlProperty(localName = "InoltroInProvincia")
    private String InoltroInProvincia;

    @JacksonXmlProperty(localName = "KmDistanzaSede")
    private String KmDistanzaSede;

    @JacksonXmlProperty(localName = "Sede")
    private String Sede;

    @JacksonXmlProperty(localName = "Zona")
    private String Zona;

    @JacksonXmlProperty(localName = "TempoDiResa")
    private String TempoDiResa;

    @JacksonXmlProperty(localName = "LocalitaDisagiata")
    private String LocalitaDisagiata;

    @JacksonXmlProperty(localName = "ZTL")
    private String ZTL;

    @JacksonXmlProperty(localName = "Express12")
    private String Express12;

    @JacksonXmlProperty(localName = "IdentPIN")
    private String IdentPIN;

    @JacksonXmlProperty(localName = "LocalitaSaturdayExpress")
    private String LocalitaSaturdayExpress;

    @JacksonXmlProperty(localName = "GiorniPercorso")
    private String GiorniPercorso;

    @JacksonXmlProperty(localName = "SaturdayExpressEffettuabile")
    private String SaturdayExpressEffettuabile;
}
