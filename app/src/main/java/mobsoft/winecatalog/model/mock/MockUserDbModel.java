package mobsoft.winecatalog.model.mock;

import java.util.LinkedList;
import java.util.List;

import mobsoft.winecatalog.model.User;
import mobsoft.winecatalog.model.prod.UserDbModel;

/**
 * Created by Raimy on 5/1/2016.
 */
public class MockUserDbModel extends UserDbModel {

    LinkedList<User> values = new LinkedList<>();

    public MockUserDbModel() {
        values.add(new User("Test", "123"));
        values.add(new User("Demo", "demo"));
    }

    @Override
    public User getUser(String username) {
        for (User user : values) {
            if (user.getUsername().contentEquals(username)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> fetchUsers() {
        return values;
    }

    @Override
    public void insertUser(User user) {
        values.add(user);
    }

    @Override
    public void removeUser(User user) {
        values.remove(user);
    }


}
