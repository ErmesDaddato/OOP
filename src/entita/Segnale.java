package entita;

public abstract class Segnale {
    private String id;
    private double frequenza;
    private int intensita;

    public Segnale(String id, double frequenza, int intensita){
        this.id = id;
        this.frequenza = frequenza;
        this.intensita = intensita;
    }

    public String getId(){
        return id;
    }
    public double getFrequenza(){
        return frequenza;
    }
    public int getIntensita(){
        return intensita;
    }
    public abstract double calcolaLivelloMinaccia();

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Segnale){
            return this.id.equals(((Segnale)obj).getId());
        }else
            return false;
    }
}
