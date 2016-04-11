package mobsoft.winecatalog.interactor;


import javax.inject.Inject;

import mobsoft.winecatalog.MVPApplication;
import mobsoft.winecatalog.model.StringModel;

/**
 * Created by Raimy on 10/04/2016.
 */
public class StringInteractor {
    @Inject
    StringModel model;

    public StringInteractor() {
        MVPApplication.injector.inject(this);
    }

    public String getString() {
        return model.getNextString();
    }
}
