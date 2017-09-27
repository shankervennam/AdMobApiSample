package com.example.rvennam.admobapisample.fragments;

import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.rvennam.admobapisample.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class AdMobTargetFragment extends Fragment
{
    private TextView textView;
    private Button button;
    private AdView mAdview;
    private EditText mReqAgent;
    private EditText mUrl;


    private RadioButton mMaleRadio;
    private RadioButton mFemaleRadio;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        View root = inflater.inflate(R.layout.admob_target_fragment, container, false);
        mAdview = root.findViewById(R.id.adView2);
        mMaleRadio = root.findViewById(R.id.targeting_rb_male);
        mFemaleRadio = root.findViewById(R.id.targeting_rb_female);
        mAdview = root.findViewById(R.id.adView2);
        button = root.findViewById(R.id.button);
        mReqAgent = root.findViewById(R.id.req_agent_edit);
        mUrl = root.findViewById(R.id.url_edit);
        final Location location = new Location("asdad");

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                AdRequest.Builder builder = new AdRequest.Builder();

                builder.setRequestAgent(mReqAgent.toString());
                builder.setContentUrl(mUrl.toString());

                if(mMaleRadio.isChecked())
                {
                    builder.setIsDesignedForFamilies(true);
                }
                else
                {
                    builder.setIsDesignedForFamilies(false);
                }
                builder.setLocation(location);

                AdRequest request = builder.build();
                mAdview.loadAd(request);
            }
        });
        return root;
    }

//8* *******
// private TextWatcher mTextWatcher = new TextWatcher()
//    {
//        @Override
//        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//        }
//
//        @Override
//        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//        }
//
//        @Override
//        public void afterTextChanged(Editable editable)
//        {
//            //checkForButton();
//        }
//    };
//
//    private void checkForButton()
//    {
//
//    }
}
