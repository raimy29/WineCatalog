package mobsoft.winecatalog.ui.details;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.Arrays;

import mobsoft.winecatalog.R;
import mobsoft.winecatalog.WineCatalogApplication;
import mobsoft.winecatalog.model.Wine;

/**
 * Created by eraikon on 5/1/2016.
 */
public class WineDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Button saveWineBtn = (Button) findViewById(R.id.saveWineBtn);
        saveWineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Wine wine = new Wine();
                wine.setName(((EditText) v.findViewById(R.id.tfName)).getText().toString());
                wine.setWinery(((EditText) v.findViewById(R.id.tfWinery)).getText().toString());
                wine.setGrapeVariety("Chardonnay, Pinot Gris");
                wine.setType(Wine.Type.FEHER);
                wine.setRating(1);
            }
        });

    }
}
