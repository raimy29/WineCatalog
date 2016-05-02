package mobsoft.winecatalog.model;

import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by eraikon on 5/1/2016.
 */
public class User extends SugarRecord {

    String username;

    public User() { }

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }
    public void setName(String username) {
        this.username = username;
    }

    public List<Wine> getWines() {
        return Wine.find(Wine.class, "user = ?", new String("Demo"));
    }
}
