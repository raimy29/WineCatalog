package mobsoft.winecatalog.interactor;

import javax.inject.Inject;

import mobsoft.winecatalog.WineCatalogApplication;
import mobsoft.winecatalog.model.User;
import mobsoft.winecatalog.model.prod.UserDbModel;

/**
 * Created by Raimy on 5/1/2016.
 */
public class UserInteractor {

    @Inject
    UserDbModel model;

    public UserInteractor() {
        WineCatalogApplication.injector.inject(this);
    }

    public void addUser(User user) {
        model.insertUser(user);
    }

    public void removeUser(User user) {
        model.removeUser(user);
    }
}
