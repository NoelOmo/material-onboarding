package com.noel.material_onboarding.adapter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.noel.material_onboarding.fragment.OnboardingFragment;

import java.util.ArrayList;


/**
 * Created by Noel on 11/12/2016.
 */
public class OnboardingAdapter extends FragmentPagerAdapter {

    private ArrayList<OnboardingFragment> fragments = new ArrayList<>();


    public OnboardingAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public OnboardingFragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }

    public void addItem(OnboardingFragment fragment){
        fragments.add(fragments.size(), fragment);
        this.notifyDataSetChanged();
    }

    public int getLastItemPosition() {
        return fragments.size() - 1;
    }
}
