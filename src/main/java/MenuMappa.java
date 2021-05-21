import models.Account;
import models.Ruolo;
import utils.Utils;


import java.util.*;

import static java.lang.System.exit;


public class MenuMappa {


    Menu menu = new Menu();
    Rubrica rubrica = new Rubrica(new ArrayList<>());
    ArrayList<Account> listaRubrica = new ArrayList<>();
    Map<Ruolo, ArrayList<Account>> mappa = rubrica.getMappa();
    String nomeBk = "";
    String importa;

    public Rubrica getRubrica() {
        return rubrica;
    }
    public void setRubrica(Rubrica rubrica) {
        this.rubrica = rubrica;
    }
    public String getNomeBk() {
        return nomeBk;
    }

    public void setNomeBk(String nomeBk) {
        this.nomeBk = nomeBk;
    }

    public void addRubrica(){
        Ruolo ruolo = new Ruolo(new Scanner(System.in).next());
        mappa.put(ruolo, rubrica.getArrayListAccount());
    }


    public void menuMappa(){

        Properties prop = Utils.loadProp("settings");
        importa = prop.getProperty("import.name");
        rubrica.importMapJson(importa);

        nomeBk = prop.getProperty("export.name");
        rubrica.exportMapJson(nomeBk);

        do {
            menu.getMenuMap();
            switch (menu.setAction()) {
                case 1:
                    if(this.mappa.isEmpty()){
                        System.out.println("\nAggiungi ruolo.");
                        addRubrica();
                    }else{
                        System.out.println("Quale ruolo vuoi riempire?");
                        String pippo = new Scanner(System.in).next();
                        for(Ruolo ruolo : mappa.keySet()){
                            rubrica.setArrayListAccount(mappa.get(ruolo));
                            scegliMenu(true);
                            mappa.put(ruolo,rubrica.getArrayListAccount());
                        }
                    }
                    break;
                case 2:
                    addRubrica();
                    break;
                case 3:
                    if (rubrica.getArrayListAccount().size() > 0) {
                        if (!mappa.isEmpty()) {
                            rubrica.printAll(mappa);
                        }
                    } else {
                        System.out.println("Mappa Vuota.");
                    }
                    break;
                case 4:
                    rubrica.exportMapJson("");
                    break;
                case 5:
                    rubrica.importMapJson("");
                    break;
                case 6:

                    break;
                case 0:
                    System.out.println("Uscita !");
                    exit(0);
            }
        } while (true);
    }

    public void scegliMenu(boolean statoMenu){

        do {
            menu.getMenu();
            switch(menu.setAction()){
                case 1:
                    rubrica.save(rubrica.addAccount());
                    break;
                case 2:
                    System.out.println("Inserisci il cognome del contatto da modificare : ");
                    rubrica.update(new Scanner(System.in).next(),rubrica.addAccount());
                    break;
                case 3:
                    System.out.println("Inserisci il cognome del contatto che vuoi eliminare : ");
                    rubrica.del(new Scanner(System.in).next());
                    break;
                case 4:
                    System.out.println("Inserisci il nome del file rubrica : ");
                    rubrica.importJson(new Scanner(System.in).next());
                    break;
                case 5:
                    if(nomeBk.length() > 0) {
                        rubrica.exportJson(nomeBk);
                    }else{
                        System.out.println("Inserisci il nome del file backup rubrica : ");
                        rubrica.exportJson(new Scanner(System.in).next());
                    }
                    break;
                case 6:
                    System.out.println("Inserisci il cognome da cercare : ");
                    ArrayList<Account> risultatoArrayList = new ArrayList<>();
                    risultatoArrayList = rubrica.search(new Scanner(System.in).next());
                    if(risultatoArrayList.size() <= 0){
                        System.err.println("Nessun cognome trovato.");
                    }else{
                        rubrica.printAll(risultatoArrayList);
                    }
                    break;
                case 7:
                    if(rubrica.getArrayListAccount().size() > 0) {
                        rubrica.printAll(rubrica.getArrayListAccount());
                    }else{
                        System.err.println("Rubrica vuota.");
                    }
                    break;
                case 8:
                    System.out.println("Inserisci il file che vuoi eliminare : ");
                    rubrica.deleteFile(new Scanner(System.in).next());
                    break;
                case 9:
                    System.out.println("Torna al menu precedente.");
                    statoMenu = false;
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }
        }while(statoMenu);

    }
}



