package com.example.rvennam.admobapisample.fragments;

import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.rvennam.admobapisample.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class AdMobLisFragment extends Fragment
{
    private AdView adView;

    private RadioButton mMaleRadio;
    private RadioButton mFemaleRadio;
    private Button button;
    private LocationManager locationManager;
    private EditText mReqAgent;
    private EditText mUrl;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View root = inflater.inflate(R.layout.admob_adlisten_fragment, container, false);
        mMaleRadio = root.findViewById(R.id.targeting_rb_male);
        mFemaleRadio = root.findViewById(R.id.targeting_rb_female);
        adView = root.findViewById(R.id.adView2);
        button = root.findViewById(R.id.button);
        mReqAgent = root.findViewById(R.id.req_agent_edit);
        mUrl = root.findViewById(R.id.url_edit);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        adView = getView().findViewById(R.id.ad_listener);

        adView.setAdListener(new AdListener()
        {
            @Override
            public void onAdClosed()
            {

            }

            @Override
            public void onAdFailedToLoad(int i)
            {
                Log.i("Ads", ":Ad failed to load");
            }

            @Override
            public void onAdLeftApplication()
            {
            }

            @Override
            public void onAdOpened()
            {
            }

            @Override
            public void onAdLoaded()
            {
            }

            @Override
            public void onAdClicked()
            {

            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }
}
