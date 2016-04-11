package mobsoft.winecatalog;
import android.app.Application;

import mobsoft.winecatalog.view.ViewModule;

/**
 * Created by Raimy on 10/04/2016.
 */
public class MVPApplication extends Application {

        public static MVPApplicationComponent injector;

        @Override
        public void onCreate() {
            super.onCreate();
            injector = DaggerMVPApplicationComponent.builder().viewModule(new ViewModule(this)).build();
        }
}
