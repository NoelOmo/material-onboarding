package com.noel.material_onboarding.fragment;

import com.noel.material_onboarding.Color;

/**
 * Created by Noel on 11/12/2016.
 */
public class SlideFragmentBuilder {
    int backgroundColor;
    String title;
    String description;
    private Color bgColor = new Color();

    public SlideFragmentBuilder backgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        bgColor.setBackgroundColor(backgroundColor);
        return this;
    }

    public SlideFragmentBuilder title(String title) {
        this.title = title;
        return this;
    }

    public SlideFragmentBuilder description(String description) {
        this.description = description;
        return this;
    }

    public OnboardingFragment build() {
        return OnboardingFragment.newInstance(this);
    }
}
