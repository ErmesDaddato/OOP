import entita.Segnale;
import gestori.GestoreCerebroImpl;
import interfacce.GestoreCerebro;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){

        List<Segnale> listaSegnali = new ArrayList<>();
        GestoreCerebroImpl gestoreCerebro = new GestoreCerebroImpl();
        try{
            gestoreCerebro.caricaDati(listaSegnali);
            gestoreCerebro.task1(listaSegnali);
            gestoreCerebro.task2();
            gestoreCerebro.task3(listaSegnali);
        }catch (Exception e){
            System.out.println("File non trovato");
        }
    }
}
