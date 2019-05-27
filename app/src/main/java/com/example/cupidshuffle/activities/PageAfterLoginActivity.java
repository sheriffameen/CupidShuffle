package com.example.cupidshuffle.activities;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.fragments.MainUserProfileFragment;
import com.example.cupidshuffle.fragments.ShuffleSelectedProfileFragment;
import com.example.cupidshuffle.fragments.ShuffleTheLoveBirdsFragment;
import com.example.cupidshuffle.fragments.ViewAllUserProfilesFragment;
import com.example.cupidshuffle.navigation.FragNav;
import com.example.cupidshuffle.fragments.ViewAllConnectionRequestsFragment;
import com.example.cupidshuffle.fragments.ViewAllPrivateMessagesFragment;

public class PageAfterLoginActivity extends AppCompatActivity implements FragNav {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_after_login);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        MainUserProfileFragment mainFragment = new MainUserProfileFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_fragment_container, mainFragment);
        fragmentTransaction.commit();

    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment clickedNavTabFragment = null;
            Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.main_fragment_container);

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    clickedNavTabFragment = new MainUserProfileFragment();
                    break;

                case R.id.navigation_discover:

                    clickedNavTabFragment = new ViewAllUserProfilesFragment();
                    break;

                case R.id.navigation_notifications:

                    clickedNavTabFragment = new ViewAllPrivateMessagesFragment();
                    break;

                case R.id.navigation_shuffle:

                    clickedNavTabFragment = new ShuffleTheLoveBirdsFragment();
                    break;

            case R.id.navigation_connection_requests:
                clickedNavTabFragment = new ViewAllConnectionRequestsFragment();
                    break;
        }

            getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, clickedNavTabFragment).commit();
            return true;
        }
    };

    @Override
    public void goToSelectedProfileAfterShuffle(String name, String age, String occupation, String picture, String location, String bio) {
            ShuffleSelectedProfileFragment shuffleSelectedProfileFragment = ShuffleSelectedProfileFragment.getInstance(name, age, occupation, picture, location, bio);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_fragment_container, shuffleSelectedProfileFragment)
                    .addToBackStack(null)
                    .commit();
        }
    }

