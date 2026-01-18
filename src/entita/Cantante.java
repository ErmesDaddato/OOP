package entita;

public abstract class Cantante {
    private String nome;
    private int energia;
    private int puntiPrestazione;

    public Cantante(String nome, int energia, int puntiPrestazione){
        this.nome = nome;
        this.energia = energia;
        this.puntiPrestazione = puntiPrestazione;
    }

    public String getNome(){
        return nome;
    }

    public int getEnergia(){
        return energia;
    }

    public int getPuntiPrestazione(){
        return puntiPrestazione;
    }

    @Override   //Se due cantanti hanno lo stesso nome sono uguali, e non possono stare nello stesso Team
    public boolean equals(Object obj){
        if(obj instanceof Cantante){
            return this.nome.equals(((Cantante) obj).getNome());
        }else
            return false;
    }

    @Override
    public String toString(){
        return nome;
    }

    //Metodi astratti per gestione performance
    public abstract int getPerformance();
}
