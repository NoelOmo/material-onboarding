package com.noel.material_onboarding.fragment;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.noel.material_onboarding.R;


/**
 * Created by Noel on 11/12/2016.
 */
public class OnboardingFragment extends Fragment {

    private static final String ARG_SLIDE_DESCRIPTION = "slide_description";
    private static final String ARG_SLIDE_COLOR = "slide_color";
    public static final String ARG_SLIDE_IMAGE = "slide_image";

    private int backgroundColor;
    private int image;

    private TextView textView;
    private ImageView slideImage;


    public OnboardingFragment() {
    }

    public static OnboardingFragment newInstance(SlideFragmentBuilder builder) {
        OnboardingFragment fragment = new OnboardingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_SLIDE_DESCRIPTION, builder.description);
        args.putInt(ARG_SLIDE_COLOR, builder.backgroundColor);
        args.putInt(ARG_SLIDE_IMAGE, builder.image);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_onboarding, container, false);

        textView = (TextView) rootView.findViewById(R.id.section_label);
        slideImage = (ImageView) rootView.findViewById(R.id.slideImage);

        Bundle bundle = getArguments();
        backgroundColor = bundle.getInt(ARG_SLIDE_COLOR);
        image = bundle.getInt(ARG_SLIDE_IMAGE, 0);

        textView.setText(bundle.getString(ARG_SLIDE_DESCRIPTION));

        updateViews();

        return rootView;
    }
    public void updateViews(){
        if(image != 0) {
            slideImage.setImageDrawable(ContextCompat.getDrawable(getActivity(), image));
        }
    }

    public int backgroundColor() {
        return backgroundColor;
    }


}
