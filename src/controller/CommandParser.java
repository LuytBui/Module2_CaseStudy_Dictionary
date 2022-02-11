package controller;

import model.Command;
import inout.DataWriter;
import utilities.Colors;
import utilities.Printer;
import view.Main;

public class CommandParser {

    public CommandParser() {
    }

    public boolean parseAndExecute(Command command) {

        if (!command.isValid()) {
            Printer.printIndentLine("Sai cú pháp!", Colors.RED);
            Printer.printIndent("Dùng lệnh  ");
            Printer.print("help", Colors.FUNCTION_COLOR);
            Printer.print(" để xem hướng dẫn.\n");
            return false;
        }

        switch (command.getFunction()){
            case Command.QUIT:
                DataWriter.saveDictionary();
                Printer.print("Goodbye!", Colors.PURPLE);
                Main.exit = true;
                break;
            case Command.HELP:
                Helper.printInstructions();
                break;
            case Command.SEARCH:
                DictionaryFacade.getInstance().executeSearch(command);
                break;
            case Command.LOOKUP:
                DictionaryFacade.getInstance().executeLookUp(command);
                break;
            case Command.ADD:
                DictionaryFacade.getInstance().executeAddEntry(command);
                break;
            case Command.DELETE:
                DictionaryFacade.getInstance().executeDeleteEntry(command);
                break;
            case Command.SHOW:
                DictionaryFacade.getInstance().executeShow(command);
                break;
            case Command.SAVE:
                DataWriter.saveDictionary();
                break;
            case Command.IMPORT:
                DictionaryFacade.getInstance().executeImport(command);
                break;
            default:
                break;

        }

        return true;
    }
}
