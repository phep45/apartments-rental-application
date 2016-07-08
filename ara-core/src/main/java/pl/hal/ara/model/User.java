package pl.hal.ara.model;


public abstract class User {
    private String username;
    private Email email;
    private Password password;

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
}
