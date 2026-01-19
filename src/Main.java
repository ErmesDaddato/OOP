import entita.*;
import gestori.Laboratorio;
import interfacce.Enigma;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Laboratorio caricaDati() throws Exception{
        Scanner input = new Scanner(new FileInputStream("input.txt"));
        String sezione1 = "", sezione2 = "", sezione3= "";
        input.useDelimiter("###");
        if(input.hasNext()){
            sezione1 = input.next();
        }
        if (input.hasNext()){
            sezione2 = input.next();
        }
        if(input.hasNext()){
            sezione3 = input.next();
        }
        input.close();

        //Creare laboratorio finale
        List<ElementoRicerca> listaElementiRicerca = new ArrayList<>();
        List<Enigma> listaEnigmi = new ArrayList<>();

        String[] righeSezione1 = sezione1.split("\n");
        for(String riga : righeSezione1){
            try{
                String[] elementi = riga.trim().split(",");
                int numeroElementi = elementi.length;
                int numeroInventario = numeroElementi - 3;
                List<String> listaInventario = new ArrayList<>();
                for(int i = 0; i < elementi.length; i++){
                    if(i>1 && i<numeroElementi-1){
                        listaInventario.add(elementi[i]);
                    }
                }
                Sopravvissuto sopravvissuto = new Sopravvissuto(elementi[0], Integer.parseInt(elementi[1]), listaInventario, elementi[numeroElementi-1]);
                listaElementiRicerca.add(sopravvissuto);
            }catch(Exception ignored){}
        }

        String[] righeSezione2 = sezione2.split("\n");
        for (String riga : righeSezione2){
            try{
                String[] elementi = riga.trim().split(",");
                switch (elementi[0]){
                    case "EnigmaChiave":
                        EnigmaChiave enigmaChiave = new EnigmaChiave(elementi[1], elementi[2], elementi[3]);
                        listaEnigmi.add(enigmaChiave);
                        break;

                    case "EnigmaCodice":
                        EnigmaCodice enigmaCodice = new EnigmaCodice(elementi[1], elementi[2], elementi[3]);
                        listaEnigmi.add(enigmaCodice);
                        break;
                }
            }catch(Exception ignored){}
        }


        String[] righeSezione3 = sezione3.split("\n");
        for (String riga : righeSezione3){
            try{
                String[] elementi = riga.trim().split(",");
                Mostro mostro = new Mostro(elementi[0], Integer.parseInt(elementi[1]), Integer.parseInt(elementi[2]));
                listaElementiRicerca.add(mostro);
            }catch (Exception ignored){}
        }

        return new Laboratorio(listaEnigmi, listaElementiRicerca);
    }



    public static void task1(Laboratorio laboratorio){
        try{
            List<Sopravvissuto> listaSopravvissuti = laboratorio.getListaSopravvissuti();
            for(Sopravvissuto sopravvissuto : listaSopravvissuti){
                System.out.println(sopravvissuto.getNome() + ", " + sopravvissuto.getNumeroInventario() + ", " + sopravvissuto.getAbilita());
            }
        }catch (Exception ignored){}
        System.out.println("###");
    }

    public static void task2(Laboratorio laboratorio){
        try{
            List<Sopravvissuto> listaSopravvissuti = laboratorio.getListaSopravvissuti();
            List<Enigma> listaEnigmi = laboratorio.getListaEnigmi();
            for(Sopravvissuto sopravvissuto : listaSopravvissuti){
                List<String> listaInventario = sopravvissuto.getInventario();
                List<String> enigmiRisolvibili = new ArrayList<>();
                for (Enigma enigma : listaEnigmi){ //Enigma risolvibile se la chiave è presente nell'inventario del sopravvissuto
                    String chiave = enigma.getChiave();
                    if(listaInventario.contains(chiave) && !enigmiRisolvibili.contains(enigma.toString())){
                        enigmiRisolvibili.add(enigma.toString());
                    }
                }
                System.out.println(sopravvissuto.getNome() + ", " + enigmiRisolvibili);
            }
        }catch (Exception ignored){}
        System.out.println("###");
    }


    public static void task3(Laboratorio laboratorio){
        List<Mostro> listaMostri = laboratorio.getListaMostri();
        List<String> mostriRisolti = new ArrayList<>();
        try{
            for(Mostro mostro : listaMostri){
                if (!mostriRisolti.contains(mostro.getNome())){
                    int numeroMostri = laboratorio.countMostri(listaMostri, mostro.getNome());
                    int forzaComplessiva = laboratorio.countForzaMostroComplessiva(listaMostri, mostro.getNome());
                    System.out.println(mostro.getNome() + ": " + numeroMostri + ", " + forzaComplessiva);
                    mostriRisolti.add(mostro.getNome());
                }
            }
        }catch (Exception ignored){}
    }

    public static void main(String[] args){
        try{
            Laboratorio laboratorio = caricaDati();
            task1(laboratorio);
            task2(laboratorio);
            task3(laboratorio);
        }catch (Exception ignored){}
    }
}
