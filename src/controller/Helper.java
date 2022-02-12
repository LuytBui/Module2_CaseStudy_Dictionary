package controller;

import model.command.Command;
import utilities.Colors;
import utilities.Printer;

public class Helper {
    static String instructions = "";


    public static void printInstructions() {
        Printer.println("Câu lệnh      |       Công dụng");

        printBasicInstruction();

        printSearchInstruction();

        printLookUpInstruction();

        printAddInstruction();

        printDeleteInstruction();

    }

    public static void printAddInstruction() {
        // add
        Printer.print(Command.ADD, Colors.FUNCTION_COLOR);
        Printer.print("\t\t: Thêm chỉ mục \n");
        Printer.print(Command.ADD, Colors.FUNCTION_COLOR);
        Printer.print(" keyword", Colors.PARAMETTER_COLOR);
        Printer.print("\t\t: Thêm chỉ mục \n");
        Printer.printIndentLine("tạo mới hoặc thay đổi chỉ mục có sẵn");
    }
    public static void printDeleteInstruction() {
        // add
        Printer.print(Command.DELETE, Colors.FUNCTION_COLOR);
        Printer.print("\t\t: Xóa chỉ mục \n");
        Printer.print(Command.DELETE, Colors.FUNCTION_COLOR);
        Printer.print(" keyword", Colors.PARAMETTER_COLOR);
        Printer.print("\t\t: Xóa chỉ mục \n");
    }

    public static void printLookUpInstruction() {
        // lookup
        Printer.print(Command.LOOKUP, Colors.FUNCTION_COLOR);
        Printer.println("\t\t: Tra từ khóa ");
        Printer.print(Command.LOOKUP, Colors.FUNCTION_COLOR);
        Printer.print(" keyword", Colors.PARAMETTER_COLOR);
        Printer.print("\t\t: Tra từ khóa ");
        Printer.print("keyword\n", Colors.PARAMETTER_COLOR);
        Printer.printIndentLine("in ra chỉ mục liên quan nhất");
    }

    public static void printSearchInstruction() {
        // search
        Printer.print(Command.SEARCH, Colors.FUNCTION_COLOR);
        Printer.println("\t\t: Tìm kiếm ");
        Printer.print(Command.SEARCH, Colors.FUNCTION_COLOR);
        Printer.print(" keyword", Colors.PARAMETTER_COLOR);
        Printer.print("\t\t: Tìm kiếm theo ");
        Printer.print("keyword\n", Colors.PARAMETTER_COLOR);
        Printer.printIndentLine("in ra danh sách kết quả liên quan");
    }

    public static void printBasicInstruction(){
        Printer.print(Command.HELP, Colors.FUNCTION_COLOR);
        Printer.print("\t\t: In ra bảng hướng dẫn\n");
        Printer.print(Command.QUIT, Colors.FUNCTION_COLOR);
        Printer.print("\t\t: Thoát chương trình\n");
        Printer.print(Command.SHOW, Colors.FUNCTION_COLOR);
        Printer.print("\t\t: In toàn bộ từ điển\n");
    }

}
