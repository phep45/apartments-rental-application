package pl.hal.ara.core.database;

import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.DAO;
import pl.hal.ara.core.model.User;

public interface UserDAO extends DAO<User, ObjectId> {

    User getOne(String username);
}
