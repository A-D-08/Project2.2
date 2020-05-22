package com.example.project2;

import android.Manifest;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;
import androidx.fragment.app.Fragment;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class shelter_add_animal_fragment extends Fragment {

    DatabaseHelper animal_registration;
    private ImageButton shel_add_back;
    public EditText add_animal_type;
    public EditText add_animal_breed;
    public EditText add_animal_name;
    public EditText add_animal_descrip;
    public Button choose_image;
    public Button add_new_animal_but;
    public ImageView add_animal_imageview;
    public static final int Select_fromGal = 101;
    //public static final int Permission_Code = 102;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shelter_add_animal_fragment, container, false);

        animal_registration = new DatabaseHelper(getContext());
        shel_add_back = (ImageButton) view.findViewById(R.id.shel_add_back);
        add_animal_type = (EditText) view.findViewById(R.id.add_animal_type);
        add_animal_breed = (EditText) view.findViewById(R.id.add_animal_breed);
        add_animal_name = (EditText) view.findViewById(R.id.add_animal_name);
        add_animal_descrip = (EditText) view.findViewById(R.id.add_animal_descrip);
        choose_image = (Button) view.findViewById(R.id.choose_image);
        add_new_animal_but = (Button) view.findViewById(R.id.add_new_animal_but);
        add_animal_imageview = (ImageView) view.findViewById(R.id.add_animal_imageview);

        //Moving back to the shelter home page
        shel_add_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).setViewPager(7);
            }
        });

//        choose_image.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//            }
//        });

        //Adding new animal to the Animal table of the database
        add_new_animal_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = add_animal_name.getText().toString().trim();
                String type = add_animal_type.getText().toString().trim();
                String breed = add_animal_breed.getText().toString().trim();
                String description = add_animal_descrip.getText().toString().trim();

                long val = animal_registration.add_Animal(name, type, breed, description);

            }
        });


        return view;

    }}
