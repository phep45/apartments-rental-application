package pl.hal.ara.core.database;

import com.mongodb.MongoClient;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.hal.ara.core.model.User;

@Component
public class MongoUserDAO extends BasicDAO<User, ObjectId> implements UserDAO {

    @Autowired
    public MongoUserDAO(MongoClient mongoClient, Morphia morphia, String dbName) {
        super(mongoClient, morphia, dbName);
    }

    public User getOne(String username) {

        Query<User> query = getDatastore().createQuery(User.class);
        query.criteria("username").equals(username);

        return super.findOne(query);
    }
}
