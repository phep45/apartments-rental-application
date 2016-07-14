package pl.hal.ara.core.app;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.QueryResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import pl.hal.ara.core.config.CoreConfig;
import pl.hal.ara.core.database.UserDAO;
import pl.hal.ara.core.model.Email;
import pl.hal.ara.core.model.Password;
import pl.hal.ara.core.model.User;

import static org.mongojack.DBQuery.is;

@Component
public class App {

    @Autowired
    private UserDAO userDAO;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CoreConfig.class);

        context.getBean(App.class).run();

        context.close();
    }

    private void run() {
//        User user = new User("test", new Email("test@test.pl"), new Password("test"));
//        userDAO.save(user);


        User user1 = userDAO.getOne("test");

        System.out.println(user1);

    }
}
