package mobsoft.winecatalog.ui.main;

import javax.inject.Inject;

import mobsoft.winecatalog.WineCatalogApplication;
import mobsoft.winecatalog.interactor.UserInteractor;
import mobsoft.winecatalog.model.User;
import mobsoft.winecatalog.ui.Presenter;

/**
 * Created by Raimy on 10/04/2016.
 */
public class MainPresenter extends Presenter<MainScreen> {

    @Inject
    public UserInteractor userInteractor;

    public MainPresenter() {
        WineCatalogApplication.injector.inject(this);
    }

    public void listWines() {
        screen.listWines();
    }

    public void addWine() {
        screen.addWine();
    }

    public void addUser(User user) {
        userInteractor.addUser(user);
    }
}
