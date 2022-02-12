package model.command;

import inout.DataWriter;

public class SaveCommand extends Command{
    public SaveCommand(String function, String parameter) {
        super(function, parameter);
    }

    @Override
    public void execute() {
        DataWriter.saveDictionary();
    }
}
