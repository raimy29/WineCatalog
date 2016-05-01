package mobsoft.winecatalog.ui.winelist;

import java.util.List;

import javax.inject.Inject;

import mobsoft.winecatalog.WineCatalogApplication;
import mobsoft.winecatalog.interactor.WinesInteractor;
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

    @Override
    public void attachScreen(WineListScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public List<Wine> getWines() {
        return interactor.getWines();
    }

    public void showDetails(final Wine wine) {
        screen.showWineDetails(wine);
    }

    public String getUsername() {
        return interactor.getUsername();
    }
}
