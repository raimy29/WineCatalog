package mobsoft.winecatalog.ui.winelist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.BuildConfig;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import mobsoft.winecatalog.R;
import mobsoft.winecatalog.model.Wine;
import mobsoft.winecatalog.ui.details.WineDetailsActivity;

public class WineListActivity extends AppCompatActivity implements WineListScreen {

    @Inject
    WineListPresenter wineListPresenter;

    private ListView listView;
    private TextView tvEmpty;
    private WinesAdapter winesAdapter;
    private List<Wine> wineList;
    private String username = "Raimy";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winelist);
        setTitle(getTitle() + " - " + username);
        tvEmpty = (TextView) findViewById(R.id.tvEmpty);

        wineList = new ArrayList<>();
        winesAdapter = new WinesAdapter(this, wineList);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(winesAdapter);

        if (BuildConfig.FLAVOR.equals("mock")) {
            showWines(new MockUser().getWines());
        }
    }

    @Override
    public void showWines(List<Wine> wines) {
        wineList.clear();
        wineList.addAll(wines);
        winesAdapter.notifyDataSetChanged();

        if (wineList.isEmpty()) {
            listView.setVisibility(View.GONE);
            tvEmpty.setVisibility(View.VISIBLE);
        } else {
            listView.setVisibility(View.VISIBLE);
            tvEmpty.setVisibility(View.GONE);
        }
    }

    @Override
    public void showWineDetails(Wine wine) {
        Intent intent  = new Intent(WineListActivity.this, WineDetailsActivity.class);
        startActivity(intent);
    }
}
