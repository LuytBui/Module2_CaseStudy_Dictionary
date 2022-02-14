package model.user;

import model.command.Command;
import model.command.DeleteCommand;
import model.command.ImportCommand;
import utilities.Colors;
import utilities.Printer;
import view.Main;

public class CommandProxy {
    public static boolean execute(Command command) {
        boolean restrictedCommand =
                command instanceof DeleteCommand ||
                        command instanceof ImportCommand;

        boolean isAdmin = Main.currentUser.getRole().equals(User.ROLE_ADMIN);

        if (!restrictedCommand) {
            command.execute();
            return true;
        }

        // if restricted command
        if (isAdmin) {
            command.execute();
            return true;
        } else {
            Printer.print("Phải là admin để thực hiện lệnh này!", Colors.RED);
            return false;
        }
    }
}
