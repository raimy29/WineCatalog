package mobsoft.winecatalog.model.prod;

import java.util.List;

import mobsoft.winecatalog.model.User;

/**
 * Created by Raimy on 5/1/2016.
 */
public class UserDbModel {

    public UserDbModel() { }

    public List<User> fetchUsers() {
        List<User> values = User.listAll(User.class);
        return values;
    }

    public void insertUser(User user) {
        user.save();
    }

    public void removeUser(User user) {
        user.delete();
    }
}
