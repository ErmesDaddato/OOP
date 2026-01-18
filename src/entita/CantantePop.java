package entita;

public class CantantePop extends Cantante{
    private int carisma;

    public CantantePop(String nome, int energia, int puntiPrestazione, int carisma){
        super(nome, energia, puntiPrestazione);
        this.carisma = carisma;
    }

    @Override
    public int getPerformance() {
        return this.carisma;
    }
}
