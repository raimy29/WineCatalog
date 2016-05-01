package mobsoft.winecatalog;
import android.app.Application;

import mobsoft.winecatalog.ui.UIModule;

/**
 * Created by Raimy on 10/04/2016.
 */
public class WineCatalogApplication extends Application {

        public static WineCatalogApplicationComponent injector;

        @Override
        public void onCreate() {
            super.onCreate();
            injector = DaggerWineCatalogApplicationComponent.builder()
                    .uIModule(new UIModule(this))
                    .build();
        }
}
