package com.example.project2;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager; // Creates a fragment manager
    public SectionsStatePagerAdapter mAdapter;
    public ViewPager mViewPager;
    public Stack<Integer> history;
    public int currentPg;
    public boolean savetoHistory;
    public Fragment fragment;

    //Creating arrays
    public ArrayList<String> listAnimals;
    public ArrayAdapter listAdapter;
    DatabaseHelper animal_registration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //SectionsStatePagerAdapter mSectionsStatePagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        mAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager)findViewById(R.id.container);
        mViewPager.setAdapter(mAdapter);
        //Only keeps previous 5 fragments
        mViewPager.setOffscreenPageLimit(5);


        history = new Stack<Integer>();
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            //Back stack
            @Override
            public void onPageSelected(int arg0) {
                if(savetoHistory)
                    history.push(Integer.valueOf(currentPg));
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
        savetoHistory = true;
        setupViewPager(mViewPager);

    }

    @Override
    public void onBackPressed() {
        if(history.empty())
            super.onBackPressed();
        else {
            savetoHistory = false;
            mViewPager.setCurrentItem(history.pop().intValue());
            savetoHistory = true;
        }
    };


    @Override
    protected void onPause() {
        super.onPause();
    }

    //Helps keep track of what number I should be calling when inflating the fragments in the container
    //The first fragment is 0 by default and then the others just count up
    public void setupViewPager(ViewPager viewPager) {
        SectionsStatePagerAdapter adapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new opening_fragment(),"OpeningFragment1"); //0
        adapter.addFragment(new choice_fragment(), "ChoiceFragment2"); //1
        adapter.addFragment(new adopter_login_fragment(), "AdopterFragment3 "); //2
        adapter.addFragment(new adopter_register_fragment(), "AdopterRegisterFragment4"); //3
        adapter.addFragment(new adopter_home_fragment(), "AdopterHomeFragment");//4
        adapter.addFragment(new shelter_login_fragment(), "ShelterLoginFragment");//5
        adapter.addFragment(new shelter_register_fragment(), "ShelterRegisterFragment");//6
        adapter.addFragment(new shelter_home_fragment(), "ShelterHomeFragment");//7
        adapter.addFragment(new shelter_add_animal_fragment(), "ShelterAddAnimal");//8
        adapter.addFragment(new shelter_animal_list(), "ShelterAnimalList");//9
        adapter.addFragment(new shelter_delete_animal(), "ShelterDeleteAnimal");//10

        viewPager.setAdapter(adapter);
    }


    //Set view pager
    public void setViewPager(int fragmentNumber){ mViewPager.setCurrentItem(fragmentNumber);
    }

}


