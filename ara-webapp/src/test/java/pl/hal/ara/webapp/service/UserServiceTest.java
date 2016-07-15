package pl.hal.ara.webapp.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.hal.ara.core.database.UserDAO;
import pl.hal.ara.core.model.Email;
import pl.hal.ara.core.model.Password;
import pl.hal.ara.core.model.User;
import pl.hal.ara.webapp.exception.InvalidUserDataException;
import pl.hal.ara.webapp.utils.validator.UserValidator;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserValidator userValidator;
    @Mock
    private UserDAO userDAO;

    @Test
    public void testAddUser_ValidData() {
        //given
        User user = new User("test", new Email("test@tst.cp"), new Password("12345678"));
        when(userValidator.hasErrors()).thenReturn(false);

        //when
        userService.addUser("test", "test@tst.cp", "12345678");

        //then
        verify(userDAO).save(user);
    }

    @Test(expected = InvalidUserDataException.class)
    public void testAddUser_InvalidUsername() {
        //given
        when(userValidator.hasErrors()).thenReturn(true);

        //when
        userService.addUser("***", "test@tst.cp", "12345678");

        //then
        //exception should be thrown

    }

    @Test(expected = InvalidUserDataException.class)
    public void testAddUser_InvalidEmail() {
        //given
        when(userValidator.hasErrors()).thenReturn(true);

        //when
        userService.addUser("***", "test-tst.cp", "12345678");

        //then
        //exception should be thrown
    }

    @Test(expected = InvalidUserDataException.class)
    public void testAddUser_InvalidPassword() {
        //given
        when(userValidator.hasErrors()).thenReturn(true);

        //when
        userService.addUser("test", "test@tst.cp", "1234567");

        //then
        //exception should be thrown
    }
}
