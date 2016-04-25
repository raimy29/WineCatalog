package mobsoft.winecatalog;

import javax.inject.Singleton;

import dagger.Component;
import mobsoft.winecatalog.interactor.InteractorModule;
import mobsoft.winecatalog.interactor.WineInteractor;
import mobsoft.winecatalog.model.ModelModule;
import mobsoft.winecatalog.presenter.MainPresenter;
import mobsoft.winecatalog.view.MainActivity;
import mobsoft.winecatalog.view.ViewModule;

/**
 * Created by Raimy on 10/04/2016.
 */
@Singleton
@Component(modules = {ViewModule.class, InteractorModule.class, ModelModule.class})
public interface MVPApplicationComponent {
        void inject(MainActivity mainActivity);

        void inject(MainPresenter mainPresenter);

        void inject(WineInteractor wineInteractor);
}
