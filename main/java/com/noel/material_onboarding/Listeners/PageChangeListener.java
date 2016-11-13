package com.noel.material_onboarding.Listeners;

import android.animation.ArgbEvaluator;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.view.Window;
import android.view.WindowManager;

import com.noel.material_onboarding.adapter.OnboardingAdapter;
import com.noel.material_onboarding.fragment.OnboardingFragment;

/**
 * Created by Noel on 11/12/2016.
 */
public class PageChangeListener implements ViewPager.OnPageChangeListener {
    private final OnboardingAdapter adapter;
    private final ArgbEvaluator evaluator = new ArgbEvaluator();

    public PageChangeListener(OnboardingAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        //int colorUpdate = (Integer) evaluator.evaluate(positionOffset, colorList[position], colorList[position == mOnboardingAdapter.getLastItemPosition() ? position : position + 1]);
        //mViewPager.setBackgroundColor(colorUpdate);


       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(colorUpdate);
    }*/
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
