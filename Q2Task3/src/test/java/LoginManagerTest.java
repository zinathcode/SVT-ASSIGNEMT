import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LoginManagerTest {

    @Test
    void testLoginWithValidCredentials() throws Exception {
        AuthenticationService authService = mock(AuthenticationService.class);
        when(authService.authenticate("user", "pass")).thenReturn(true);

        LoginManager loginManager = new LoginManager(authService);
        assertTrue(loginManager.login("user", "pass"));

        verify(authService).authenticate("user", "pass");
    }

    @Test
    void testLoginWithNullInputsThrowsException() {
        AuthenticationService authService = mock(AuthenticationService.class);
        LoginManager loginManager = new LoginManager(authService);

        Exception exception = assertThrows(Exception.class, () -> loginManager.login(null, "pass"));
        assertEquals("Username and password cannot be null", exception.getMessage());
    }
}
