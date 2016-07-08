package pl.hal.ara.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import org.apache.commons.lang.math.NumberUtils;

import java.math.BigDecimal;

public class Price {

    private static final int PRECISION = 2;
    private static final String CURRENCY_CODE = "PLN";

    private BigDecimal amount;

    public Price(BigDecimal amount) {
        Preconditions.checkArgument(amount.compareTo(BigDecimal.ZERO) >= NumberUtils.INTEGER_ZERO, "Amount must be greater or equal 0");
        this.amount = amount.setScale(PRECISION, BigDecimal.ROUND_HALF_UP);
    }

    public Price(double amount) {
        this(BigDecimal.valueOf(amount));
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("amount", amount + CURRENCY_CODE)
                .toString();
    }
}
