package gestori;

import entita.Cantante;
import entita.Team;
import interfacce.PunteggioStrategy;

import java.util.Set;

public class PunteggioStrategyJazz implements PunteggioStrategy {
    @Override
    public int calcolaPunteggio(Team team) {
        int forzaTeam = 0;
        Set<Cantante> cantanti = team.getCantanti();
        for(Cantante cantante : cantanti){
            forzaTeam += cantante.getPerformance();
        }
        return forzaTeam;
    }
}
