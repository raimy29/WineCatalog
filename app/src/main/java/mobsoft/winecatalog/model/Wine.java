package mobsoft.winecatalog.model;

import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by Raimy on 10/04/2016.
 */
public class Wine extends SugarRecord {

    private String name;
    private String winery;
    private String grapeVariety;
    private String type;
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

    public String getGrapeVariety() {
        return grapeVariety;
    }

    public void setGrapeVariety(String grapeVariety) {
        this.grapeVariety = grapeVariety;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
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
