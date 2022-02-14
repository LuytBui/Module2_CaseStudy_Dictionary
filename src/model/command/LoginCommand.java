package model.command;

import controller.UserManagement;
import inout.DataReader;
import inout.Inputer;
import model.user.User;
import utilities.Printer;
import view.Main;

import java.util.List;

public class LoginCommand extends Command{
    public LoginCommand(String function, String parameter) {
        super(function, parameter);
    }

    @Override
    public void execute() {
        String username = Inputer.getParameter(this, "Nhập username: ");
        String password = Inputer.inputString("Nhập pasword: ");

        User loginUser = UserManagement.getInstance().login(username, password);
        if (loginUser != null){
            Main.currentUser = loginUser;
            Printer.println("Bạn đã đăng nhập với vai trò: " + Main.currentUser.getRole());
        } else {
            Printer.println("Đăng nhập không thành công.");
        }

    }
}
