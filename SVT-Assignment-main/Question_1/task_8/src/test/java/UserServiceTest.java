import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class UserServiceTest {
    private UserRepository userRepository;
    private UserService userService;

    @Before
    public void setUp() {
        userRepository = Mockito.mock(UserRepository.class); // Mock UserRepository
        userService = new UserService(userRepository);       // Inject into UserService
    }

    @Test
    public void testFindUserById() {
        // Arrange
        User user = new User(1, "John Doe");
        when(userRepository.findById(1)).thenReturn(user);

        // Act
        User result = userService.findUserById(1);

        // Assert
        assertEquals(user, result);

        // Verify
        verify(userRepository, times(1)).findById(1); // Ensure the repository method was called once
    }
}
