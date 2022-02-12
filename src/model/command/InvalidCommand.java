package model.command;

import utilities.Colors;
import utilities.Printer;

public class InvalidCommand extends Command{
    public InvalidCommand(String function, String parameter) {
        super(function, parameter);
    }

    @Override
    public void execute() {
        Printer.printIndentLine("Sai cú pháp!", Colors.RED);
        Printer.printIndent("Dùng lệnh  ");
        Printer.print("help", Colors.FUNCTION_COLOR);
        Printer.print(" để xem hướng dẫn.\n");
    }
}
