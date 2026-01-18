package entita;

public class CantanteJazz extends Cantante{
    private int improvvisazione;

    public CantanteJazz(String nome, int energia, int puntiPrestazione, int improvvisazione){
        super(nome, energia, puntiPrestazione);
        this.improvvisazione = improvvisazione;
    }

    @Override
    public int getPerformance() {
        return this.improvvisazione;
    }
}
