package entita;

public class Mostro extends ElementoRicerca{
    private int danno;

    public Mostro(String nome, int salute, int danno){
        super(nome, salute);
        this.danno = danno;
    }

    public int getDanno(){
        return danno;
    }
    public int getForza(){
        return this.danno + super.getSalute();
    }
}
