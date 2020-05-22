package com.example.project2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class choice_fragment extends Fragment {

    //Declaring objects
    private Button adopter_but;
    private Button shelter_but;
    private ImageButton choice_back;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.choice_fragment, container, false);

        adopter_but = (Button) view.findViewById(R.id.adopter_but);
        shelter_but = (Button) view.findViewById(R.id.shelter_but);
        choice_back = (ImageButton) view.findViewById(R.id.choice_back);


        //Moving to the adopter_login fragment
        adopter_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).setViewPager(2);
                //MainActivity.fragmentManager.beginTransaction().replace(R.id.container, new adopter_login_fragment(), null.addToBackStack(null)commit();
            }
        });

        //Moving to shelter_login fragment
        shelter_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).setViewPager(5);
            }
        });

        //Going back to the previous fragment (opening)
        choice_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).setViewPager(0);
            }
        });


        return view;
    }
}

