package unit;


import models.Account;
import models.Rubrica;
import org.junit.jupiter.api.*;
;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestCRUDRubrica {

    public static Account persona1;
    public static Account persona2;
    public static Account persona3;
    public static ArrayList<Account> arrayListAccount;

    @BeforeAll
    static void beforeAll(){

        persona1 = new Account("85203ead-7e87-429b-a06d-c9445460f9b3","vito","caiata","vc","348");
        persona2 = new Account("85203ead-7e87-429b-a06d-c9445460f9b3","pippo","caiata","pp","843");
        persona3 = new Account("85203ead-7e87-429b-a06d-c9445460f9b3","pippo","pluto","pp","843");

    }

    @BeforeEach
    void beforeEach(){
        arrayListAccount = new ArrayList<Account>();
    }

    @Test
    @DisplayName("Aggiungi un account")
    public void test_001_aggiungi(){
        Rubrica rubrica = new Rubrica(arrayListAccount);

        rubrica.save(persona1);
    }

    @Test
    @DisplayName("Aggiungi un account")
    public void test_002_aggiungi(){
        Rubrica rubrica = new Rubrica(arrayListAccount);

        rubrica.save(persona1);
        boolean check = false;
        ArrayList<Account> listaAccount = rubrica.getArrayListAccount();

        for(Account account : listaAccount){
            if(persona1 == account){
                check = true;
            }
        }

        assertTrue("Account non presente",check);
    }

    @Test
    @DisplayName("Ricerca con singolo risultato")
    public void test_003_cerca(){
        Rubrica rubrica = new Rubrica(arrayListAccount);
        arrayListAccount.add(persona1);


        ArrayList<Account> risultatoFake = new ArrayList<>();
        risultatoFake.add(persona1);

        assertEquals(risultatoFake,rubrica.search("caiata"));
    }


    @Test
    @DisplayName("Ricerca con doppio risultato")
    public void test_004_cerca(){
        arrayListAccount.add(persona1);
        arrayListAccount.add(persona2);

        Rubrica rubrica = new Rubrica(arrayListAccount);

        ArrayList<Account> risultatoFake = new ArrayList<>();
        risultatoFake.add(persona1);
        risultatoFake.add(persona2);

        assertEquals(risultatoFake,rubrica.search("caiata"));
    }

    @Test
    @DisplayName("Ricerca con nessun risultato")
    public void test_005_cerca(){
        Rubrica rubrica = new Rubrica(arrayListAccount);
        arrayListAccount.add(persona1);
        arrayListAccount.add(persona2);

        ArrayList<Account> risultatoFake = new ArrayList<>();

        assertEquals(risultatoFake,rubrica.search("topolino"));
    }

    @Test
    @DisplayName("Rimuovi un account")
    public void test_006_rimuoviSingolo(){
        Rubrica rubrica = new Rubrica(arrayListAccount);
        arrayListAccount.add(persona1);

        rubrica.del("caiata");
    }

    @Test
    @DisplayName("Rimuovi tutti gli account stesso cognome")
    public void test_007_rimuoviTutti(){
        Rubrica rubrica = new Rubrica(arrayListAccount);
        arrayListAccount.add(persona1);
        arrayListAccount.add(persona2);

        rubrica.deleteAll(arrayListAccount);
    }

    @Test
    @DisplayName("Modifica account")
    public void test_008_modifica(){
        Rubrica rubrica = new Rubrica(arrayListAccount);
        arrayListAccount.add(persona1);

        rubrica.update("caiata",persona1);
    }

    @AfterEach
    void afterEach(){}

    @AfterAll
    static void afterAll(){}


}
