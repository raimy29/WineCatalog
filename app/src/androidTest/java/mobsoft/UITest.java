package mobsoft;

import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import mobsoft.winecatalog.R;
import mobsoft.winecatalog.ui.details.WineDetailsActivity;
import mobsoft.winecatalog.ui.main.MainActivity;
import mobsoft.winecatalog.ui.winelist.WineListActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by eraikon on 5/23/2016.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class UITest {

    @Rule
    public ActivityRule<MainActivity> mActivityRule = new ActivityRule(MainActivity.class);

//    @Rule
//    public ActivityRule<WineListActivity> wineListActivityRule = new ActivityRule(WineListActivity.class);
//
//    @Rule
//    public ActivityRule<WineDetailsActivity> wineDetailsActivityRule = new ActivityRule(WineDetailsActivity.class);


    @Test
    public void addWineTest() {
        onView(withId(R.id.addWineBtn)).perform(click());
        onView(withText("Winery")).check(ViewAssertions.matches(isDisplayed()));
    }

    @Test
    public void addWineImageTest() {
        onView(withId(R.id.addWineImageBtn)).perform(click());
        onView(withText("Name")).check(ViewAssertions.matches(isDisplayed()));
    }

    @Test
    public void listWinesTest() {
        onView(withId(R.id.listWinesBtn)).perform(click());
        onView(withText("Raimy")).check(ViewAssertions.matches(isDisplayed()));
    }

    @Test
    public void listWinesImageTest() {
        onView(withId(R.id.listWinesImageBtn)).perform(click());
        onView(withText("My Wines")).check(ViewAssertions.matches(isDisplayed()));
    }
}
