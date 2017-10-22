package app.mellow.hong.myeasyservice.fragment;

import android.accessibilityservice.AccessibilityButtonController;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import app.mellow.hong.myeasyservice.R;

/**
 * Created by Hong on 22-Oct-17.
 */

public class SecondFragment extends Fragment {

    private ImageView imageView;

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

        //Image Controller
        imageController();
    }//Main

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == getActivity().RESULT_OK) {
            try {
                Uri uri =data.getData();
                Bitmap bitmap = BitmapFactory.decodeStream(getActivity().getContentResolver().openInputStream(uri));
                imageView.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }



        } else {
            Toast.makeText(getActivity(),"Not Choose Image",Toast.LENGTH_LONG).show();
        }
    }

    private void imageController() {
        imageView =getView().findViewById(R.id.imgPhoto);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent.createChooser(intent,"Please Choose App"),8);
            }
        });
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
