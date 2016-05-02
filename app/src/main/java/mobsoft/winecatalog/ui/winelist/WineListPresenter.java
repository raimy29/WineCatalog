package mobsoft.winecatalog.ui.winelist;

import java.util.List;

import javax.inject.Inject;

import mobsoft.winecatalog.WineCatalogApplication;
import mobsoft.winecatalog.interactor.WinesInteractor;
import mobsoft.winecatalog.model.User;
import mobsoft.winecatalog.model.Wine;
import mobsoft.winecatalog.ui.Presenter;

/**
 * Created by Raimy on 10/04/2016.
 */
public class WineListPresenter extends Presenter<WineListScreen> {

    @Inject
    public WinesInteractor interactor;

    public WineListPresenter() {
        WineCatalogApplication.injector.inject(this);
    }

    public void addWine(Wine wine) {
        try {
            interactor.addWineToNetwork(wine);
        } catch (Exception e) {
            interactor.addWineToDb(wine);
            screen.showMessage(e.getMessage());
        }
    }
    public void refreshWines(String username) {
        try {
            screen.showWines(interactor.getWinesOfUserFromNetwork(username));
        } catch (Exception e) {
            screen.showWines(interactor.getWinesOfUserFromDb(username));
            screen.showMessage(e.getMessage());
        }
    }

    public void showDetails(Wine wine) {
        screen.showWineDetails(wine);
    }

}
