package model.command;

import controller.UserManagement;
import inout.DataWriter;
import inout.Inputer;
import model.user.User;
import utilities.Colors;
import utilities.Printer;

public class RegisterCommand extends Command {
    public RegisterCommand(String function, String parameter) {
        super(function, parameter);
    }

    @Override
    public void execute() {
        User newUser = Inputer.inputUser();
        UserManagement.getInstance().addUser(newUser);
        DataWriter.saveUsers();
        Printer.println("Save login info successfully!", Colors.GREEN);
    }

}
