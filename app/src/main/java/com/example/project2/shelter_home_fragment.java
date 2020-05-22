package com.example.project2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class shelter_home_fragment extends Fragment {

    public Button add_animal_but;
    public Button view_animals_but;
    public Button delete_animal_but;
    private ImageButton shel_home_back;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shelter_home_fragment, container, false);

        add_animal_but = (Button) view.findViewById(R.id.add_animal_but);
        view_animals_but = (Button) view.findViewById(R.id.view_animals_but);
        delete_animal_but = (Button) view.findViewById(R.id.delete_animal_but);
        shel_home_back = (ImageButton) view.findViewById(R.id.shel_home_back);

        //Moves to the add animal page
        add_animal_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).setViewPager(8);
            }
        });

        //Moves to the view animals page
        view_animals_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).setViewPager(9);
            }
        });

        //Moves to the delete animals page
        delete_animal_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).setViewPager(10);
            }
        });

        //Goes back to the shelter login page
        shel_home_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).setViewPager(5);
            }
        });


        return view;

    }}