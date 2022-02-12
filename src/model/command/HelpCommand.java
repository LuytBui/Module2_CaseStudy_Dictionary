package model.command;

import controller.Helper;
import inout.DataWriter;
import utilities.Colors;
import utilities.Printer;
import view.Main;

public class HelpCommand extends Command{
    public HelpCommand(String function, String parameter) {
        super(function, parameter);
    }

    @Override
    public void execute(){
        Helper.printInstructions();
    }
}
