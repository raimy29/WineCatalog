package mobsoft.winecatalog.ui;

/**
 * Created by Raimy on 10/04/2016.
 */
public abstract class Presenter<S> {
    protected S screen;

    public void attachScreen(S screen) {
        this.screen = screen;
    }

    public void detachScreen() {
        this.screen = null;
    }
}
