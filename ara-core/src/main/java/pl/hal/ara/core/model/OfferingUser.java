package pl.hal.ara.core.model;

public class OfferingUser {
    private final User user;

    public OfferingUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
