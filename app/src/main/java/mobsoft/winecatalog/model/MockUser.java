package mobsoft.winecatalog.model;

import java.util.ArrayList;
import java.util.List;

import mobsoft.winecatalog.model.User;

/**
 * Created by Raimy on 5/2/2016.
 */
public class MockUser extends User {

    public MockUser() {
        this.username = "TestUser";
        this.password = "123";
    }

    @Override
    public List<Wine> getWines() {
        List<Wine> wineList = new ArrayList<>();
        for (int i = 2010; i < 2015; i++) {
            Wine wine = new Wine();
            wine.setName("Leanykak" + i);
            wine.setWinery("Nyolcas");
            wineList.add(wine);
        }
        return wineList;
    }
}
