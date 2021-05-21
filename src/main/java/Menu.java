import java.util.Scanner;

public class Menu {

    public Menu() {
    }

    public void getMenu(){
        System.out.println();
        System.out.println("* ---------------------------- *");
        System.out.println("| -------- MENU : ------------ |");
        System.out.println("| 1) Aggiungi Contatto.        |");
        System.out.println("| 2) Modifica Contatto.        |");
        System.out.println("| 3) Cancella Contatto.        |");
        System.out.println("| 4) Importa Json.             |");
        System.out.println("| 5) Esporta Json.             |");
        System.out.println("| 7) Stampa Rubrica.           |");
        System.out.println("| 8) Cancella un File.         |");
        System.out.println("| 9) Torna al menu precedente. |");
        System.out.println("* ---------------------------- *");
    }

    public int setAction(){
        System.out.print("Fai la tua scelta -> ");
        int scelta = -1;
        try{
            scelta = new Scanner(System.in).nextInt();
        }catch(Exception e) {
            return -1;
        }

        return scelta;
    }

    public void getMenuMap(){
        System.out.println();
        System.out.println("* --------------------------- *");
        System.out.println("| ------- MENU MAPPA -------- |");
        System.out.println("| 1) Popola rubrica.          |");
        System.out.println("| 2) Aggiungi ruolo.          |");
        System.out.println("| 3) Stampa Mappa.            |");
        System.out.println("| 4) Esporta Mappa.           |");
        System.out.println("| 5) Importa Mappa.           |");
        System.out.println("| 6) Salva file properties.   |");
        System.out.println("| 0) Esci.                    |");
        System.out.println("* --------------------------- *");
    }


}
