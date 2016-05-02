package mobsoft.winecatalog.ui.winelist;

import java.util.List;

import mobsoft.winecatalog.model.Wine;

/**
 * Created by Raimy on 10/04/2016.
 */
public interface WineListScreen {
    void showWines(List<Wine> wines);

    void showWineDetails(Wine wine);

    void showMessage(String message);
}
