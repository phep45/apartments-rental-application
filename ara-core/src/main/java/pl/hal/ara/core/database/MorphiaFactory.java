package pl.hal.ara.core.database;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Morphia;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.hal.ara.core.model.Email;
import pl.hal.ara.core.model.Password;
import pl.hal.ara.core.model.User;

@Component
public class MorphiaFactory {

    private @Value("${mongo.host.address}") String address;
    private @Value("${mongo.host.port}") String port;

    public MongoClient getMongoInstance() {
        return new MongoClient(address, Integer.parseInt(port));
    }

    public Morphia getMorphiaInstance() {
        Morphia morphia = new Morphia();

        morphia
                .map(User.class)
                .map(Email.class)
                .map(Password.class);

        return morphia;
    }

}
