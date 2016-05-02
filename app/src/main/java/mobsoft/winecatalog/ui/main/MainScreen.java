package mobsoft.winecatalog.ui.main;

import java.util.List;

import mobsoft.winecatalog.model.User;
import mobsoft.winecatalog.model.Wine;

/**
 * Created by Raimy on 10/04/2016.
 */
public interface MainScreen {
    void listWines();

    void addWine();

    void showMessage(String message);
}
