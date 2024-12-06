// package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class UserManagerTest {
    private UserService userServiceMock;
    private UserManager userManager;

    @BeforeEach
    void setUp() {
        userServiceMock = mock(UserService.class);
        userManager = new UserManager(userServiceMock);
    }

    @Test
    void testRegisterUser_ValidUser_SuccessfulRegistration() {
        String username = "validUser";
        String password = "securePassword";

        when(userServiceMock.usernameExists(username)).thenReturn(false);
        when(userServiceMock.saveUser(username, password)).thenReturn(true);

        boolean result = userManager.registerUser(username, password);

        assertTrue(result);
        verify(userServiceMock).usernameExists(username);
        verify(userServiceMock).saveUser(username, password);
    }
}
