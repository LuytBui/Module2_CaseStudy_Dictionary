package model.command;

import controller.DictManagement;
import controller.DictionaryFacade;
import inout.DataReader;
import inout.Inputer;
import model.DictionaryEntry;
import utilities.Printer;

import java.util.List;

public class ImportCommand extends Command{
    public ImportCommand(String function, String parameter) {
        super(function, parameter);
    }

    @Override
    public void execute() {
        String source = getParameter("Nhập tên file: ");
        List<DictionaryEntry> dictionaryEntryList
                = DataReader.readEntryListFromFile(source);

        if (dictionaryEntryList.size() == 0)
            return;

        DictManagement.getInstance().printListEntry(dictionaryEntryList);
        Printer.println("Tìm được " + dictionaryEntryList.size() + " chỉ mục bên trên.");
        boolean confirm = Inputer.confirm("Import toàn bộ vào CSDL?");
        if (confirm) {
            DictManagement.getInstance().importList(dictionaryEntryList);
            Printer.println("Đã import");
        } else {
            Printer.println("Hủy");
        }
    }
}
