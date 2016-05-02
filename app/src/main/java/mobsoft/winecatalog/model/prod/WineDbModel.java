package mobsoft.winecatalog.model.prod;

import java.util.List;

import mobsoft.winecatalog.model.User;
import mobsoft.winecatalog.model.Wine;


/**
 * Created by Raimy on 5/1/2016.
 */
public class WineDbModel {

    public WineDbModel() { }

    public List<Wine> fetchWinesOfUser(User user) {
        List<Wine> values = user.getWines();
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
