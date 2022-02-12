package model.command;

import inout.DataWriter;
import utilities.Colors;
import utilities.Printer;
import view.Main;

public class QuitCommand extends Command{
    public QuitCommand(String function, String parameter) {
        super(function, parameter);
    }

    @Override
    public void execute() {
        DataWriter.saveDictionary();
        Printer.print("Goodbye!", Colors.PURPLE);
        Main.exit = true;
    }
}
