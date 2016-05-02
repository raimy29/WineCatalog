package mobsoft.winecatalog.model.mock;

import java.util.LinkedList;

import mobsoft.winecatalog.model.User;
import mobsoft.winecatalog.model.Wine;
import mobsoft.winecatalog.model.prod.WineDbModel;

/**
 * Created by Raimy on 5/1/2016.
 */
public class MockWineDbModel extends WineDbModel {

    LinkedList<Wine> values = new LinkedList<>();

    public MockWineDbModel() {
        MockUserDbModel mockUserDb = new MockUserDbModel();
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
}
