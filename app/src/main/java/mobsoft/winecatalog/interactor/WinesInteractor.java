package mobsoft.winecatalog.interactor;

import java.util.ArrayList;
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
        List<Wine> result = new ArrayList<>();
        if (userModel != null)
            return result = userModel.getWines();
        return result;
    }

    public String getUsername() {
        String username = "";
        if (userModel != null)
            username = userModel.getUsername();
        return username;
    }

}
