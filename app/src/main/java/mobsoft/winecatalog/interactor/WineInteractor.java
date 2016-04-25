package mobsoft.winecatalog.interactor;


import javax.inject.Inject;

import mobsoft.winecatalog.MVPApplication;
import mobsoft.winecatalog.model.WineModel;

/**
 * Created by Raimy on 10/04/2016.
 */
public class WineInteractor {
    @Inject
    WineModel model;

    public WineInteractor() {
        MVPApplication.injector.inject(this);
    }

    public String getName() {
        return model.getName();
    }
}
