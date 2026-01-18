package gestori;

import entita.Cantante;
import entita.Team;

import java.util.Set;

public class GestoreFantasanremo {
    private Set<Cantante> listaCantanti;
    private Set<Team> listaTeam;


    public GestoreFantasanremo( Set<Cantante> listaCantanti, Set<Team> listaTeam){
        this.listaCantanti = listaCantanti;
        this.listaTeam = listaTeam;
    }

    public Set<Cantante> getListaCantanti(){
        return listaCantanti;
    }

    public Set<Team> getListaTeam(){
        return listaTeam;
    }


    //Metodi per gestire Team e tenere traccia dei punteggi
}
