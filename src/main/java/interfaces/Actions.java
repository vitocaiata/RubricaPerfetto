package interfaces;

import models.Account;

import java.util.ArrayList;

public interface Actions {
    Account addAccount();
    void save(Account account);
    void update(String cognome,Account account);
    void deleteAll(ArrayList<Account> rimuoviAccountArrayList);
    void del(String cognome);

}
