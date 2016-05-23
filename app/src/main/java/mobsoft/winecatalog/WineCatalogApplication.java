package mobsoft.winecatalog;
import android.app.Application;


import com.crashlytics.android.Crashlytics;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

import io.fabric.sdk.android.Fabric;
import mobsoft.winecatalog.ui.UIModule;

/**
 * Created by Raimy on 10/04/2016.
 */
public class WineCatalogApplication extends Application {


    public static WineCatalogApplicationComponent injector;

    private Tracker mTracker;

    /**
     * Gets the default {@link Tracker} for this {@link Application}.
     * @return tracker
     */
    synchronized public Tracker getDefaultTracker() {
        if (mTracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
            mTracker = analytics.newTracker(R.xml.global_tracker);
        }
        return mTracker;
    }


        @Override
        public void onCreate() {
            super.onCreate();
            Fabric.with(this, new Crashlytics());
            if (BuildConfig.FLAVOR.contentEquals("mock")) {
                injector = DaggerMockWineCatalogApplicationComponent.builder()
                        .uIModule(new UIModule(this))
                        .build();
            } else {
                injector = DaggerWineCatalogApplicationComponent.builder()
                        .uIModule(new UIModule(this))
                        .build();
            }
        }
}
