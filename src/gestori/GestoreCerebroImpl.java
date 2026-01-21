package gestori;

import entita.CanaleComunicazione;
import entita.Segnale;
import entita.SegnaleParanormale;
import entita.SegnaleRadio;
import interfacce.GestoreCerebro;

import java.io.FileInputStream;
import java.util.*;
import java.util.stream.Collectors;

public class GestoreCerebroImpl implements GestoreCerebro {
    List<CanaleComunicazione<?>> listaCanali = new ArrayList<>();

    public GestoreCerebroImpl(){}

    public void caricaDati(List<Segnale> listaSeganli) throws Exception{
        Scanner input = new Scanner(new FileInputStream("input.txt"));
        String sezione1= "", sezione2="", sezione3="";
        input.useDelimiter("###");
        if(input.hasNext()){
            sezione1 = input.next();
        }
        if(input.hasNext()){
            sezione2 = input.next();
        }
        if(input.hasNext()){
            sezione3 = input.next();
        }
        input.close();

        String[] sezione1righe = sezione1.split("\n");
        for(String riga: sezione1righe){
            try{
                String[] elementi = riga.trim().split(",");
                SegnaleRadio segnale = new SegnaleRadio(elementi[0], Double.parseDouble(elementi[1]), Integer.parseInt(elementi[2]), Boolean.parseBoolean(elementi[3]), Integer.parseInt(elementi[4]));
                listaSeganli.add(segnale);
            }catch (Exception ignored){}
        }

        String[] sezione2righe = sezione2.split("\n");
        for(String riga: sezione2righe){
            try{
                String[] elementi = riga.trim().split(",");
                SegnaleParanormale segnale = new SegnaleParanormale(elementi[0], Double.parseDouble(elementi[1]), Integer.parseInt(elementi[2]), elementi[3], Boolean.parseBoolean(elementi[4]));
                listaSeganli.add(segnale);
            }catch (Exception ignored){}
        }

        String[] sezione3righe = sezione3.split("\n");
        for(String riga: sezione3righe){
            try{
                String[] elementi = riga.trim().split(",\\[");
                String[] elementi1 = elementi[0].split(",");
                switch (elementi1[1]){
                    case "RADIO":
                        List<SegnaleRadio> listaSegnaliRadio = new ArrayList<>();
                        String elementi2 = elementi[1].substring(0, elementi[1].length()-1);
                        String[] seganali = elementi2.split(",");
                        for(String s: seganali){
                            SegnaleRadio segnaleRadio = (SegnaleRadio) getSegnale(listaSeganli, s);
                            listaSegnaliRadio.add(segnaleRadio);
                        }
                        CanaleComunicazione<SegnaleRadio> canaleRadio = new CanaleComunicazione<>(elementi1[0], listaSegnaliRadio);
                        listaCanali.add(canaleRadio);
                        break;

                    case "PARANORMALE":
                        List<SegnaleParanormale> listaSegnaliParanormali = new ArrayList<>();
                        String elementi2P = elementi[1].substring(0, elementi[1].length()-1);
                        String[] seganaliP = elementi2P.split(",");
                        for(String s: seganaliP){
                            SegnaleParanormale segnaleParanormale = (SegnaleParanormale) getSegnale(listaSeganli, s);
                            listaSegnaliParanormali.add(segnaleParanormale);
                        }
                        CanaleComunicazione<SegnaleParanormale> canaleParanormale = new CanaleComunicazione<>(elementi1[0], listaSegnaliParanormali);
                        listaCanali.add(canaleParanormale);
                        break;
                }
            }catch (Exception ignored){}
        }
    }

    @Override
    public Segnale getSegnale(List<Segnale> listaSegnali, String segnale) {
        return listaSegnali.stream().filter(s -> s.getId().equals(segnale)).findFirst().orElse(null);
    }

    @Override
    public CanaleComunicazione<?> getCanale(Segnale segnale) {
        return listaCanali.stream().filter(c -> c.getListaSegnali().contains(segnale)).findFirst().orElse(null);
    }


    @Override
    public void task1(List<Segnale> listaSeganli) {
        try{
            LinkedList<Segnale> listaSegnaliOrdinati = listaSeganli.stream().sorted(Comparator.comparing(Segnale::getId)).collect(Collectors.toCollection(LinkedList::new));
            for(Segnale s: listaSegnaliOrdinati){
                String tipo = "";
                if (s instanceof SegnaleRadio){
                    tipo = "(Radio)";
                }else if (s instanceof SegnaleParanormale){
                    tipo = "(Paranormale)";
                }
                System.out.println(s.getId() + " " + tipo + ": " + s.calcolaLivelloMinaccia());
            }
        }catch (Exception ignored){}
        System.out.println("###");
    }


    @Override
    public void task2() {
        try{
            LinkedList<CanaleComunicazione<?>> listaCanaliOrdinati = listaCanali.stream().sorted(Comparator.comparingDouble((CanaleComunicazione<?> c) -> c.getSommaMinaccia()).reversed()).collect(Collectors.toCollection(LinkedList::new));
            for(CanaleComunicazione<?> c: listaCanaliOrdinati){
                System.out.println(c.getNomeCanale() + ": " + c.getListaSegnali().size() + " segnali - Minaccia Totale: " + c.getSommaMinaccia() );
            }
        }catch (Exception ignored){}
        System.out.println("###");
    }

    @Override
    public void task3(List<Segnale> listaSeganli) {
        try{
            Map<Segnale, CanaleComunicazione<?>> listaSegnaliCritici = new HashMap<>();
            for (Segnale s: listaSeganli){
                if(s.calcolaLivelloMinaccia() > 100){
                    listaSegnaliCritici.put(s, getCanale(s));
                }
            }
            LinkedHashMap<Segnale, CanaleComunicazione<?>> listaSegnaliCriticiOrdinati = listaSegnaliCritici.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(CanaleComunicazione::getNomeCanale))).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
            for(Map.Entry<Segnale, CanaleComunicazione<?>> entry: listaSegnaliCriticiOrdinati.entrySet()){
                System.out.println("[" + entry.getValue().getNomeCanale() + "] " + entry.getKey().getId() + " - RILEVATA MINACCIA ESTREMA");
            }
        }catch (Exception ignored){}
    }


}
