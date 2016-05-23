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

    MockUserDbModel mockUserDb;
    LinkedList<Wine> values = new LinkedList<>();

    public MockWineDbModel() {
        mockUserDb = new MockUserDbModel();
        for (User user : mockUserDb.fetchUsers()) {
            for (int i = 2010; i < 2015; i++) {
                Wine wine = new Wine();
                if (i % 2 == 0) {
                    wine.setName("Leanykak " + i);
                    wine.setWinery("Nyolcas");
                    wine.setType("Feher");
                } else {
                    wine.setName("Medvetalp " + i);
                    wine.setWinery("Bukolyi");
                    wine.setType("Voros");
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
    public List<Wine> fetchWinesOfUser(String username) {
        List<Wine> result = new ArrayList<>();
        User user = mockUserDb.getUser(username);
        if (user != null)
            for (Wine wine : values) {
                if (wine.getUser().equals(user))
                    result.add(wine);
            }
        return result;
    }

    @Override
    public WineDbModel insertWineForUser(Wine wine) {
        wine.setUser(mockUserDb.getUser("Demo"));
        mockUserDb.insertUser(wine.getUser());
        values.add(wine);
        return this;
    }

    @Override
    public void deleteWineFromUser(Wine wine) {
        List<Wine> wines = fetchWinesOfUser(wine.getUser().getUsername());
        if (wines.contains(wine))
            wines.remove(wine);
        if (values.contains(wine))
            values.remove(wine);
    }
}
