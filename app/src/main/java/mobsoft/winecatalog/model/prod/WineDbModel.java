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
    private UserDbModel userDb;

    public WineDbModel() { }

    public List<Wine> fetchWines() {
        List<Wine> values = Wine.listAll(Wine.class);
        return values;
    }
    public List<Wine> fetchWinesOfUser(User actualUser) {
        List<Wine> values = new ArrayList<>();
        User user = userDb.getUser(actualUser.getUsername());
        if (user != null)
            values = user.getWines();
        return values;
    }

    public void insertWineForUser(User user, Wine wine) {
        user.save();
        wine.setUser(user);
        wine.save();
    }

    public void deleteWineFromUser(User user, Wine wine) {
        List<Wine> wines = fetchWinesOfUser(user);
        for (Wine w : wines) {
            if (w.getId().equals(wine.getId())) {
                w.delete();
                break;
            }
        }
    }
}
