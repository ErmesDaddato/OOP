package entita;

import java.util.List;

public class Sopravvissuto extends ElementoRicerca{
    private List<String> inventario;
    private String abilita;

    public Sopravvissuto(String nome, int salute, List<String> inventario, String abilita){
        super(nome, salute);
        this.inventario = inventario;
        this.abilita = abilita;
    }

    public List<String> getInventario(){
        return inventario;
    }
    public String getAbilita(){
        return abilita;
    }
    public int getNumeroInventario(){
        return inventario.size();
    }
}
