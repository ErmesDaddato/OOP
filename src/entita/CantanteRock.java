package entita;

public class CantanteRock extends Cantante{
    private int potenza;

    public CantanteRock(String nome, int energia, int puntiPrestazione, int potenza){
        super(nome, energia, puntiPrestazione);
        this.potenza = potenza;
    }

    @Override
    public int getPerformance() {
        return this.potenza;
    }
}
