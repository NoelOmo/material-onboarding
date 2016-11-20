package com.noel.material_onboarding.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.noel.material_onboarding.R;


/**
 * Created by Noel on 11/12/2016.
 */
public class OnboardingFragment extends Fragment {

    private static final String ARG_SLIDE_DESCRIPTION = "slide_description";
    private static final String ARG_SLIDE_COLOR = "slide_color";

    private int backgroundColor;


    public OnboardingFragment() {
    }

    public static OnboardingFragment newInstance(SlideFragmentBuilder builder) {
        OnboardingFragment fragment = new OnboardingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_SLIDE_DESCRIPTION, builder.description);
        args.putInt(ARG_SLIDE_COLOR, builder.backgroundColor);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_onboarding, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.section_label);
        Bundle bundle = getArguments();
        textView.setText(bundle.getString(ARG_SLIDE_DESCRIPTION));

        backgroundColor = bundle.getInt(ARG_SLIDE_COLOR);
        return rootView;
    }

    public int backgroundColor() {
        return backgroundColor;
    }


}
