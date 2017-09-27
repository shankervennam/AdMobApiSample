package com.example.rvennam.admobapisample.fragments;

import android.support.v4.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Spinner;

import com.example.rvennam.admobapisample.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

public class BannerSizes extends Fragment
{
    private AdView mAdview;
    private Button mSubmit;
    private FrameLayout mFrameLayout;
    private Spinner mSpinner;

    public BannerSizes()
    {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        View root = inflater.inflate(R.layout.banner_sizes, container, false);

        mSpinner = root.findViewById(R.id.spinner_sizes);
        mSubmit = root.findViewById(R.id.submit_button);
        mFrameLayout = root.findViewById(R.id.ad_frame);

        String[] sizesArray;

        int screenSize = getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;

        if((screenSize == Configuration.SCREENLAYOUT_SIZE_LARGE) || screenSize == Configuration.SCREENLAYOUT_SIZE_XLARGE)
        {
            sizesArray = getResources().getStringArray(R.array.bannersizes_largesizes);
        }
        else
        {
            sizesArray = getResources().getStringArray(R.array.bannersizes_smallsizes);
        }

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(root.getContext(),
                R.layout.support_simple_spinner_dropdown_item, sizesArray);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);

        root.findViewById(R.id.submit_button).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(mAdview != null)
                {
                    mFrameLayout.removeView(mAdview);
                    mAdview.destroy();
                }
                mAdview = new AdView(getActivity());
                mAdview.setAdUnitId("ca-app-pub-3940256099942544/6300978111");
                mFrameLayout.addView(mAdview);

                switch (mSpinner.getSelectedItemPosition())
                {
                    case 0:mAdview.setAdSize(AdSize.BANNER); break;
                    case 1:mAdview.setAdSize(AdSize.LARGE_BANNER); break;
                    case 2:mAdview.setAdSize(AdSize.SMART_BANNER); break;
                    case 3:mAdview.setAdSize(AdSize.FULL_BANNER); break;
                    case 4:mAdview.setAdSize(AdSize.MEDIUM_RECTANGLE); break;
                    case 5:mAdview.setAdSize(AdSize.LEADERBOARD); break;
                }
                mAdview.loadAd(new AdRequest.Builder().build());
            }
        });

        return root;
    }
}
