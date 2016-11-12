package com.noel.material_onboarding.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.noel.material_onboarding.fragment.OnboardingFragment;

import java.util.List;

/**
 * Created by Noel on 11/12/2016.
 */
public class OnboardingAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;


    public OnboardingAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return OnboardingFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }
}
