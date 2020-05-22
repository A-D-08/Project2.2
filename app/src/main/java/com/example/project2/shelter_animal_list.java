package com.example.project2;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class shelter_animal_list extends Fragment {

//    public ArrayList<String> listAnimals;
//    public ArrayAdapter listAdapter;
//    DatabaseHelper animal_registration;

    private ImageButton shel_list_back;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shelter_animal_list, container, false);

        shel_list_back = (ImageButton) view.findViewById(R.id.shel_list_back);


//        listAnimals = new ArrayList<>();
//        animal_registration = new DatabaseHelper(getContext());
//
//        viewData();

        shel_list_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).setViewPager(7);
            }
        });


        return view;
    }

//    private void viewData(){
//        Cursor cursor = animal_registration.viewAnimals();
//
//        if(cursor.getCount() == 0){
//            Toast.makeText(getActivity(),"No data to show",Toast.LENGTH_SHORT).show();
//
//        }
//        else{
//            while (cursor.moveToNext()){
//                listAnimals.add(cursor.getString(1));
//            }
//
//            listAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1);
//
//        }
//    }
}
