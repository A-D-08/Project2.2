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

public class adopter_register_fragment extends Fragment {

    DatabaseHelper adopter_registration;
    public EditText adopter_register_username_edit_text;
    public EditText adopter_register_password_edit_text;
    public EditText adopter_register_confirm_password_edit_text;
    public EditText adopter_register_email_address_edit_text;
    public Button adopter_register_but;
    private ImageButton adopter_reg_back;
    public TextView adopter_login_link;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.adopter_register_fragment, container, false);

        adopter_registration = new DatabaseHelper(getContext());
        adopter_register_username_edit_text = (EditText) view.findViewById(R.id.adopter_register_username_edit_text);
        adopter_register_password_edit_text = (EditText) view.findViewById(R.id.adopter_register_password_edit_text);
        adopter_register_confirm_password_edit_text = (EditText) view.findViewById(R.id.adopter_register_confirm_password_edit_text);
        adopter_register_email_address_edit_text = (EditText) view.findViewById(R.id.adopter_register_email_address_edit_text);
        adopter_register_but = (Button) view.findViewById(R.id.adopter_register_but);
        adopter_reg_back = (ImageButton) view.findViewById(R.id.adopter_reg_back);
        adopter_login_link = (TextView) view.findViewById(R.id.adopter_login_link);

        //Link to adopter login page
        adopter_login_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).setViewPager(2);
    }
});
        //Adding the information to the adopter table in the database
        adopter_register_but.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String username = adopter_register_username_edit_text.getText().toString().trim();
                String password = adopter_register_password_edit_text.getText().toString().trim();
                String confirm_password = adopter_register_confirm_password_edit_text.getText().toString().trim();
                String email_address = adopter_register_email_address_edit_text.getText().toString().trim();

                //Making sure that the passwords match
                if(password.equals(confirm_password)){
                    long val = adopter_registration.add_User(username, password, email_address);
                    if(val > 0){
                        Toast.makeText(getActivity(), "You have registered", Toast.LENGTH_SHORT).show();
                        ((MainActivity) getActivity()).setViewPager(2);

                    }
                    else{
                        Toast.makeText(getActivity(), "Registration Error", Toast.LENGTH_SHORT).show();
                    }

                }
                //If they don't match
                else{
                    Toast.makeText(getActivity(), "Passwords Do Not Match", Toast.LENGTH_SHORT).show();
                }
            }

        });

        adopter_reg_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).setViewPager(2);
            }
        });

        return view;
    }
}
