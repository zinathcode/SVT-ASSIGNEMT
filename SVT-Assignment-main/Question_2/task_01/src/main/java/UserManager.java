// package com.example;

public class UserManager {
    private final UserService userService;

    public UserManager(UserService userService) {
        this.userService = userService;
    }

    public boolean registerUser(String username, String password) {
        if (userService.usernameExists(username)) return false;
        return userService.saveUser(username, password);
    }
}
