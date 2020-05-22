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

public class shelter_login_fragment extends Fragment {

    public EditText org_edit_text;
    public EditText shelter_username_edit_text;
    public EditText shelter_password_edit_text;
    public Button shelter_login_but;
    public TextView shelter_register_now;
    private ImageButton shel_login_back;
    DatabaseHelper shelter_registration;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shelter_login_fragment, container, false);

        shelter_registration = new DatabaseHelper(getContext());
        org_edit_text = (EditText) view.findViewById(R.id.org_edit_text);
        shelter_username_edit_text = (EditText) view.findViewById(R.id.shelter_username_edit_text);
        shelter_password_edit_text = (EditText) view.findViewById(R.id.shelter_password_edit_text);
        shelter_login_but = (Button) view.findViewById(R.id.shelter_login_but);
        shelter_register_now = (TextView) view.findViewById(R.id.shelter_register_now);
        shel_login_back = (ImageButton) view.findViewById(R.id.shel_login_back);


        //To Register Page via link
        shelter_register_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).setViewPager(6);
            }
        });

        //To home page
        //Checking the information in the database
        shelter_login_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String org = org_edit_text.getText().toString().trim();
                String username = shelter_username_edit_text.getText().toString().trim();
                String password = shelter_password_edit_text.getText().toString().trim();
                Boolean res = shelter_registration.check_sh_user(org, username, password);

                //Displayed depending on whether the data matches or not
                if (res == true) {
                    Toast.makeText(getActivity(), "Login Successful", Toast.LENGTH_SHORT).show();
                    ((MainActivity) getActivity()).setViewPager(7);
                } else {
                    Toast.makeText(getActivity(), "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Back to choice fragment
        shel_login_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).setViewPager(1);
            }
        });


        return view;

    }
}

