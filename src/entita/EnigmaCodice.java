package entita;

import interfacce.Enigma;

public class EnigmaCodice implements Enigma {
    private String posizione;
    private String codiceSegreto;
    private String oggettoCollegato;

    public EnigmaCodice(String posizione, String codiceSegreto, String oggettoCollegato){
        this.posizione = posizione;
        this.codiceSegreto = codiceSegreto;
        this.oggettoCollegato = oggettoCollegato;
    }

    public String getOggettoCollegato(){
        return oggettoCollegato;
    }
    public String getChiave(){
        return codiceSegreto;
    }
    public String getPosizione(){
        return posizione;
    }
    @Override
    public String toString(){
        return "EnigmaCodice";
    }
}
