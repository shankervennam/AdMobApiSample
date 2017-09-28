package com.example.rvennam.admobapisample.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rvennam.admobapisample.R;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdView;

public class DFPCategoryExlusion extends Fragment
{
    private PublisherAdView mNoExclusionsAdView;
    private PublisherAdView mDogsExcludedAdView;
    private PublisherAdView mCatsExcludedAdView;

    public DFPCategoryExlusion() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.dfp_category, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        mNoExclusionsAdView = getView().findViewById(R.id.no_exclusions_av);
        mDogsExcludedAdView = getView().findViewById(R.id.exclusions_av_dogsexcluded);
        mCatsExcludedAdView = getView().findViewById(R.id.exclusions_av_catsexcluded);

        PublisherAdRequest noExclusionsRequest  = new PublisherAdRequest.Builder().build();
        PublisherAdRequest dogsExcludedRequest = new PublisherAdRequest.Builder().
                addCategoryExclusion("apidemo_exclude_dogs").build();
        PublisherAdRequest catsExcludedRequest = new PublisherAdRequest.Builder().addCategoryExclusion("apidemo_exclude_cats").build();

        mNoExclusionsAdView.loadAd(noExclusionsRequest);
        mDogsExcludedAdView.loadAd(dogsExcludedRequest);
        mCatsExcludedAdView.loadAd(catsExcludedRequest);
    }
}
