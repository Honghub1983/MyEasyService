package app.mellow.hong.myeasyservice.fragment;

import android.accessibilityservice.AccessibilityButtonController;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import app.mellow.hong.myeasyservice.R;

/**
 * Created by Hong on 22-Oct-17.
 */

public class SecondFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        return  view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        BackController();
        //button.setOnClickListener(ne);
    }

    private void BackController() {
        //Back Controller
        Button button = getView().findViewById(R.id.btnBack);
        //back Action
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 //move back to first page
                getActivity().getSupportFragmentManager().popBackStack();


            }
        });
    }

}
