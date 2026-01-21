package entita;

public class SegnaleParanormale extends Segnale{
    private String origine;
    private boolean presenzaSottosopra;

    public SegnaleParanormale(String id, double frequenza, int intensita, String origine, boolean presenzaSottosopra){
        super(id, frequenza, intensita);
        this.origine = origine;
        this.presenzaSottosopra = presenzaSottosopra;
    }
    @Override
    public double calcolaLivelloMinaccia(){
        return this.getIntensita() + (this.isPresenzaSottosopra()?150:0);
    }
    public String getOrigine(){
        return origine;
    }
    public boolean isPresenzaSottosopra(){
        return presenzaSottosopra;
    }
}
