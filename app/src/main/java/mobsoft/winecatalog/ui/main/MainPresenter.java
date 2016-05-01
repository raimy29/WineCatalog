package mobsoft.winecatalog.ui.main;

import javax.inject.Inject;

import mobsoft.winecatalog.WineCatalogApplication;
import mobsoft.winecatalog.interactor.WinesInteractor;
import mobsoft.winecatalog.ui.Presenter;

/**
 * Created by Raimy on 10/04/2016.
 */
public class MainPresenter extends Presenter<MainScreen> {

    @Inject
    public WinesInteractor interactor;

    public MainPresenter() { WineCatalogApplication.injector.inject(this);
    }

    public void listWines() {
        screen.listWines(interactor.getUsername());
    }

    public void addWine() {
        screen.addWine(interactor.getUsername());
    }
}
