package pl.hal.ara.core.model;

import com.google.common.base.Preconditions;
import org.mongodb.morphia.annotations.Embedded;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embedded
public class Email {

    private static final String EMAIL_REGEX = "^([\\w\\.\\-\\_]+)@([\\w\\.\\-\\_]+.\\w{2,3})$";
    private static final int NAME_GROUP = 0;
    private static final int DOMAIN_GROUP = 1;

    private String name;
    private String domain;

    public Email() {}

    public Email(String email) {
        Preconditions.checkArgument(isEmailValid(email));
        String[] splitted = email.split("@");
        name = splitted[NAME_GROUP];
        domain = splitted[DOMAIN_GROUP];
    }

    public static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

    public String getName() {
        return name;
    }

    public String getDomain() {
        return domain;
    }

    public String asString() {
        return name + "@" + domain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Email email = (Email) o;

        if (!name.equals(email.name)) return false;
        return domain.equals(email.domain);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + domain.hashCode();
        return result;
    }
}
