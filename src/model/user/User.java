package model.user;

import java.io.Serializable;

public class User implements Serializable {
    public static final String ROLE_ADMIN = "admin";
    public static final String ROLE_GUEST = "guest";

    private String username;
    private String password;
    private String role;

    public User() {
        this.username = ROLE_GUEST;
        this.role = ROLE_GUEST;
    }

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
