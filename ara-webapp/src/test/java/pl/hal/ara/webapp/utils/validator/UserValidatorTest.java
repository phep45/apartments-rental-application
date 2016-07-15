package pl.hal.ara.webapp.utils.validator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class UserValidatorTest {

    private UserValidator userValidator;

    @Before
    public void setUp() {
        userValidator = new UserValidator();
    }

    @Test
    public void testValidateUsername_LettersAndNumbersOnly() {
        //given
        String username = "testUsername123";

        //when
        userValidator.validateUsername(username);

        //then
        Assert.assertThat(userValidator.hasErrors(), is(false));
    }

    @Test
    public void testValidateUsername_SpecialCharacters() {
        //given
        String username = "tes$username_with&special()characters";

        //when
        userValidator.validateUsername(username);

        //then
        Assert.assertThat(userValidator.hasErrors(), is(true));
    }

    @Test
    public void testValidateEmail_validEmail() {
        //given
        String email = "test-valid@email.com";

        //when
        userValidator.validateEmail(email);

        //then
        Assert.assertThat(userValidator.hasErrors(), is(false));
    }

    @Test
    public void testValidateEmail_invalidEmail() {
        //given
        String email = "invalid-email format";

        //when
        userValidator.validateEmail(email);

        //then
        Assert.assertThat(userValidator.hasErrors(), is(true));
    }

    @Test
    public void testValidatePassword_AtLeast8Characters() {
        //given
        String password = "12345678";

        //when
        userValidator.validatePassword(password);

        //then
        Assert.assertThat(userValidator.hasErrors(), is(false));
    }

    @Test
    public void testValidatePassword_LessThan8Characters() {
        //given
        String password = "1234567";

        //when
        userValidator.validatePassword(password);

        //then
        Assert.assertThat(userValidator.hasErrors(), is(true));

    }

}
