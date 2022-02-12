package model.command;

import controller.DictManagement;
import controller.DictionaryFacade;
import model.DictionaryEntry;

public class LookUpCommand extends Command{
    public LookUpCommand(String function, String parameter) {
        super(function, parameter);
    }

    @Override
    public void execute() {
        String keyword = getParameter("Nhập từ khóa: ");
        DictionaryEntry entry = DictManagement.getInstance().lookup(keyword);
        DictManagement.getInstance().printEntry(entry);
    }
}
