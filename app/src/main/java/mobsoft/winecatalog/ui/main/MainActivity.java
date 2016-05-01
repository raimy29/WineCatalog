package mobsoft.winecatalog.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import javax.inject.Inject;

import mobsoft.winecatalog.WineCatalogApplication;
import mobsoft.winecatalog.R;
import mobsoft.winecatalog.ui.details.WineDetailsActivity;
import mobsoft.winecatalog.ui.winelist.WineListActivity;

public class MainActivity extends AppCompatActivity implements MainScreen {

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        WineCatalogApplication.injector.inject(this);

        ImageButton imgBtnAddWine = (ImageButton) findViewById(R.id.addWineImageBtn);
        imgBtnAddWine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.addWine();
            }
        });

        ImageButton imgBtnListWines = (ImageButton) findViewById(R.id.listWinesImageBtn);
        imgBtnListWines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.listWines();
            }
        });


        Button btnAddWine = (Button) findViewById(R.id.addWineBtn);
        btnAddWine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.addWine();
            }
        });

        Button btnListWines = (Button) findViewById(R.id.listWinesBtn);
        btnListWines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.listWines();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.detachScreen();
    }

    @Override
    public void listWines(String username) {
        Intent intent = new Intent(MainActivity.this, WineListActivity.class);
        startActivity(intent);
    }

    @Override
    public void addWine(String username) {
        Intent intent = new Intent(MainActivity.this, WineDetailsActivity.class);
        startActivity(intent);
    }


}
