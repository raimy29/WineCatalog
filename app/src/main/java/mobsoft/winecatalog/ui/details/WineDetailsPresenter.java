package mobsoft.winecatalog.ui.details;

import javax.inject.Inject;

import mobsoft.winecatalog.WineCatalogApplication;
import mobsoft.winecatalog.interactor.WinesInteractor;
import mobsoft.winecatalog.model.Wine;
import mobsoft.winecatalog.ui.Presenter;

/**
 * Created by Raimy on 10/04/2016.
 */
public class WineDetailsPresenter extends Presenter<WineDetailsScreen> {

    @Inject
    public WinesInteractor winesInteractor;

    public WineDetailsPresenter() {
        WineCatalogApplication.injector.inject(this);
    }

    public void addWine(Wine wine) {
        winesInteractor.addWineToDb(wine);
    }
}
