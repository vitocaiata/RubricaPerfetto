package models;

import java.util.ArrayList;

public class Modelli {

    private Ruolo ruolo;
    private ArrayList<Account> accountArrayList;

    public Modelli(Ruolo ruolo, ArrayList<Account> accountArrayList) {
        this.ruolo = ruolo;
        this.accountArrayList = accountArrayList;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }

    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }

    public ArrayList<Account> getAccountArrayList() {
        return accountArrayList;
    }

    public void setAccountArrayList(ArrayList<Account> accountArrayList) {
        this.accountArrayList = accountArrayList;
    }
}
