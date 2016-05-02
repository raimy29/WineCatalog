package mobsoft.winecatalog.interactor;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import mobsoft.winecatalog.WineCatalogApplication;
import mobsoft.winecatalog.model.User;
import mobsoft.winecatalog.model.Wine;
import mobsoft.winecatalog.model.prod.UserDbModel;
import mobsoft.winecatalog.model.prod.WineDbModel;

/**
 * Created by Raimy on 5/1/2016.
 */
public class WinesInteractor {

    @Inject
    WineDbModel model;

    public WinesInteractor() {
        WineCatalogApplication.injector.inject(this);
    }

    public void addWineToDb(User user, Wine wine) {
        model.insertWineForUser(user, wine);
    }

    public List<Wine> getWinesFromDb() {
        return model.fetchWines();
    }

    public List<Wine> getWinesOfUserFromDb(User user) {
        return model.fetchWinesOfUser(user);
    }
}
