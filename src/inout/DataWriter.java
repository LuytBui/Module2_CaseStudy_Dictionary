package inout;

import controller.DictManagement;
import utilities.Colors;
import utilities.Printer;

import java.io.*;

public class DataWriter extends DataService{

    public static boolean saveDictionary(){
        Printer.println("Saving data to file: " + dataFile, Colors.SYSTEM_MSG_COLOR);

        try {
            OutputStream os = new FileOutputStream(dataFile);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(DictManagement.getInstance().getDictionary());
            oos.close();
            os.close();
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }

        Printer.println("Success", Colors.GREEN);
        Printer.println();
        return true;
    }
}
