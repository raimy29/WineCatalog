package mobsoft.winecatalog;

import javax.inject.Singleton;

import dagger.Component;
import mobsoft.winecatalog.interactor.InteractorModule;
import mobsoft.winecatalog.interactor.WinesInteractor;
import mobsoft.winecatalog.model.prod.ModelModule;
import mobsoft.winecatalog.ui.main.MainActivity;
import mobsoft.winecatalog.ui.UIModule;
import mobsoft.winecatalog.ui.main.MainPresenter;
import mobsoft.winecatalog.ui.winelist.WineListPresenter;

/**
 * Created by Raimy on 10/04/2016.
 */
@Singleton
@Component(modules = {UIModule.class, InteractorModule.class, ModelModule.class})
public interface WineCatalogApplicationComponent {
        void inject(MainActivity activity);

        void inject(MainPresenter presenter);

        void inject(WineListPresenter presenter);

        void inject(WinesInteractor interactor);


}
