package com.example.project2;

        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;

        import androidx.annotation.Nullable;
        import androidx.fragment.app.Fragment;

public class opening_fragment extends Fragment {

    private Button goto_signup_but;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.opening_fragment, container, false);

        goto_signup_but = (Button) view.findViewById(R.id.goto_signup_but);


        //Moving to next fragment
        goto_signup_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getActivity(), "Navigating to Login", Toast.LENGTH_SHORT).show();

                ((MainActivity)getActivity()).setViewPager(1);
            }
        });

        return view;
    }

}
