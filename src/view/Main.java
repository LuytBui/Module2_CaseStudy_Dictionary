package view;

import controller.UserManagement;
import inout.DataReader;
import inout.Inputer;
import model.command.Command;
import model.user.CommandProxy;
import model.user.User;
import utilities.Colors;
import utilities.Printer;

public class Main {

    public static boolean exit = false;
    public static User currentUser;

    public static void main(String[] args) {
        UserManagement.getInstance().importUsers();
        currentUser = new User();

        DataReader.readDictionary();

        greeting();

        while (!exit) {
            Command command = Inputer.listenForCommand();
            CommandProxy.execute(command);
        }


    }

    public static void greeting(){
        Printer.println("---------------------------------------", Colors.SYSTEM_MSG_COLOR);
        Printer.println("Chương trinh tra cứu thuật ngữ trong Java", Colors.SYSTEM_MSG_COLOR);
        Printer.println("---- WELCOME ----", Colors.SYSTEM_MSG_COLOR);
        Printer.println("---------------------------------------", Colors.SYSTEM_MSG_COLOR);

    }
}
