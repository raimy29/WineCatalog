package mobsoft.winecatalog.model;

import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by Raimy on 10/04/2016.
 */
public class Wine extends SugarRecord {

    private enum Type {
        FEHER, VOROS, ROSE
    }

    private String name;
    private String winery;
    private List<String> grapeVariety;
    private Type type;
    private int rating;

    private User user;

    public Wine() { }

    public Wine(String name) {
        this.name = name;
    }

    public String getName() { return name; }

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

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

}
