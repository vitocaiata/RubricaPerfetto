package utils;

import java.io.File;

public class GlobalParameters {

    public static final String USER_DIR = System.getProperty("user.dir");
    public static final String SRC_DIR = USER_DIR + File.separator + "src";

    public static final String MAIN_DIR = SRC_DIR + File.separator + "main";
    public static final String RESOURCES_PATH = MAIN_DIR + File.separator + "resources";
    public static final String PROPERTIES_PATH = RESOURCES_PATH + File.separator + "properties";
    public static String EXT_JSON = ".json";
    public static String EXT_PROPERTIES = ".properties";



}

