import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testFindUserById() {

        MockitoAnnotations.openMocks(this);


        User mockUser = new User(1, "John Doe");
        when(userRepository.findUserById(1)).thenReturn(mockUser);


        User result = userService.findUserById(1);


        assertEquals(1, result.getId());
        assertEquals("John Doe", result.getName());
    }
}


//Question no 8 test class