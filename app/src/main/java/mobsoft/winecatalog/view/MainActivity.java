package mobsoft.winecatalog.view;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.inject.Inject;

import mobsoft.winecatalog.MVPApplication;
import mobsoft.winecatalog.R;
import mobsoft.winecatalog.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainView {

    @Inject
    MainPresenter mainPresenter;

    private AlertDialog.Builder alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        MVPApplication.injector.inject(this);

        alert = new AlertDialog.Builder(MainActivity.this);

        findViewById(R.id.addWineBtn).setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                mainPresenter.doStuff();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.detachView();
    }

    @Override
    public void showString(String s) {
        alert.setTitle(s);
        alert.show();
    }
}
