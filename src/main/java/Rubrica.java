import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import interfaces.Actions;
import interfaces.Filters;
import models.Account;
import models.Modelli;
import models.Ruolo;
import utils.Utils;

import java.io.File;
import java.util.*;

public class Rubrica implements Actions, Filters {

    private Map<Ruolo, ArrayList<Account>> mappa = new HashMap<>();

    private ArrayList<Account> accountArrayList;

    public Rubrica() {
    }

    public Rubrica(Map<Ruolo, ArrayList<Account>> mappa) {
        this.mappa = mappa;
    }

    public Map<Ruolo, ArrayList<Account>> getMappa() {
        return mappa;
    }

    public void setMappa(Map<Ruolo, ArrayList<Account>> mappa) {
        this.mappa = mappa;
    }

    public Rubrica(ArrayList<Account> arrayListAccount){
        this.accountArrayList = arrayListAccount;
    }

    public ArrayList<Account> getArrayListAccount() {
        return accountArrayList;
    }

    public void setArrayListAccount(ArrayList<Account> arrayListAccount) {
        this.accountArrayList = arrayListAccount;
    }

    public void save(Account account) {
        this.accountArrayList.add(account);
        System.out.println("L'account è stato salvato.");
    }

    @Override
    public Account addAccount() {

        Scanner scanner = new Scanner(System.in);
        Account accountTemp = new Account();

        System.out.print("Inserisci il nome : ");
        accountTemp.setNome(scanner.next());
        System.out.print("Inserisci il cognome : ");
        accountTemp.setCognome(scanner.next());
        System.out.print("Inserisci la mail : ");
        accountTemp.setEmail(scanner.next());
        System.out.print("Inserisci il numero di telefono : ");
        accountTemp.setTel(scanner.next());

        return accountTemp;
    }

    public void update(String cognome, Account account) {
        if(this.accountArrayList.removeIf(e->e.getCognome().equals(cognome))){
            this.accountArrayList.add(account);
        }else{
            System.err.println("Nessun elemento trovato.");
        }


    }

    public ArrayList<Account> search(String cognome) {
        ArrayList<Account> risultatoArrayList = new ArrayList<Account>();
        for(Account account : this.accountArrayList){
            if(account.getCognome().equals(cognome)){
                risultatoArrayList.add(account);
            }
        }
        return risultatoArrayList;
    }

    public void deleteAll(ArrayList<Account> rimuoviAccountArrayList) {
        this.accountArrayList.removeAll(rimuoviAccountArrayList);
        System.out.println("Account eliminato con successo.");
    }

    public void del(String cognome){
        deleteAll(search(cognome));
    }

    public void exportJson(String fileName){
        Utils.writeFile(fileName, new Gson().toJson(this.accountArrayList));
        System.out.println("Rubrica : " + fileName + " esportata.");
    }

    public void importJson(String fileName) {
        try{
            this.accountArrayList.addAll(Arrays.asList(new Gson().fromJson(Utils.readFile(fileName), Account[].class)));
            System.out.println("Rubrica : " + fileName + " importata.");
        }catch(JsonSyntaxException e){
            System.err.println("Errore parsing file " + fileName);
        }catch (Exception e){
            System.err.println("Errore import file " + fileName);
        }

    }

    public void printAll(ArrayList<Account> arrayList) {
        for(Account account : arrayList){
            System.out.println();
            System.out.println("UUID : " + account.getStringUid());
            System.out.println("Nome : " + account.getNome());
            System.out.println("Cognome : " + account.getCognome());
            System.out.println("Email : " + account.getEmail());
            System.out.println("Telefono : " + account.getTel());
        }
    }

    @Override
    public void printAll(Map<Ruolo, ArrayList<Account>> mappa) {
        for(Map.Entry<Ruolo,ArrayList<Account>> entry : mappa.entrySet()){
            System.out.println(entry.getKey().getTipo()+ "\n");
            printAll(entry.getValue());
            System.out.println("---------------------");
        }
    }

    public void deleteFile(String fileName){
        Utils.deleteFile(fileName);
    }

    public void exportMapJson(String nomeFile){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Modelli> mappaArray = new ArrayList<Modelli>();

        if(nomeFile.length() == 0){
            System.out.println("Nome file da esportare : ");
            nomeFile = scanner.next();
        }


        for(Map.Entry<Ruolo, ArrayList<Account>> entry : mappa.entrySet()){
            mappaArray.add(new Modelli(entry.getKey(),entry.getValue()));
        }

        Utils.writeFile(nomeFile, new Gson().toJson(mappaArray));
        System.out.println("Esportato con successo.");
    }

    public void importMapJson(String nomeFile){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Modelli> mappaArray = new ArrayList<>();

        if(nomeFile.length() == 0){
            System.out.println("Nome file da importare : ");
            nomeFile = scanner.next();
        }


        mappaArray.addAll(Arrays.asList(new Gson().fromJson(Utils.readFile(nomeFile), Modelli[].class)));

        for(Modelli modello : mappaArray){
            mappa.put(modello.getRuolo(), modello.getAccountArrayList());
        }
        System.out.println("Importato con successo.");
    }

    /*public void exportMapJson(String nomeFile, Map<Ruolo, ArrayList<Account>> mappa){
        ArrayList<Modelli> mappaArray = new ArrayList<>();
        for(Map.Entry<Ruolo, ArrayList<Account>> entry : mappa.entrySet()){
            mappaArray.add(new Modelli(entry.getKey(),entry.getValue()));
        }
        Utils.writeFile(nomeFile, new Gson().toJson(mappaArray));
        System.out.println("Esportata mappa con successo.");
    }

    try {
            ArrayList<Modelli> mappaArray = new ArrayList<>();
            mappaArray.addAll(Arrays.asList(new Gson().fromJson(Utils.readFile(nomeFile), Modelli[].class)));
            System.out.println("Importata mappa con successo.");
            return mappaArray;
        } catch (JsonSyntaxException e) {
            System.err.println("Errore parsing file " + nomeFile);
        } catch (Exception e) {
            System.err.println("Errore import file " + nomeFile);
        }
        return new ArrayList<Modelli>();
    */
}
