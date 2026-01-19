package entita;

import interfacce.Enigma;

public class EnigmaChiave implements Enigma {
    private String posizione;
    private String chiave;
    private String oggettoCollegato;

    public EnigmaChiave(String posizione, String chiave, String oggettoCollegato){
        this.posizione = posizione;
        this.chiave = chiave;
        this.oggettoCollegato = oggettoCollegato;
    }

    public String getOggettoCollegato(){
        return oggettoCollegato;
    }
    public String getChiave(){
        return chiave;
    }
    public String getPosizione(){
        return posizione;
    }
    @Override
    public String toString(){
        return "EnigmaChiave";
    }
}
