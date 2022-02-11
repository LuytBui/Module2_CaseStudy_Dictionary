package inout;

import utilities.Colors;
import model.Command;
import model.DictionaryEntry;
import utilities.Printer;

import java.util.Scanner;

public class Inputer {
    public static Scanner scanner = new Scanner(System.in);

    public static Command listenForCommand() {
        Printer.println();
        Printer.print("Nhập câu lệnh: ");
        String commandString = scanner.nextLine();
        return new Command(commandString);
    }

    public static boolean confirm(String msg) {
        char CHAR_YES = 'y';

        Printer.println(msg);
        Printer.print("Nhập <Y/N>: ", Colors.YELLOW);
        char choice = scanner.nextLine().charAt(0);
        return choice == CHAR_YES;
    }

    public static String inputString(String msg) {
        Printer.print(msg);
        String string = scanner.nextLine();
        return string;
    }

    public static DictionaryEntry inputEntry() {
        String keyword = inputString("Nhập từ khóa: ");
        return inputEntry(keyword);
    }

    public static DictionaryEntry inputEntry(String keyword) {
        String content = inputContent(keyword);
        return new DictionaryEntry(keyword, content);
    }

    public static String inputContent(String keyword) {
        Printer.print("Nhập nội dung cho từ khóa ");
        Printer.println(keyword, Colors.KEYWORD_COLOR);
        Printer.println("\t kết thúc việc nhập bằng lệnh "
                + Printer.coloredText(Command.END_INPUT, Colors.FUNCTION_COLOR)
                + ")"
        );
        String content = "";
        String inputLine = scanner.nextLine();
        while (!inputLine.equals(Command.END_INPUT)) {
            content += inputLine + "\n";
            inputLine = scanner.nextLine();
        }
        content = content.trim();
        return content;
    }


}
