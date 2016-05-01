package mobsoft.winecatalog.ui.details;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import mobsoft.winecatalog.R;
import mobsoft.winecatalog.WineCatalogApplication;

/**
 * Created by eraikon on 5/1/2016.
 */
public class WineDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
    }
}
