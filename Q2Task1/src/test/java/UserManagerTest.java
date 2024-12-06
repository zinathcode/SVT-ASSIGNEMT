import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserManagerTest {

    @Test
    public void testRegisterUser_UserAlreadyExists() {
        UserService mockUserService = Mockito.mock(UserService.class);
        UserManager userManager = new UserManager(mockUserService);

        when(mockUserService.usernameExists("existingUser")).thenReturn(true);

        boolean result = userManager.registerUser("existingUser", "password");

        assertFalse(result);
        verify(mockUserService).usernameExists("existingUser");
        verify(mockUserService, never()).saveUser(anyString(), anyString());
    }
}
