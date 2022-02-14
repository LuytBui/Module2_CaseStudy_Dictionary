package model.command;

import controller.DictManagement;
import inout.Inputer;
import model.DictionaryEntry;

public class LookUpCommand extends Command{
    public LookUpCommand(String function, String parameter) {
        super(function, parameter);
    }

    @Override
    public void execute() {
        String keyword = Inputer.getParameter(this, "Nhập từ khóa: ");
        DictionaryEntry entry = DictManagement.getInstance().lookup(keyword);
        DictManagement.getInstance().printEntry(entry);
    }
}
