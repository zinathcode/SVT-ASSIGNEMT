// package com.example;

public interface UserService {
    boolean usernameExists(String username);
    boolean saveUser(String username, String password);
}
