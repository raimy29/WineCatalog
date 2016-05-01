package mobsoft.winecatalog.model;

import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by eraikon on 5/1/2016.
 */
public class User extends SugarRecord {

    String username;
    String password;

    public User() { }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }
    public void setName(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public List<Wine> getWines() {
        return Wine.find(Wine.class, "user = ?", new String(String.valueOf(getId())));
    }
}
