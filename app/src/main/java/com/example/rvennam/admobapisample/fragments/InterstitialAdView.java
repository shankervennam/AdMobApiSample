package com.example.rvennam.admobapisample.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.rvennam.admobapisample.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class InterstitialAdView extends Fragment
{
    private Button mInterstAd;
    private InterstitialAd mInterstitialAd;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {

        View root = inflater.inflate(R.layout.interstitial_ad, container, false);

        MobileAds.initialize(getActivity(), "ca-app-pub-3940256099942544~3347511713");
        mInterstitialAd = new InterstitialAd(getActivity());

        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");

        root.findViewById(R.id.interstitial_ad).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                showInterstitial();
            }
        });

        return root;
    }
    private void showInterstitial()
    {
            AdRequest adRequest = new AdRequest.Builder().build();
            mInterstitialAd.loadAd(adRequest);
            mInterstitialAd.show();

    }

}
