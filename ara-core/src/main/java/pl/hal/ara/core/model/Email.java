package pl.hal.ara.core.model;

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
}
