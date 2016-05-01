package mobsoft.winecatalog.ui;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mobsoft.winecatalog.ui.main.MainPresenter;
import mobsoft.winecatalog.ui.winelist.WineListPresenter;

/**
 * Created by Raimy on 10/04/2016.
 */
@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter getMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    @Singleton
    public WineListPresenter getWineListPresenter() {
        return new WineListPresenter();
    }

}
