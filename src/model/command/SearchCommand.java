package model.command;

import controller.DictManagement;
import controller.DictionaryFacade;
import model.DictionaryEntry;

import java.util.List;

public class SearchCommand extends Command{
    public SearchCommand(String function, String parameter) {
        super(function, parameter);
    }

    @Override
    public void execute() {
        String keyword = getParameter("Nhập từ khóa: ");
        String msg = "Kết quả tìm kiếm: ";

        List<DictionaryEntry> list = DictManagement.getInstance().search(keyword);
        DictManagement.getInstance().printListKeyword(list, msg);
    }
}
