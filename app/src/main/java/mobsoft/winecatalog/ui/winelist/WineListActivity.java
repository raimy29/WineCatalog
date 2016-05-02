package mobsoft.winecatalog.ui.winelist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.BuildConfig;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.orm.SugarContext;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import mobsoft.winecatalog.R;
import mobsoft.winecatalog.WineCatalogApplication;
import mobsoft.winecatalog.model.User;
import mobsoft.winecatalog.model.Wine;
import mobsoft.winecatalog.ui.details.WineDetailsActivity;
import mobsoft.winecatalog.ui.main.MainActivity;

public class WineListActivity extends AppCompatActivity implements WineListScreen {

    @Inject
    WineListPresenter wineListPresenter;

    private ListView listView;
    private WinesAdapter winesAdapter;
    private List<Wine> wineList;
    private String username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winelist);
        WineCatalogApplication.injector.inject(this);
        username = (String) getIntent().getExtras().get(MainActivity.KEY_USER);
        setTitle(getTitle() + " - " + username);

        wineList = new ArrayList<>();
        winesAdapter = new WinesAdapter(this, R.layout.wine_item, wineList);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(winesAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        wineListPresenter.attachScreen(this);
        wineListPresenter.refreshWines(username);
    }

    @Override
    protected void onStop() {
        super.onStop();
        wineListPresenter.detachScreen();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        wineListPresenter.detachScreen();
    }

    @Override
    public void showWines(List<Wine> wines) {
        wineList.clear();
        wineList.addAll(wines);
        winesAdapter.notifyDataSetChanged();

        if (wineList.isEmpty()) {
            listView.setVisibility(View.GONE);
        } else {
            listView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showWineDetails(Wine wine) {
        Intent intent  = new Intent(WineListActivity.this, WineDetailsActivity.class);
        startActivity(intent);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
