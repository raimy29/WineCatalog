package mobsoft.winecatalog;

import javax.inject.Singleton;

import dagger.Component;
import mobsoft.winecatalog.interactor.InteractorModule;
import mobsoft.winecatalog.interactor.WinesInteractor;
import mobsoft.winecatalog.model.ModelModule;
import mobsoft.winecatalog.ui.main.MainPresenter;
import mobsoft.winecatalog.ui.main.MainActivity;
import mobsoft.winecatalog.ui.UIModule;

/**
 * Created by Raimy on 10/04/2016.
 */
@Singleton
@Component(modules = {UIModule.class, InteractorModule.class, ModelModule.class})
public interface WineCatalogApplicationComponent {
        void inject(MainActivity mainActivity);

        void inject(MainPresenter mainPresenter);

        void inject(WinesInteractor userInteractor);
}
