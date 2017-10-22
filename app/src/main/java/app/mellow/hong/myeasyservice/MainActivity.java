package app.mellow.hong.myeasyservice;

import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import app.mellow.hong.myeasyservice.fragment.MainFragment;
import app.mellow.hong.myeasyservice.fragment.SecondFragment;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Add Fragment to activity
        addFragment(savedInstanceState);
        //Setup Drawer menu
        setupDrawerMenu();

        //Text Controller
        textController();

        //CreateToolbar
        createToolbar();
    }// Main Method

    // to add action on hamburger key
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    //tomade hamburgerkey
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }
    //tomade hamburgerkey
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    private void createToolbar() {
        toolbar = (Toolbar) findViewById(R.id.ToolbarMain);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle=new ActionBarDrawerToggle(MainActivity.this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void textController() {
        TextView MainTextView = (TextView) findViewById(R.id.txtMain);
        TextView SecondTextView = (TextView) findViewById(R.id.txtSecond);
        TextView ExitTextView = (TextView) findViewById(R.id.txtExit);

        //For MainFragment
        MainTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.contentFragmentMain, new MainFragment()).commit();
                drawerLayout.closeDrawers();
            }
        });

        //For SecondFragment
        SecondTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.contentFragmentMain, new SecondFragment()).commit();
                drawerLayout.closeDrawers();
            }
        });
        //For ExitFragment
        ExitTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                drawerLayout.closeDrawers();
            }
        });
    }

    private void setupDrawerMenu() {
        drawerLayout = (DrawerLayout) findViewById(R.id.MyDrawer);
    }

    private void addFragment(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.contentFragmentMain, new MainFragment()).commit();
        }
    }


}//Main Class
