package model.command;

import controller.DictManagement;
import inout.Inputer;
import model.DictionaryEntry;

public class AddCommand extends Command {
    public AddCommand(String function, String parameter) {
        super(function, parameter);
    }

    @Override
    public void execute() {
        String keyword = Inputer.getParameter(this, "Nhập từ khóa: ");
        DictionaryEntry entry = Inputer.inputEntry(keyword);
        DictManagement.getInstance().setEntry(entry);
    }
}
