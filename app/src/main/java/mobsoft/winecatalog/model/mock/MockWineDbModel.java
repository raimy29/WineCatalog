package mobsoft.winecatalog.model.mock;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import mobsoft.winecatalog.model.User;
import mobsoft.winecatalog.model.Wine;
import mobsoft.winecatalog.model.prod.WineDbModel;

/**
 * Created by Raimy on 5/1/2016.
 */
public class MockWineDbModel extends WineDbModel {

    @Inject
    MockUserDbModel mockUserDb;
    LinkedList<Wine> values = new LinkedList<>();

    public MockWineDbModel() {
        for (User user : mockUserDb.fetchUsers()) {
            for (int i = 2010; i < 2015; i++) {
                Wine wine = new Wine();
                if (i % 2 == 0) {
                    wine.setName("Leanykak " + i);
                    wine.setWinery("Nyolcas");
                    wine.setType(Wine.Type.FEHER);
                } else {
                    wine.setName("Medvetalp " + i);
                    wine.setWinery("Bukolyi");
                    wine.setType(Wine.Type.VOROS);
                }
                wine.setUser(user);
                values.add(wine);
            }
        }
    }

    @Override
    public List<Wine> fetchWines() {
        return values;
    }

    @Override
    public List<Wine> fetchWinesOfUser(User actualUser) {
        List<Wine> values = new ArrayList<>();
        User user = mockUserDb.getUser(actualUser.getUsername());
        if (user != null)
            values = user.getWines();
        return values;
    }

    @Override
    public void insertWineForUser(User user, Wine wine) {
        mockUserDb.insertUser(user);
        wine.setUser(user);
        values.add(wine);
    }

    @Override
    public void deleteWineFromUser(User user, Wine wine) {
        List<Wine> wines = fetchWinesOfUser(user);
        if (wines.contains(wine))
            wines.remove(wine);
        if (values.contains(wine))
            values.remove(wine);
    }
}
