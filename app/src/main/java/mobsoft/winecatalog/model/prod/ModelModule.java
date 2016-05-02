package mobsoft.winecatalog.model.prod;

import dagger.Module;
import dagger.Provides;
import mobsoft.winecatalog.model.User;
import mobsoft.winecatalog.model.Wine;

/**
 * Created by Raimy on 10/04/2016.
 */
@Module
public class ModelModule {
    @Provides
    public WineDbModel getWineDbModel() { return new WineDbModel(); }
    @Provides
    public UserDbModel getUserDbModel() { return new UserDbModel(); }
}
