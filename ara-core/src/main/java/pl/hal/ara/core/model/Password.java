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
    private byte[] salt;

    public Password() {}

    public Password(String passwordString) {
        this.pashword = hash(passwordString);
    }

    private String hash(String password) {
        try {
            byte[] salt = new byte[16];
            new Random().nextBytes(salt);
            KeySpec spec = new PBEKeySpec("password".toCharArray(), salt, 65536, 128);
            SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = f.generateSecret(spec).getEncoded();
            Base64.Encoder enc = Base64.getEncoder();
            this.salt = salt;
            return enc.encodeToString(hash);
        } catch (InvalidKeySpecException e) {
            //TODO
        } catch (NoSuchAlgorithmException e) {
            //TODO
        }
        throw new IllegalStateException();
    }

    public String getPashword() {
        return pashword;
    }
}
