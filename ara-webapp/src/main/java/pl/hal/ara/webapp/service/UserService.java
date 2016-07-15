package pl.hal.ara.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.hal.ara.core.database.UserDAO;
import pl.hal.ara.core.model.Email;
import pl.hal.ara.core.model.Password;
import pl.hal.ara.core.model.User;
import pl.hal.ara.webapp.exception.InvalidUserDataException;
import pl.hal.ara.webapp.utils.validator.UserValidator;

@Component
public class UserService implements HomeService {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private UserValidator userValidator;

    public void addUser(String username, String email, String password) {
        userValidator.validateUsername(username);
        userValidator.validateEmail(email);
        userValidator.validatePassword(password);

        if(userValidator.hasErrors()) {
            throw new InvalidUserDataException(userValidator.getErrors());
        }

        User user = new User(username, new Email(email), new Password(password));

        userDAO.save(user);
    }
}
