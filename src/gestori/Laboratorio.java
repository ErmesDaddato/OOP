package gestori;

import entita.ElementoRicerca;
import entita.Mostro;
import entita.Sopravvissuto;
import interfacce.Enigma;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Laboratorio {
    List<Enigma> listaEnigmi; //lista di oggetti che implementano l'interfaccia Enigma
    List<ElementoRicerca> listaElementiRicerca;

    public Laboratorio(List<Enigma> listaEnigmi, List<ElementoRicerca> listaElementiRicerca){
        this.listaEnigmi = listaEnigmi;
        this.listaElementiRicerca = listaElementiRicerca;
    }

    public List<Enigma> getListaEnigmi(){
        return listaEnigmi;
    }
    public List<ElementoRicerca> getListaElementiRicerca(){
        return listaElementiRicerca;
    }

    public List<Sopravvissuto> getListaSopravvissuti(){
        List<Sopravvissuto> listaSopravvissuti = new ArrayList<>();
        for(ElementoRicerca elementoRicerca : listaElementiRicerca){
            if(elementoRicerca instanceof Sopravvissuto)
                listaSopravvissuti.add((Sopravvissuto) elementoRicerca);
        }
        return listaSopravvissuti;
    }

    public List<Mostro> getListaMostri(){
        List<Mostro> listaMostri = new ArrayList<>();
        for(ElementoRicerca elementoRicerca : listaElementiRicerca){
            if(elementoRicerca instanceof Mostro)
                listaMostri.add((Mostro) elementoRicerca);
        }
        return listaMostri;
    }

    public int countMostri(List<Mostro> listaMostri, String nomeMostro){
        return (int) listaMostri.stream().filter(m -> m.getNome().equals(nomeMostro)).count();
    }
    public int countForzaMostroComplessiva(List<Mostro> listaMostri , String nomeMostro){
        return listaMostri.stream().filter(m -> m.getNome().equals(nomeMostro)).mapToInt(Mostro::getForza).sum();
    }
}
