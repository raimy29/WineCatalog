package mobsoft.winecatalog.interactor;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Raimy on 10/04/2016.
 */
@Module
public class InteractorModule {
    @Provides
    public WineInteractor getWineInteractor() {
        return new WineInteractor();
    }
}