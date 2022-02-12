package inout;

import model.DictionaryEntry;
import model.command.*;
import utilities.Colors;
import utilities.Printer;

import java.util.Scanner;

public class Inputer {
    public static Scanner scanner = new Scanner(System.in);

    public static Command listenForCommand() {
        Printer.println();
        String commandString = inputString("Nhập câu lệnh: ");
        int firstSpaceIndex = commandString.indexOf(" ");

        String function;
        String parameter;
        if (firstSpaceIndex == -1){
            function = commandString;
            parameter = "";
        } else {
            function = commandString.substring(0, firstSpaceIndex);
            parameter = commandString.substring(firstSpaceIndex);
            parameter = parameter.trim();
        }

        switch (function){
            case Command.QUIT:
                return new QuitCommand(function, parameter);
            case Command.HELP:
                return new HelpCommand(function, parameter);
            case Command.SEARCH:
            case Command.SEARCH_SHORTCUT:
                return new SearchCommand(function, parameter);
            case Command.LOOKUP:
            case Command.LOOKUP_SHORTCUT:
                return new LookUpCommand(function, parameter);
            case Command.ADD:
            case Command.ADD_SHORTCUT:
                return new AddCommand(function, parameter);
            case Command.DELETE:
            case Command.DELETE_SHORTCUT:
                return new DeleteCommand(function, parameter);
            case Command.SHOW:
                return new ShowCommand(function, parameter);
            case Command.SAVE:
                return new SaveCommand(function, parameter);
            case Command.IMPORT:
                return new ImportCommand(function, parameter);
            default:
                return new InvalidCommand(function, parameter);
        }
    }

    public static boolean confirm(String msg) {
        char CHAR_YES = 'y';

        Printer.println(msg);
        Printer.print("Nhập <Y/N>: ", Colors.YELLOW);
        char choice = scanner.nextLine().charAt(0);
        return choice == CHAR_YES;
    }

    public static String inputString(String msg) {
        if (msg.length() > 0)
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
