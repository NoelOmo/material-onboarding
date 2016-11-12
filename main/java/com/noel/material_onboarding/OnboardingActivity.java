package com.noel.material_onboarding;

import android.animation.ArgbEvaluator;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import com.noel.material_onboarding.adapter.OnboardingAdapter;
import com.noel.material_onboarding.fragment.OnboardingFragment;

import java.util.ArrayList;
import java.util.List;

public class OnboardingActivity extends AppCompatActivity {


    private OnboardingAdapter mOnboardingAdapter;
    private ViewPager mViewPager;

    ImageButton btnNext;
    Button btnSkip, btnFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        btnNext = (ImageButton) findViewById(R.id.intro_btn_next);
        btnSkip = (Button) findViewById(R.id.intro_btn_skip);
        btnFinish = (Button) findViewById(R.id.intro_btn_finish);

        List<Fragment> fragmentList = getFragments();

        final int color1 = ContextCompat.getColor(this, R.color.cyan);
        final int color2 = ContextCompat.getColor(this, R.color.orange);
        final int color3 = ContextCompat.getColor(this, R.color.green);
        final int[] colorList = new int[]{color1, color2, color3};
        final ArgbEvaluator evaluator = new ArgbEvaluator();

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mOnboardingAdapter = new OnboardingAdapter(getSupportFragmentManager(), fragmentList);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mOnboardingAdapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int colorUpdate = (Integer) evaluator.evaluate(positionOffset, colorList[position], colorList[position == 2 ? position : position + 1]);
                mViewPager.setBackgroundColor(colorUpdate);


                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Window window = getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.setStatusBarColor(colorUpdate);
                }
            }

            @Override
            public void onPageSelected(int position) {
                btnFinish.setVisibility(position == 2 ? View.VISIBLE : View.GONE);
                btnNext.setVisibility(position == 2 ? View.GONE : View.VISIBLE);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    public List<Fragment> getFragments(){
        List<Fragment> fList = new ArrayList<Fragment>();
        fList.add(OnboardingFragment.newInstance(1));
        fList.add(OnboardingFragment.newInstance(2));
        fList.add(OnboardingFragment.newInstance(3));
        return fList;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_onboarding, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
