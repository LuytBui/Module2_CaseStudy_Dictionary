package controller;

import inout.DataReader;
import model.user.User;

import java.util.ArrayList;
import java.util.List;

public class UserManagement {
    private List<User> allUsers;
    private static UserManagement instance;

    private UserManagement() {
        this.allUsers = new ArrayList<>();
    }

    public static UserManagement getInstance() {
        if (UserManagement.instance == null)
            UserManagement.instance = new UserManagement();
        return UserManagement.instance;
    }

    public void importUsers(){
        List<User> list = DataReader.importUsers();
        allUsers.addAll(list);
    }

    public boolean isAdmin(User user){
        return user.getRole().equalsIgnoreCase(User.ROLE_ADMIN);
    }

    public void addUser(User user){
        allUsers.add(user);
    }

    public List<User> getAllUsers() {
        return allUsers;
    }

    public boolean usernameExist(String username){
        for (User user: allUsers){
            if (user.getUsername().equals(username))
                return true;
        }
        return false;
    }

    public User login(String username, String password){
        for (User user: allUsers){
            boolean match = user.getUsername().equals(username)
                    && user.getPassword().equals(password);
            if (match)
                return user;
        }
        return null;
    }
}
