package app.mellow.hong.myeasyservice.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import app.mellow.hong.myeasyservice.R;

/**
 * Created by Hong on 21-Oct-17.
 */

public class MainFragment extends Fragment{
//    create fragment
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main,container,false);
        return view;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        //button controller
        buttonController();


    }// Main Method

    private void buttonController() {
        //initial view
        Button button = getView().findViewById(R.id.btnGoToSecond);
        //Get event from click
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //move to second fragment
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contentFragmentMain, new SecondFragment()).addToBackStack(null).commit();
            } //on click action
        });
    }
}//Main Class
