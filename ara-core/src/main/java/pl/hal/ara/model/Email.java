package pl.hal.ara.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {

    private static final String EMAIL_REGEX = "^([\\w\\.\\-\\_]+)@([\\w\\.\\-\\_]+.\\w{2,3})$";
    private static final int NAME_GROUP = 1;
    private static final int DOMAIN_GROUP = 2;

    private final String name;
    private final String domain;

    public Email(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        if(matcher.find()) {
            name = matcher.group(NAME_GROUP);
            domain = matcher.group(DOMAIN_GROUP);
        } else {
            throw new IllegalArgumentException("Email is not valid");
        }
    }

    public String getName() {
        return name;
    }

    public String getDomain() {
        return domain;
    }

    public String getEmail() {
        return name + "@" + domain;
    }
}
