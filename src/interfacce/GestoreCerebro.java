package interfacce;

import entita.CanaleComunicazione;
import entita.Segnale;

import java.util.List;
import java.util.Set;

public interface GestoreCerebro {
    public void caricaDati (List<Segnale> listaSeganli) throws Exception;
    public Segnale getSegnale(List<Segnale> listaSegnali,String segnale);
    public CanaleComunicazione<?> getCanale(Segnale segnale);
    public void task1(List<Segnale> listaSeganli);
    public void task2();
    public void task3(List<Segnale> listaSeganli);
}
