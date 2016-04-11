package mobsoft.winecatalog.presenter;

import javax.inject.Inject;

import mobsoft.winecatalog.MVPApplication;
import mobsoft.winecatalog.interactor.StringInteractor;
import mobsoft.winecatalog.view.MainView;

/**
 * Created by Raimy on 10/04/2016.
 */
public class MainPresenter extends Presenter<MainView> {

    @Inject
    public StringInteractor interactor;

    public MainPresenter() {
        MVPApplication.injector.inject(this);
    }

    public void doStuff() {
        view.showString(interactor.getString());
    }
}
