package inout;

import controller.DictManagement;
import controller.UserManagement;
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

    public static boolean saveUsers(){

        try {
            OutputStream os = new FileOutputStream(loginFile);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(UserManagement.getInstance().getAllUsers());
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
