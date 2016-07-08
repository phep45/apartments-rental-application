package pl.hal.ara.model;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.is;

public class PriceTest {

    private static final BigDecimal EXPECTED_NUMBER = BigDecimal.valueOf(999.23);
    private static final double GIVEN_NUMBER = 999.234234;
    public static final double NEGATIVE_NUMBER = -99.99;

    @Test
    public void shouldCreatePrice() {
        Price price = new Price(GIVEN_NUMBER);
        Assert.assertThat(price.getAmount(), is(EXPECTED_NUMBER));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowNegatives() {
        new Price(NEGATIVE_NUMBER);
    }

}
