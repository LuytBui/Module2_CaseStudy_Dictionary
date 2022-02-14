package inout;

import java.io.File;

public class DataService {
    public static final String DATA_FILE = "dictionary.dat";
    public static final String LOGIN_FILE = "login.dat";

    public static final File dataFile = new File(DATA_FILE);
    public static final File loginFile = new File(LOGIN_FILE);
}
