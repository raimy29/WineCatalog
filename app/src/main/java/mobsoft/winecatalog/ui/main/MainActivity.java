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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.orm.SugarContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import mobsoft.winecatalog.WineCatalogApplication;
import mobsoft.winecatalog.R;
import mobsoft.winecatalog.model.User;
import mobsoft.winecatalog.model.Wine;
import mobsoft.winecatalog.ui.details.WineDetailsActivity;
import mobsoft.winecatalog.ui.winelist.WineListActivity;

public class MainActivity extends AppCompatActivity implements MainScreen {

    @Inject
    MainPresenter mainPresenter;

    private Tracker mTracker;

    public User user;
    public static final String KEY_USER = "KEY_USER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WineCatalogApplication application = (WineCatalogApplication) getApplication();
        mTracker = application.getDefaultTracker();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SugarContext.init(this);
        WineCatalogApplication.injector.inject(this);

        user = new User("Demo");
        mainPresenter.addUser(user);

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
    protected void onResume() {
        super.onResume();
        mTracker.setScreenName("MainActivity");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.detachScreen();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.detachScreen();
    }

    @Override
    public void listWines() {
        Intent intent = new Intent(MainActivity.this, WineListActivity.class);
        intent.putExtra(KEY_USER, user.getUsername());
        startActivity(intent);
    }

    @Override
    public void addWine() {
        Intent intent = new Intent(MainActivity.this, WineDetailsActivity.class);
        startActivity(intent);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
