package mobsoft.winecatalog.model;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Raimy on 10/04/2016.
 */
@Module
public class ModelModule {
    @Provides
    public Wine getWineModel() {
        return new Wine();
    }
    @Provides
    public User getUserModel() {
        return new User("Test", "test123");
    }
}
