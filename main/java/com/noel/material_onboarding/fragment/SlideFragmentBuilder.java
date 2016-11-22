package com.noel.material_onboarding.fragment;


/**
 * Created by Noel on 11/12/2016.
 */
public class SlideFragmentBuilder {
    int backgroundColor;
    String title;
    String description;
    int image;

    public SlideFragmentBuilder backgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }
    public SlideFragmentBuilder image(int image){
        this.image = image;
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
