package view;

import controller.CommandParser;
import inout.DataReader;
import inout.Inputer;
import model.Command;
import utilities.Colors;
import utilities.Printer;

public class Main {

    public static boolean exit = false;

    public static void main(String[] args) {
        DataReader.readDictionary();

        greeting();

        CommandParser commandParser = new CommandParser();

        while (!exit) {
            Command command = Inputer.listenForCommand();
            commandParser.parseAndExecute(command);
        }


    }

    public static void greeting(){
        Printer.println("---------------------------------------", Colors.SYSTEM_MSG_COLOR);
        Printer.println("Chương trinh tra cứu thuật ngữ trong Java", Colors.SYSTEM_MSG_COLOR);
        Printer.println("---- WELCOME ----", Colors.SYSTEM_MSG_COLOR);
        Printer.println("---------------------------------------", Colors.SYSTEM_MSG_COLOR);

    }
}
