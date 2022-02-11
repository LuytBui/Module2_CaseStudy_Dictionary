package controller;

import inout.DataReader;
import inout.Inputer;
import model.Command;
import model.DictionaryEntry;
import utilities.Colors;
import utilities.Printer;

import java.util.List;

public class DictionaryFacade {

    private static final DictionaryFacade instance = new DictionaryFacade();

    private DictionaryFacade() {
    }

    public static DictionaryFacade getInstance() {
        return instance;
    }

    public void executeSearch(Command command) {
        String keyword = getParameterFrom(command, "Nhập từ khóa");
        String msg = "Kết quả tìm kiếm: ";

        List<DictionaryEntry> list = DictManagement.getInstance().search(keyword);
        DictManagement.getInstance().printListKeyword(list, msg);
    }

    public void executeLookUp(Command command) {
        String keyword = getParameterFrom(command, "Nhập từ khóa");

        DictionaryEntry entry = DictManagement.getInstance().lookup(keyword);
        DictManagement.getInstance().printEntry(entry);
    }

    public void executeAddEntry(Command command) {
        String keyword = getParameterFrom(command, "Nhập từ khóa");

        DictionaryEntry entry = Inputer.inputEntry(keyword);
        DictManagement.getInstance().setEntry(entry);
    }

    public void executeShow(Command command) {
        if (command.getParameter().length() == 0) {
            DictManagement.getInstance().showAll();
            return;
        }
        String keyword = getParameterFrom(command, "Nhập từ khóa");

        List<DictionaryEntry> searchResult = DictManagement.getInstance().search(keyword);
        String EMPTY_LIST_ALERT = "Không có chỉ mục nào với từ khóa "
                + Printer.coloredText(keyword, Colors.KEYWORD_COLOR);
        if (searchResult.size() == 0)
            Printer.println(EMPTY_LIST_ALERT, Colors.RED);
        DictManagement.getInstance().printListEntry(searchResult);

    }

    public void executeDeleteEntry(Command command) {
        String keyword = getParameterFrom(command, "Nhập từ khóa");
        DictionaryEntry searchResult = DictManagement.getInstance().findEntry(keyword);

        if (searchResult == null) {
            Printer.print("Không tìm thấy từ khóa ");
            Printer.println(keyword, Colors.KEYWORD_COLOR);
            return;
        }

        boolean confirm = Inputer.confirm("Bạn có muốn xóa từ khóa "
                + Printer.coloredText(keyword, Colors.KEYWORD_COLOR)
                + "?"
        );

        if (confirm) {
            DictManagement.getInstance().deleteEntry(searchResult);
            Printer.println("Đã xóa");
        } else {
            Printer.println("Huỷ");
        }
    }

    public void executeImport(Command command) {
        String source = getParameterFrom(command, "Nhập tên file: ");
        List<DictionaryEntry> dictionaryEntryList
                = DataReader.readEntryListFromFile(source);

        if (dictionaryEntryList.size() == 0)
            return;

        DictManagement.getInstance().printListEntry(dictionaryEntryList);
        Printer.println("Tìm được " + dictionaryEntryList.size() + " chỉ mục bên trên.");
        boolean confirm = Inputer.confirm("Import toàn bộ vào CSDL?");
        if (confirm){
            DictManagement.getInstance().importList(dictionaryEntryList);
            Printer.println("Đã import");
        } else {
            Printer.println("Hủy");
        }
    }



    // hàm lấy ra parameter
    // nếu command có parameter thì lấy ra giá trị
    // nếu không thì bắt người dùng nhập thêm
    private String getParameterFrom(Command command, String msg) {
        String parameter = command.getParameter();
        if (parameter.length() == 0) {
            parameter = Inputer.inputString(msg);
        }
        return parameter;
    }
}
