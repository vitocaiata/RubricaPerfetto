package unit;


import models.Account;
import models.Rubrica;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import utils.Utils;

import java.util.ArrayList;
import static org.junit.Assert.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

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

    @ParameterizedTest(name = "Aggiungo contatti : {0} ")
    @CsvSource({"85203ead-7e87-429b-a06d-c9445460f9b3, vito, caiata, vc, 348"})
    @DisplayName("test aggiungi account")
    @Tag("account")
    @Order(1)
    void aggiungiCsv(String uid,String nome,String cognome,String email, String tel){
        Account persona1 = new Account(uid,nome,cognome,email,tel);
        Rubrica rubrica = new Rubrica(arrayListAccount);

        rubrica.save(persona1);
        rubrica.printAll(arrayListAccount);
    }


    @Test
    @DisplayName("Aggiungi un account")
    @Tag("account")
    @Order(2)
    public void test_001_aggiungi(){
        Rubrica rubrica = new Rubrica(arrayListAccount);
        rubrica.save(persona1);
    }

    @Test
    @DisplayName("Aggiungi un account")
    @Tag("account")
    @Order(3)
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
    @Tag("account")
    @Order(4)
    public void test_003_cerca(){
        Rubrica rubrica = new Rubrica(arrayListAccount);
        arrayListAccount.add(persona1);


        ArrayList<Account> risultatoFake = new ArrayList<>();
        risultatoFake.add(persona1);

        assertEquals(risultatoFake,rubrica.search("caiata"));
    }


    @Test
    @DisplayName("Ricerca con doppio risultato")
    @Tag("account")
    @Order(5)
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
    @Tag("account")
    @Order(6)
    public void test_005_cerca(){
        Rubrica rubrica = new Rubrica(arrayListAccount);
        arrayListAccount.add(persona1);
        arrayListAccount.add(persona2);

        ArrayList<Account> risultatoFake = new ArrayList<>();

        assertEquals(risultatoFake,rubrica.search("topolino"));
    }

    @Test
    @DisplayName("Rimuovi un account")
    @Tag("account")
    @Order(7)
    public void test_006_rimuoviSingolo(){
        Rubrica rubrica = new Rubrica(arrayListAccount);
        arrayListAccount.add(persona1);

        rubrica.del("caiata");
    }

    @Test
    @DisplayName("Rimuovi tutti gli account stesso cognome")
    @Tag("account")
    @Order(8)
    public void test_007_rimuoviTutti(){
        Rubrica rubrica = new Rubrica(arrayListAccount);
        arrayListAccount.add(persona1);
        arrayListAccount.add(persona2);

        rubrica.deleteAll(arrayListAccount);
    }

    @Test
    @DisplayName("Modifica account")
    @Tag("account")
    @Order(9)
    public void test_008_modifica(){
        Rubrica rubrica = new Rubrica(arrayListAccount);
        arrayListAccount.add(persona1);

        rubrica.update("caiata",persona1);
    }

    @Disabled
    @ParameterizedTest(name = "{0}")
    @ValueSource(strings = {"\\" + "Topolino.logs"})
    @DisplayName("crea file")
    @Tag("file")
    @Order(10)
    void writeFile(String nomeFile){
        Utils.createFile(nomeFile,"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam nisi tortor, mollis in lacinia et, scelerisque a augue. Phasellus et efficitur felis. Morbi posuere orci vitae velit efficitur, et lacinia justo tincidunt. Maecenas sem lectus, egestas euismod metus quis, congue lacinia ante. Aliquam lobortis magna dolor, vel euismod libero semper et. In hac habitasse platea dictumst. Vestibulum nunc nulla, tincidunt a eros a, congue efficitur nunc. Proin semper neque arcu, eu feugiat nulla interdum sit amet. Vestibulum posuere faucibus lorem sit amet congue. Pellentesque molestie pretium nisl ut accumsan. Integer at sodales dolor. Proin consectetur feugiat dui, in egestas felis consequat sed.");
    }

    @Disabled
    @ParameterizedTest(name = "{0}")
    @ValueSource(strings = {"\\"+ "Pippo.logs"})
    @DisplayName("New file")
    @Tag("file")
    @Order(11)
    void newFile(String nomeFile){
        assertEquals(true,Utils.nuovoFile(nomeFile));
    }

    @Disabled
    @ParameterizedTest(name = "{0}")
    @ValueSource(strings = {"\\"+ "Pippo.logs"})
    @DisplayName("cancella file")
    @Tag("file")
    @Order(12)
    void deleteFile(String nomeFile){
        Utils.cancellaFile(nomeFile);
    }

    @Disabled
    @ParameterizedTest(name = "{0}")
    @ValueSource(strings = {"\\" + "Topolino.logs"})
    @DisplayName("Leggi file")
    @Tag("file")
    @Order(13)
    void leggiFile(String nomeFile){
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam nisi tortor, mollis in lacinia et, scelerisque a augue. Phasellus et efficitur felis. Morbi posuere orci vitae velit efficitur, et lacinia justo tincidunt. Maecenas sem lectus, egestas euismod metus quis, congue lacinia ante. Aliquam lobortis magna dolor, vel euismod libero semper et. In hac habitasse platea dictumst. Vestibulum nunc nulla, tincidunt a eros a, congue efficitur nunc. Proin semper neque arcu, eu feugiat nulla interdum sit amet. Vestibulum posuere faucibus lorem sit amet congue. Pellentesque molestie pretium nisl ut accumsan. Integer at sodales dolor. Proin consectetur feugiat dui, in egestas felis consequat sed.",Utils.leggiFile(nomeFile));
    }

    @AfterEach
    void afterEach(){}

    @AfterAll
    static void afterAll(){}


}
