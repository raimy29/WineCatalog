package mobsoft.winecatalog.model.mock;

import dagger.Module;
import dagger.Provides;
import mobsoft.winecatalog.model.prod.UserDbModel;
import mobsoft.winecatalog.model.prod.WineDbModel;

/**
 * Created by Raimy on 5/1/2016.
 */
@Module
public class MockModelModule {

    @Provides
    public WineDbModel getWineDbModel() { return new MockWineDbModel(); }
    @Provides
    public UserDbModel getUserDbModel() { return new MockUserDbModel(); }
}
