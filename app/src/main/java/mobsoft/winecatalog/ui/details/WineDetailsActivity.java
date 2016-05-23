package mobsoft.winecatalog.ui.details;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import mobsoft.winecatalog.R;
import mobsoft.winecatalog.WineCatalogApplication;
import mobsoft.winecatalog.model.Wine;

/**
 * Created by eraikon on 5/1/2016.
 */
public class WineDetailsActivity extends AppCompatActivity {

    @Inject
    WineDetailsPresenter wineDetailsPresenter;

    private Tracker mTracker;

    Spinner typeSpinner;
    Spinner ratingSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WineCatalogApplication.injector.inject(this);
        setContentView(R.layout.activity_details);

        WineCatalogApplication application = (WineCatalogApplication) getApplication();
        mTracker = application.getDefaultTracker();

        typeSpinner = (Spinner) findViewById(R.id.ddType);
        List<String> list = new ArrayList<String>();
        list.add("Feher");
        list.add("Voros");
        list.add("Rose");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(dataAdapter);

        ratingSpinner = (Spinner) findViewById(R.id.ddRating);
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(new Integer(1));
        list2.add(new Integer(2));
        list2.add(new Integer(3));
        list2.add(new Integer(4));
        list2.add(new Integer(5));
        ArrayAdapter<Integer> dataAdapter2 = new ArrayAdapter<Integer>(this,
                android.R.layout.simple_spinner_item, list2);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ratingSpinner.setAdapter(dataAdapter2);

        Button saveWineBtn = (Button) findViewById(R.id.saveWineBtn);
        saveWineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Wine wine = new Wine();
                wine.setName(((EditText) findViewById(R.id.tfName)).getText().toString());
                wine.setWinery(((EditText) findViewById(R.id.tfWinery)).getText().toString());
                wine.setGrapeVariety(((EditText) findViewById(R.id.tfGrapeVariety)).getText().toString());
                wine.setType(((Spinner) findViewById(R.id.ddType)).getSelectedItem().toString());
                wine.setRating(Integer.parseInt(((Spinner) findViewById(R.id.ddRating)).getSelectedItem().toString()));
                throw new RuntimeException("Oh no, fatal error");
//                wineDetailsPresenter.addWine(wine);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        mTracker.setScreenName("WineDetailsActivity");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }
}
