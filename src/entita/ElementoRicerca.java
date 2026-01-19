package entita;

public abstract class ElementoRicerca {
    private String nome;
    private int salute;

    public ElementoRicerca(String nome, int salute){
        this.nome = nome;
        this.salute = salute;
    }

    public String getNome(){
        return nome;
    }
    public int getSalute(){
        return salute;
    }

}
