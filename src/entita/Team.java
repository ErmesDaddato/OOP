package entita;

import java.util.Set;

public class Team <T extends Cantante>{
    private String nome;
    private Set<T> cantanti;
    private String strategia;

    public Team(String nome, Set<T> cantanti, String strategia){
        this.cantanti = cantanti;
        this.nome = nome;
        this.strategia = strategia;
    }

    public String getNome(){
        return nome;
    }

    public Set<T> getCantanti(){
        return cantanti;
    }

    public String getStrategia(){
        return strategia;
    }

    public void addCantante(T cantante){
        cantanti.add(cantante);
    }

    public void removeCantante(T cantante){
        cantanti.remove(cantante);
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Team){
            return this.nome.equals(((Team) obj).getNome());
        }else
            return false;
    }

    //Aggiungere metodo per calcolare forza Team
    public int calcolaBonusAttributoMedio(){
        int bonusAttributoMedio = 0;
        for(Cantante cantante : cantanti){
            bonusAttributoMedio += cantante.getPerformance();
        }
        return bonusAttributoMedio / cantanti.size();
    }


    public int getPunteggioTeam() {
        int punteggioTeam = 0;
        for(Cantante cantante : cantanti){
            punteggioTeam += cantante.getPuntiPrestazione();
        }
        return punteggioTeam;
    }
}
