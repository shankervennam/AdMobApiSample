package com.example.rvennam.admobapisample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.rvennam.admobapisample.fragments.AdMobLisFragment;
import com.example.rvennam.admobapisample.fragments.AdMobTargetFragment;

public class MainActivity extends AppCompatActivity implements
        NavigationFragment.NavigationDrawerCallbacks
{
    public static final String LOG_TAG = "APIDemos";

    private NavigationFragment navigationFragment;

    private CharSequence mTitle;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationFragment = (NavigationFragment) getSupportFragmentManager().findFragmentById(R.id.nav_drawer);
        mTitle= getTitle();

        navigationFragment.setUp(R.id.nav_drawer, (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        switch (position)
        {
            case 0:transaction.replace(R.id.container, new AdMobLisFragment()); break;
            case 1:transaction.replace(R.id.container, new AdMobTargetFragment()); break;
        }
        transaction.commit();
    }
}
