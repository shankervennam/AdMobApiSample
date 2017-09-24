package com.example.rvennam.admobapisample;

import android.app.ActionBar;
import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NavigationFragment extends Fragment
{
    private static final String STATE_SELECTED_POSITION = "selected_navigation_drawer";
    private static final String PREF_USER_LEARNED_DRAWER = "navigation_drawer_learned";

    private ListView mDrawerListView;

    private int mCurrentSelectedPosition;
    private boolean mUserLearnedDrawer;
    private boolean mFromSavedInstanceState;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
        mUserLearnedDrawer = sp.getBoolean(PREF_USER_LEARNED_DRAWER, false);

        if(savedInstanceState != null)
        {
            mCurrentSelectedPosition = savedInstanceState.getInt(STATE_SELECTED_POSITION);
            mFromSavedInstanceState = true;
        }

        selectItem(mCurrentSelectedPosition);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, Bundle savedInstanceState)
    {
     mDrawerListView = (ListView) inflater.inflate(R.layout.fragment_nav_drawer, container, false);
        mDrawerListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
            {
                selectItem(position);
            }
        });

        mDrawerListView.setAdapter(new ArrayAdapter<String>(
                getActionBar().getThemedContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                getResources().getStringArray(R.array.fragment_names)));
        mDrawerListView.setItemChecked(mCurrentSelectedPosition, true);
        return mDrawerListView;


    }

//    private ActionBar getActionBar()
//    {
//        return ((AppCompatActivity) getActivity()).getSupportActionBar();
//    }

    private android.support.v7.app.ActionBar getActionBar()
    {
        return ((AppCompatActivity) getActivity()).getSupportActionBar();
    }

    private void selectItem(int mCurrentSelectedPosition)
    {

    }
}
