package utils;

import java.io.*;
import java.util.Properties;

import static utils.GlobalParameters.*;

public class Utils {

    //public static String BASE_PATH = "C:/Users/vitoc/Desktop/Corso Aesys/Esercizi/Rubrica perfetto/src/main/";
    //public static String RESOURCES_PATH = BASE_PATH + File.separator + "resources" + File.separator  ;
    //public static String EXT_JSON = ".json";

    public static String readFile(String fileName) {

        String bodyFile = "";
        FileReader reader = null;
        String path = RESOURCES_PATH + File.separator + fileName + EXT_JSON;

        try {
            reader = new FileReader(RESOURCES_PATH + File.separator + fileName + EXT_JSON);
            int i = 0;
            while (i != -1) {
                i = reader.read();
                if (i != -1) {
                    bodyFile = bodyFile + (char) i;
                }
            }
        } catch (IOException e) {
            System.err.println("Errore lettura File " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("Errore lettura File " + e.getMessage());
                }
            }
        }
        return bodyFile;
    }

    public static void writeFile(String fileName, String body){
        String path = RESOURCES_PATH + File.separator + fileName + EXT_JSON;

        try{
            File file  = new File(path);
            FileWriter fw = new FileWriter(file);
            fw.write(body);
            fw.flush();
            fw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void writeFileProp(String fileName, String body){
        try{
            String path = RESOURCES_PATH + File.separator + "properties" + File.separator + fileName + ".properties";
            File file  = new File(path);
            FileWriter fw = new FileWriter(file);
            fw.write(body);
            fw.flush();
            fw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void deleteFile(String fileName) {
        File file = new File(RESOURCES_PATH + fileName + EXT_JSON);
        if (file.delete()) {
            System.out.println("Il file " + fileName + " ?? stato cancellato");
        } else {
            System.out.println("Il file " + fileName + " non pu?? essere eliminato");
        }
    }

    public static boolean newFile(String fileName){

        String path = USER_DIR + "/" + fileName + EXT_JSON;
        try{
            File file = new File(path);
            if(file.exists()){
                System.out.println("Il file " + path + " esiste");
            }else if(file.createNewFile()){
                System.out.println("Il file " + path +" ?? stato creato.");
                return true;
            }else{
                System.out.println("Il file " + " non pu?? essere creato.");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return false;
    }

    public static Properties loadProp(String propName){

        String appPropPath = RESOURCES_PATH + File.separator + "properties" + File.separator + propName + ".properties";
        Properties prop = new Properties();

        try{
            prop.load(new FileInputStream(appPropPath));
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("File " + propName + " non trovato.");
        }
        return prop;
    }


// metodi per i test
    public static void cancellaFile(String fileName) {
        File file = new File(LOGS_PATH + fileName);
        if (file.delete()) {
            System.out.println("Il file " + fileName + " ?? stato cancellato");
        } else {
            System.out.println("Il file " + fileName + " non pu?? essere eliminato");
        }
    }

    public static boolean nuovoFile(String fileName){

        String path = LOGS_PATH + File.separator + fileName ;
        try{
            File file = new File(path);
            if(file.exists()){
                System.out.println("Il file " + path + " esiste");
            }else if(file.createNewFile()){
                System.out.println("Il file " + path +" ?? stato creato.");
                return true;
            }else{
                System.out.println("Il file " + " non pu?? essere creato.");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return false;
    }

    public static void createFile(String fileName, String body) {
        String ciao = LOGS_PATH ;

        try {
            File file = new File(ciao,fileName);
            FileWriter fw = new FileWriter(file);
            fw.write(body);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String leggiFile(String fileName) {

        String bodyFile = "";
        FileReader reader = null;
        String path = LOGS_PATH + File.separator + fileName ;

        try {
            reader = new FileReader(LOGS_PATH + File.separator + fileName);
            int i = 0;
            while (i != -1) {
                i = reader.read();
                if (i != -1) {
                    bodyFile = bodyFile + (char) i;
                }
            }
        } catch (IOException e) {
            System.err.println("Errore lettura File " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("Errore lettura File " + e.getMessage());
                }
            }
        }
        return bodyFile;
    }


    /*public static void deleteFile(String fileName) {
        if (!fileName.endsWith("\\")) {
            File file = new File(RESOURCES_PATH + fileName + EXT_JSON);
            if(file.delete()){
                System.out.println("File Cancellato " + file.getName());
            }else{
                System.out.println("Impossibile eliminare il file " + fileName);
            }
        }
    }
     */
}
