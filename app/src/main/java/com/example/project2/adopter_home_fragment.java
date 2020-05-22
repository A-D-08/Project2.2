package com.example.project2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class adopter_home_fragment extends Fragment {


    private ImageButton adopter_home_back;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.adopter_home_fragment, container, false);


        adopter_home_back = (ImageButton) view.findViewById(R.id.adopter_home_back);

        //Back button to the login page
        adopter_home_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).setViewPager(2);
            }
        });

        return view;
    }
}