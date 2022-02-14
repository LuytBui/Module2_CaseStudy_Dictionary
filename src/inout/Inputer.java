package inout;

import controller.UserManagement;
import model.DictionaryEntry;
import model.command.*;
import model.user.User;
import utilities.Colors;
import utilities.Printer;

import java.util.Scanner;

public class Inputer {
    public static Scanner scanner = new Scanner(System.in);

    public static Command listenForCommand() {
        final String PROMPT = "Nhập câu lệnh: ";
        Printer.println();
        String commandString = inputString(PROMPT);
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
            case Command.LOGIN:
                return new LoginCommand(function, parameter);
            case Command.REGISTER:
                return new RegisterCommand(function, parameter);
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


    public static String getParameter(Command command, String msg) {
        if (msg.length() == 0)
            return command.getParameter();
        if (command.getParameter().length() == 0) {
            command.setParameter(inputString(msg));
        }
        return command.getParameter();
    }

    public static User inputUser(){
        String username;

        boolean usernameExisted;
        do {
            username = inputString("Tên đăng nhập: ");
            usernameExisted = UserManagement.getInstance().usernameExist(username);
            if (usernameExisted)
                Printer.println("Tên đăng nhập này đã tồn tại!", Colors.RED);
        } while (validUsername(username) && !usernameExisted);

        String password = "";
        String reEnterPassword = "";
        boolean reEnterMatch;

        do {
            password = inputString("Mật khẩu: ");
            reEnterPassword = inputString("Nhập lại mật khẩu: ");
            reEnterMatch = password.equals(reEnterPassword);
            if (!reEnterMatch)
                Printer.println("Không khớp!", Colors.RED);
        } while (!validPassword(password) || !reEnterMatch);

        String role = inputString("Role: ");
        role = role.toLowerCase();
        return new User(username, password, role);
    }
    public static boolean validPassword(String password){
        if (password.length() < 6){
            Printer.println("Mật khẩu phải dài hơn 6 ký tự.", Colors.RED);
            return false;
        }
        return true;
    }
    public static boolean validUsername(String username){
        if (username.charAt(0) >= '0' && username.charAt(0) <= '9'){
            Printer.println("Tên đăng nhập không được bắt đầu bằng chữ số!", Colors.RED);
            return false;
        }
        return true;
    }
}
