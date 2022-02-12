package model.command;

import controller.DictManagement;
import controller.DictionaryFacade;
import inout.Inputer;
import model.DictionaryEntry;
import utilities.Colors;
import utilities.Printer;

public class DeleteCommand extends Command{
    public DeleteCommand(String function, String parameter) {
        super(function, parameter);
    }

    @Override
    public void execute() {
        String keyword = getParameter("Nhập từ khoá: ");
        DictionaryEntry searchResult = DictManagement.getInstance().findEntry(keyword);

        if (searchResult == null) {
            Printer.print("Không tìm thấy từ khóa ");
            Printer.println(keyword, Colors.KEYWORD_COLOR);
            return;
        }

        boolean confirm = Inputer.confirm("Bạn có muốn xóa từ khóa "
                + Printer.coloredText(keyword, Colors.KEYWORD_COLOR)
                + " không?"
        );

        if (confirm) {
            DictManagement.getInstance().deleteEntry(searchResult);
            Printer.println("Đã xóa");
        } else {
            Printer.println("Huỷ");
        }
    }
}
