package entita;

import java.util.List;

public class CanaleComunicazione <T extends Segnale>{
    private String nomeCanale;
    private List<T> listaSegnali;

    public CanaleComunicazione(String nomeCanale, List<T> listaSegnali){
        this.nomeCanale = nomeCanale;
        this.listaSegnali = listaSegnali;
    }
    public void addSegnale(T segnale){
        listaSegnali.add(segnale);
    }
    public String getNomeCanale(){
        return nomeCanale;
    }
    public double getSommaMinaccia(){
        return listaSegnali.stream().mapToDouble(Segnale::calcolaLivelloMinaccia).sum();
    }
    public List<T> getListaSegnali(){
        return listaSegnali;
    }
}
