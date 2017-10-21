package app.mellow.hong.myeasyservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import app.mellow.hong.myeasyservice.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.contentFragmentMain,new MainFragment()).commit();
        }
    }// Main Method


}//Main Class
