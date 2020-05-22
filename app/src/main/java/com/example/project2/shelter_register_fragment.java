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

public class shelter_register_fragment extends Fragment {

    DatabaseHelper shelter_registration;
    public EditText shelter_register_org_edit_text;
    public EditText shelter_register_username_edit_text;
    public EditText shelter_register_password_edit_text;
    public EditText shelter_register_confirm_password_edit_text;
    public EditText shelter_register_email_address_edit_text;
    public Button shelter_register_but;
    private ImageButton shel_reg_back;
    public TextView shelter_login_link;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shelter_register_fragment, container, false);

        shelter_registration = new DatabaseHelper(getContext());
        shelter_register_org_edit_text = (EditText) view.findViewById(R.id.shelter_register_org_edit_text);
        shelter_register_username_edit_text = (EditText) view.findViewById(R.id.shelter_register_username_edit_text);
        shelter_register_password_edit_text = (EditText) view.findViewById(R.id.shelter_register_password_edit_text);
        shelter_register_confirm_password_edit_text = (EditText) view.findViewById(R.id.shelter_register_confirm_password_edit_text);
        shelter_register_email_address_edit_text = (EditText) view.findViewById(R.id.shelter_register_email_address_edit_text);
        shelter_register_but = (Button) view.findViewById(R.id.shelter_register_but);
        shel_reg_back = (ImageButton) view.findViewById(R.id.shel_reg_back);
        shelter_login_link = (TextView) view.findViewById(R.id.shelter_login_link);

        //Moving back to the shelter login page via the link
        shelter_login_link.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                ((MainActivity) getActivity()).setViewPager(5);
            }
        });

        //Adding the newly registered information to the database
        shelter_register_but.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String org = shelter_register_org_edit_text.getText().toString().trim();
                String username = shelter_register_username_edit_text.getText().toString().trim();
                String password = shelter_register_password_edit_text.getText().toString().trim();
                String confirm_password = shelter_register_confirm_password_edit_text.getText().toString().trim();
                String email_address = shelter_register_email_address_edit_text.getText().toString().trim();

                //Making sure that the passwords match
                if(password.equals(confirm_password)){
                    long val = shelter_registration.add_Sh_User(org, username, password, email_address);
                    if(val > 0){
                        Toast.makeText(getActivity(), "You have registered ", Toast.LENGTH_SHORT).show();
                        ((MainActivity) getActivity()).setViewPager(5);

                    }
                    else{
                        Toast.makeText(getActivity(), "Registration Error", Toast.LENGTH_SHORT).show();
                    }

                }
                else{
                    Toast.makeText(getActivity(), "Passwords Do Not Match", Toast.LENGTH_SHORT).show();
                }
            }

        });

        //Button back to the shelter login page
        shel_reg_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).setViewPager(5);
            }
        });


        return view;
    }}
