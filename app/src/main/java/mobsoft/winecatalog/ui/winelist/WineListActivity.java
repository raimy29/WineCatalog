package mobsoft.winecatalog.ui.winelist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import mobsoft.winecatalog.R;
import mobsoft.winecatalog.WineCatalogApplication;
import mobsoft.winecatalog.model.Wine;
import mobsoft.winecatalog.ui.details.WineDetailsActivity;
import mobsoft.winecatalog.ui.main.MainActivity;

public class WineListActivity extends AppCompatActivity implements WineListScreen {

    @Inject
    WineListPresenter wineListPresenter;

    private RecyclerView recyclerViewArtists;
    private SwipeRefreshLayout swipeRefreshLayoutWines;
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
        recyclerViewArtists = (RecyclerView) findViewById(R.id.recyclerViewWines);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewArtists.setLayoutManager(llm);

        wineList = new ArrayList<>();
        winesAdapter = new WinesAdapter(this, wineList);
        recyclerViewArtists.setAdapter(winesAdapter);

        recyclerViewArtists.addOnItemTouchListener(
                new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        wineListPresenter.showDetails(
                                winesAdapter.getItem(position));
                    }
                })
        );

        swipeRefreshLayoutWines = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayoutWines);

        showWines(wineList);
    }

    @Override
    public void showWines(List<Wine> wines) {
        wineList.clear();
        wineList.addAll(wines);
        if (wineList.isEmpty()) {
            recyclerViewArtists.setVisibility(View.GONE);
            tvEmpty.setVisibility(View.VISIBLE);
        } else {
            recyclerViewArtists.setVisibility(View.VISIBLE);
            tvEmpty.setVisibility(View.GONE);
        }
    }

    @Override
    public void showWineDetails(Wine wine) {
        Intent intent  = new Intent(WineListActivity.this, WineDetailsActivity.class);
        startActivity(intent);
    }
}
