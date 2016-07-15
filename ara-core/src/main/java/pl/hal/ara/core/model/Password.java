package pl.hal.ara.core.model;

import org.mongodb.morphia.annotations.Embedded;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.Random;

@Embedded
public class Password {
    private String pashword;

    public Password() {}

    public Password(String passwordString) {
        this.pashword = passwordString;
    }

    public String getPashword() {
        return pashword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Password password = (Password) o;

        return pashword.equals(password.pashword);

    }

    @Override
    public int hashCode() {
        return pashword.hashCode();
    }
}
