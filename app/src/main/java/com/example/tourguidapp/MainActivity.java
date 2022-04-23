package com.example.tourguidapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position){

                    case 0 :
                        return new ArtAndCultureFragment() ;
                    case 1 :
                        return new HistoricalMonumentFragment() ;
                    case 2 :
                        return new LocalFavoritesFragment() ;
                    default:
                        return null ;
                }

            }

            @Override
            public int getCount() {
                return 3;
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                switch (position){

                    case 0 :
                        return getString(R.string.art_and_culture) ;
                    case 1 :
                        return getString(R.string.historical_monument) ;
                    case 2 :
                        return getString(R.string.local_favorites) ;
                    default:
                        return null ;
                }
            }
        };

        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout) ;
        tabLayout.setupWithViewPager(viewPager);

    }
}