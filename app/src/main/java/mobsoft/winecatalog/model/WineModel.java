package mobsoft.winecatalog.model;

import java.util.List;

/**
 * Created by Raimy on 10/04/2016.
 */
public class WineModel {

    private enum Type {
        FEHER, VOROS, ROSE
    }

    private String name;
    private String winery;
    private List<String> grapeVariety;
    private Type type;
    private int rating;

    public WineModel() { }

    public WineModel(String name) {
        this.name = name;
    }

    public String getName() {
        return "Sauska";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWinery() {
        return winery;
    }

    public void setWinery(String winery) {
        this.winery = winery;
    }

    public List<String> getGrapeVariety() {
        return grapeVariety;
    }

    public void setGrapeVariety(List<String> grapeVariety) {
        this.grapeVariety = grapeVariety;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
