package app.mellow.hong.myeasyservice;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import app.mellow.hong.myeasyservice.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
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

    }// Main Method

    private void textController() {
        TextView MainTextView = (TextView) findViewById(R.id.txtMain);
        TextView    SecondTextView = (TextView) findViewById(R.id.txtSecond);
        TextView    ExitTextView   = (TextView) findViewById(R.id.txtExit);

        //For MainFragment
        MainTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 drawerLayout.closeDrawers();
            }
        });

        //For SecondFragment
        SecondTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawers();
            }
        });
        //For ExitFragment
        ExitTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawers();
            }
        });
    }

    private void setupDrawerMenu() {
        drawerLayout= (DrawerLayout) findViewById(R.id.MyDrawer);
    }

    private void addFragment(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.contentFragmentMain,new MainFragment()).commit();
        }
    }


}//Main Class
