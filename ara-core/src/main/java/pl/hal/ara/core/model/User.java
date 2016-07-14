package pl.hal.ara.core.model;

import com.google.common.base.MoreObjects;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class User {

    @Id private ObjectId id;

    private String username;
    @Embedded private Email email;
    @Embedded private Password password;

    public User() {}

    public User(String username, Email email, Password password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public Email getEmail() {
        return email;
    }

    public Password getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("username", username)
                .add("email", email)
                .add("password", password)
                .toString();
    }
}
