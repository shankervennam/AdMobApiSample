package com.example.rvennam.admobapisample.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rvennam.admobapisample.R;

public class AdMobTargetFragment extends Fragment
{
    TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        View root = inflater.inflate(R.layout.admob_target_fragment, container, false);
        textView = root.findViewById(R.id.admob_target);
        return root;
    }
}
