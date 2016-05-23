package mobsoft.winecatalog.model.prod;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import mobsoft.winecatalog.model.User;
import mobsoft.winecatalog.model.Wine;


/**
 * Created by Raimy on 5/1/2016.
 */
public class WineDbModel {

    @Inject
    public UserDbModel userDb;

    public WineDbModel() { }

    public List<Wine> fetchWines() {
        List<Wine> values = Wine.listAll(Wine.class);
        return values;
    }
    public List<Wine> fetchWinesOfUser(String username) {
        List<Wine> values = new ArrayList<>();
        User user = userDb.getUser(username);
        if (user != null)
            values = user.getWines();
        return values;
    }

    public WineDbModel insertWineForUser(Wine wine) {
        wine.setUser(userDb.getUser("Demo"));
        wine.getUser().save();
        wine.save();
        return this;
    }

    public void deleteWineFromUser(Wine wine) {
        List<Wine> wines = fetchWinesOfUser(wine.getUser().getUsername());
        for (Wine w : wines) {
            if (w.getId().equals(wine.getId())) {
                w.delete();
                break;
            }
        }
    }
}
