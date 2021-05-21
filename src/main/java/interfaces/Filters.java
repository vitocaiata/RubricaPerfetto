package interfaces;

import models.Account;
import models.Ruolo;

import java.util.ArrayList;
import java.util.Map;

public interface Filters {
    ArrayList<Account> search(String cognome);
    void exportJson(String fileName);
    void importJson(String fileName);
    void printAll(ArrayList<Account> arrayList);
    void printAll(Map<Ruolo, ArrayList<Account>> mappa);

}
