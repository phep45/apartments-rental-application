package pl.hal.ara.core.model;


import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

public class EmailTest {

    private static final String PROPER_EMAIL_STRING = "testing-application.email@enterprise-corporation.com";
    private static final String PROPER_EMAIL_DOMAIN = "enterprise-corporation.com";
    private static final String PROPER_EMAIL_NAME = "testing-application.email";
    private static final String INVALID_EMAIL_ADDRESS = "invalid.email.address.pl";

    @Test
    public void shouldCreateEmail() {
        Email email = new Email(PROPER_EMAIL_STRING);
        Assert.assertThat(email.asString(), is(PROPER_EMAIL_STRING));
        Assert.assertThat(email.getDomain(), is(PROPER_EMAIL_DOMAIN));
        Assert.assertThat(email.getName(), is(PROPER_EMAIL_NAME));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotCreateInvalidEmail() {
        new Email(INVALID_EMAIL_ADDRESS);
    }

}
