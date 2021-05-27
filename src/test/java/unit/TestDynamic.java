package unit;
import models.Account;
import models.Rubrica;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class TestDynamic {


  public static Account persona1 = new Account("85203ead-7e87-429b-a06d-c9445460f9b3","vito","caiata","vc","348");
  public static Account persona2 = new Account("85203ead-7e87-429b-a06d-c9445460f9b3","pippo","caiata","pp","843");
  public static Account persona3 = new Account("85203ead-7e87-429b-a06d-c9445460f9b3","pippo","pluto","pp","843");
  public static ArrayList<Account> arrayListAccount;

  @TestFactory
    Collection<DynamicTest> dynamicTestFromCollection(){
      return Arrays.asList(
              dynamicTest("1", ()-> Utils.createFile("Topolino.logs","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam nisi tortor, mollis in lacinia et, scelerisque a augue. Phasellus et efficitur felis. Morbi posuere orci vitae velit efficitur, et lacinia justo tincidunt. Maecenas sem lectus, egestas euismod metus quis, congue lacinia ante. Aliquam lobortis magna dolor, vel euismod libero semper et. In hac habitasse platea dictumst. Vestibulum nunc nulla, tincidunt a eros a, congue efficitur nunc. Proin semper neque arcu, eu feugiat nulla interdum sit amet. Vestibulum posuere faucibus lorem sit amet congue. Pellentesque molestie pretium nisl ut accumsan. Integer at sodales dolor. Proin consectetur feugiat dui, in egestas felis consequat sed.")),
              dynamicTest("2", ()-> assertEquals(true,Utils.nuovoFile("Pippo.logs"))),
              dynamicTest("3", ()-> Utils.cancellaFile("\\Pippo.logs")),
              dynamicTest("4", ()-> assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam nisi tortor, mollis in lacinia et, scelerisque a augue. Phasellus et efficitur felis. Morbi posuere orci vitae velit efficitur, et lacinia justo tincidunt. Maecenas sem lectus, egestas euismod metus quis, congue lacinia ante. Aliquam lobortis magna dolor, vel euismod libero semper et. In hac habitasse platea dictumst. Vestibulum nunc nulla, tincidunt a eros a, congue efficitur nunc. Proin semper neque arcu, eu feugiat nulla interdum sit amet. Vestibulum posuere faucibus lorem sit amet congue. Pellentesque molestie pretium nisl ut accumsan. Integer at sodales dolor. Proin consectetur feugiat dui, in egestas felis consequat sed.",Utils.leggiFile("Topolino.logs")))
      );
  }

  @TestFactory
  Collection<DynamicTest> dynamicTestAccount(){
    arrayListAccount = new ArrayList<>();
    Rubrica rubrica = new Rubrica(arrayListAccount);
    ArrayList<Account> risultatoFake = new ArrayList<>();
    ArrayList<Account> risultato = new ArrayList<>();
    risultatoFake.add(persona1);
    return Arrays.asList(
            dynamicTest("1 Aggiungi un Account", () -> rubrica.save(persona1)),
            dynamicTest("2 Cerca, un risultato", ()-> assertEquals(risultatoFake,rubrica.search("caiata"))),
            dynamicTest("3 Ricerca, nessun risultato", ()-> assertEquals(risultato,rubrica.search("topolino"))),
            dynamicTest("4 Update", ()->rubrica.update("caiata",persona1)),
            dynamicTest("5 Elimina", ()->rubrica.deleteAll(arrayListAccount))
    );
  }

  @TestFactory
  Stream<DynamicTest> dynamicTestStream(){
    return IntStream.of(3,6,7,12).mapToObj(value -> dynamicTest(value + " è un multiplo di 3", () -> assertEquals(0, value%3)));
  }
}
