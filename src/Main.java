import entita.*;
import gestori.GestoreFantasanremo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static Cantante trovaCantante(Set<Cantante> cantanti, String nome){
        return cantanti.stream().filter(c -> c.getNome().equals(nome)).findFirst().orElse(null);
    }


    public static GestoreFantasanremo caricaDati() throws FileNotFoundException {
        Scanner input = new Scanner(new File("input.txt"));
        input.useDelimiter("###");
        String sezione1 = "";
        String sezione2 = "";
        if(input.hasNext()){
            sezione1 = input.next();
        }
        if(input.hasNext()){
            sezione2 = input.next();
        }
        input.close();

        String[] righeSezione1 = sezione1.split("\n");
        Set<Cantante> listaCantanti = new HashSet<>();
        Set<Team> listaTeam = new HashSet<>();
        Set<Team<CantantePop>> listaTeamPop = new HashSet<>();
        Set<Team<CantanteRock>> listaTeamRock = new HashSet<>();
        Set<Team<CantanteJazz>> listaTeamJazz = new HashSet<>();
        for(String riga: righeSezione1){
            String[] elementi = riga.trim().split(",");
            try{
                switch (elementi[4]){
                    case "CantantePop":
                        Cantante c = new CantantePop(elementi[0], Integer.parseInt(elementi[1]), Integer.parseInt(elementi[2]), Integer.parseInt(elementi[3]));
                        listaCantanti.add(c);
                        break;
                    case "CantanteRock":
                        Cantante c2 = new CantanteRock(elementi[0], Integer.parseInt(elementi[1]), Integer.parseInt(elementi[2]), Integer.parseInt(elementi[3]));
                        listaCantanti.add(c2);
                        break;
                    case "CantanteJazz":
                        Cantante c3 = new CantanteJazz(elementi[0], Integer.parseInt(elementi[1]), Integer.parseInt(elementi[2]), Integer.parseInt(elementi[3]));
                        listaCantanti.add(c3);
                        break;
                }
            }catch(IndexOutOfBoundsException | NumberFormatException ignored){}
        }

        String[] righeSezione2 = sezione2.split("\n");

        for(String riga: righeSezione2){
            String[] elementi = riga.trim().split(",");
            try{
                String[] cantanti = elementi[1].split(";");
                Set<Cantante> setCantanti = new HashSet<>();
                for(String nomeCantante: cantanti){
                    if(trovaCantante(listaCantanti, nomeCantante) != null){
                        setCantanti.add(trovaCantante(listaCantanti, nomeCantante));
                    }
                }
                Team team = new Team(elementi[0], setCantanti, elementi[2]);
                listaTeam.add(team);
            }catch(Exception ignored){}
        }

        return new GestoreFantasanremo(listaCantanti, listaTeam);
    }

    public static void task1(GestoreFantasanremo gestore){
        for(Cantante cantante : gestore.getListaCantanti()){
            System.out.println(cantante.getNome() + ", " + cantante.getEnergia() + ", " + cantante.getPuntiPrestazione() + ", " + cantante.getPerformance());
        }
        System.out.println("###");

    }


    public static void task2(GestoreFantasanremo gestore){
        int punteggioPop = 0, punteggioRock = 0, punteggioJazz = 0;
        for (Team team : gestore.getListaTeam()) {
            switch (team.getStrategia()){
                case "PunteggioStrategyPop":
                    punteggioPop += team.getPunteggioTeam();
                    break;
                case "PunteggioStrategyRock":
                    punteggioRock += team.getPunteggioTeam();
                    break;
                case "PunteggioStrategyJazz":
                    punteggioJazz += team.getPunteggioTeam();
                    break;
            }
        }
        System.out.println("Pop: " + punteggioPop);
        System.out.println("Rock: " + punteggioRock);
        System.out.println("Jazz: " + punteggioJazz);
        System.out.println("###");
    }

    public static void task3(GestoreFantasanremo gestore){
        for(Team team : gestore.getListaTeam()){
            System.out.println(team.getNome() + ": " + team.calcolaBonusAttributoMedio() + ", Partecipanti: " + team.getCantanti());
        }
    }


    public static void main(String[] args){

        try{
            GestoreFantasanremo gestore = caricaDati();
            task1(gestore);
            task2(gestore);
            task3(gestore);

        }catch (FileNotFoundException e){
            System.out.println("File non trovato");
        }

    }
}
