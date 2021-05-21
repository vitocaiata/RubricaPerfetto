import utils.Utils;

import java.util.ArrayList;
import java.util.Properties;

public class Run {

    public static void main(String[] args) {
        MenuMappa menuMappa = new MenuMappa();
        Rubrica rubrica = menuMappa.getRubrica();
        String properties = "";


        if(args.length>=0){

            try{
                for (int i = 0; i < args.length; i++) {
                    switch (args[i]) {
                        case "-import":
                            properties += args[i] + " = " + args[i+1] + "\n";
                            //prop.setProperty(args[i], args[i+1]);
                            //System.out.println(prop);
                            menuMappa.getRubrica().importMapJson(args[i + 1]);
                            break;
                        case "-export":
                            properties += args[i] + " = " +  args[i+1];
                            //prop.setProperty(args[i], args[i+1]);
                            //System.out.println(prop);
                            menuMappa.setNomeBk(args[i + 1]);
                            break;
                        case "-h":
                            System.out.println("HELP ME, PLEASE.");
                    }
                }
                Utils.writeFileProp("lukaku", properties);
                Properties prop = Utils.loadProp("lukaku");
            }catch(Exception e){
                System.out.println(e);
            }
        }
        menuMappa.menuMappa();
    }
}

    /*public static void decodeArgs(String[] args, Rubrica rubrica){
        MenuMappa menuMappa = new MenuMappa();
        for(int i = 0; i < args.length; i++){
            switch (args[i]){
                case "-import":
                    menuMappa.getRubrica().importMapJson(args[i+1]);
                    break;
                case "-export":
                    menuMappa.setNomeBk(args[i+1]);
                    break;
                case "-h":
                    System.out.println("HELP.");
                }
            }
        menuMappa.menuMappa();
    }


     */




