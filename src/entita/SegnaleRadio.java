package entita;

public class SegnaleRadio extends Segnale{
    private boolean criptato;
    private int ripetizioni;

    public SegnaleRadio(String id, double frequenza, int intensita, boolean criptato, int ripetizioni){
        super(id, frequenza, intensita);
        this.criptato = criptato;
        this.ripetizioni = ripetizioni;
    }

    public boolean isCriptato(){
        return criptato;
    }
    public int getRipetizioni(){
        return ripetizioni;
    }
    @Override
    public double calcolaLivelloMinaccia(){
        return this.getIntensita()*(this.ripetizioni)*(this.isCriptato()?2:1);
    }
}
