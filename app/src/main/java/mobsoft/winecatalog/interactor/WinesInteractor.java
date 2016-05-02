package mobsoft.winecatalog.interactor;

import java.util.List;

import javax.inject.Inject;

import mobsoft.winecatalog.WineCatalogApplication;
import mobsoft.winecatalog.model.Wine;
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

    public void addWineToDb(Wine wine) {
        model.insertWineForUser(wine);
    }

    public void addWineToNetwork(Wine wine) throws Exception {

    }

    public List<Wine> getAllWinesFromDb() {
        return model.fetchWines();
    }

    public List<Wine> getAllWinesFromNetwork() throws Exception {
        throw new Exception("Exception");
    }

    public List<Wine> getWinesOfUserFromDb(String username) {
        return model.fetchWinesOfUser(username);
    }

    public List<Wine> getWinesOfUserFromNetwork(String username) throws  Exception {
        throw new Exception("Exception");
    }


}
