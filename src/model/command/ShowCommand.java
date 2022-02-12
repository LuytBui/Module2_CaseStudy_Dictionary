package model.command;

import controller.DictManagement;
import controller.DictionaryFacade;
import model.DictionaryEntry;
import utilities.Colors;
import utilities.Printer;

import java.util.List;

public class ShowCommand extends Command {
    public ShowCommand(String function, String parameter) {
        super(function, parameter);
    }

    @Override
    public void execute() {
       if (this.parameter.length() == 0){
           DictManagement.getInstance().showAll();
           return;
       }

        String keyword = getParameter("Nhập từ khoá: ");
        List<DictionaryEntry> searchResult = DictManagement.getInstance().search(keyword);
        String EMPTY_LIST_ALERT = "Không có chỉ mục nào với từ khóa "
                + Printer.coloredText(keyword, Colors.KEYWORD_COLOR);
        if (searchResult.size() == 0)
            Printer.println(EMPTY_LIST_ALERT, Colors.RED);
        DictManagement.getInstance().printListEntry(searchResult);
    }
}
