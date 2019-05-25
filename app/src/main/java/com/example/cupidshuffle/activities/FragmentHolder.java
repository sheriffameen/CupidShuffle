package com.example.cupidshuffle.activities;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;

import com.example.cupidshuffle.R;
import com.example.cupidshuffle.fragments.ShuffleSelectedProfileFragment;
import com.example.cupidshuffle.fragments.UserProfileFragment;
import com.example.cupidshuffle.fragments.AllUserProfilesFragment;
import com.example.cupidshuffle.vpfragments.ViewAllConnectionRequestsFragment;
import com.example.cupidshuffle.vpfragments.ViewAllPrivateMessagesFragment;

public class FragmentHolder extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_after_login);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        UserProfileFragment mainFragment = new UserProfileFragment();
        inflateFragment(mainFragment);

    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment clickedNavTabFragment;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    clickedNavTabFragment = new UserProfileFragment();
                    inflateFragment(clickedNavTabFragment);
                    break;

                case R.id.navigation_discover:

                    clickedNavTabFragment = new AllUserProfilesFragment();
                    inflateFragment(clickedNavTabFragment);
                    break;

                case R.id.navigation_notifications:

                    clickedNavTabFragment = new ViewAllPrivateMessagesFragment();
                    inflateFragment(clickedNavTabFragment);
                    break;

                case R.id.navigation_shuffle:

                    clickedNavTabFragment = new ShuffleSelectedProfileFragment();
                    inflateFragment(clickedNavTabFragment);
                    break;

            case R.id.navigation_connection_requests:
                clickedNavTabFragment = new ViewAllConnectionRequestsFragment();
                inflateFragment(clickedNavTabFragment);
                break;
        }

            return true;
        }
    };

    private void inflateFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_fragment_container,fragment).addToBackStack(null)
                .commit();
    }



}
