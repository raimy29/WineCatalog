package mobsoft.winecatalog.interactor;

import java.util.List;

import javax.inject.Inject;

import mobsoft.winecatalog.WineCatalogApplication;
import mobsoft.winecatalog.model.User;
import mobsoft.winecatalog.model.Wine;

/**
 * Created by Raimy on 5/1/2016.
 */
public class WinesInteractor {

    @Inject
    User userModel;

    public WinesInteractor() {
        WineCatalogApplication.injector.inject(this);
    }

    public List<Wine> getWines() {
        if (userModel == null)
            userModel = new User("Raimy", "123abc");
        return userModel.getWines();
    }

    public String getUsername() {
        if (userModel == null)
            userModel = new User("Raimy", "123abc");
        return userModel.getUsername();
    }

}
