package com.example.project2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class adopter_login_fragment extends Fragment {

    public EditText adopter_username_edit_text;
    public EditText adopter_password_edit_text;
    public Button adopter_login_but;
    private ImageButton adopter_login_back;
    public TextView adopter_register_now;
    DatabaseHelper adopter_registration;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.adopter_login_fragment, container, false);

        adopter_registration = new DatabaseHelper(getContext());
        adopter_username_edit_text = (EditText) view.findViewById(R.id.adopter_username_edit_text);
        adopter_password_edit_text = (EditText) view.findViewById(R.id.adopter_password_edit_text);
        adopter_login_but = (Button) view.findViewById(R.id.adopter_login_but);
        adopter_login_back = (ImageButton) view.findViewById(R.id.adopter_login_back);
        adopter_register_now = (TextView) view.findViewById(R.id.adopter_register_now);

        //Link To Register Page
        adopter_register_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).setViewPager(3);
            }
        });

        //Checking the login information matches what is in the database
        adopter_login_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = adopter_username_edit_text.getText().toString().trim();
                String password = adopter_password_edit_text.getText().toString().trim();
                Boolean res = adopter_registration.check_ad_user(username, password);

                if (res == true) {
                    Toast.makeText(getActivity(), "Login Successful", Toast.LENGTH_SHORT).show();
                    ((MainActivity) getActivity()).setViewPager(4);
                } else {
                    Toast.makeText(getActivity(), "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Moving back to previous fragment
        adopter_login_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).setViewPager(1);
            }
        });



        return view;
    }
}