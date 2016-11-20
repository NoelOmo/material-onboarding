package com.noel.material_onboarding;

import android.animation.ArgbEvaluator;
import android.os.Build;

import android.support.annotation.ColorRes;
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
import com.noel.material_onboarding.fragment.SlideFragmentBuilder;



public class OnboardingActivity extends AppCompatActivity {


    private OnboardingAdapter mOnboardingAdapter = new OnboardingAdapter(getSupportFragmentManager());
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

        final ArgbEvaluator evaluator = new ArgbEvaluator();

        addSlide(new SlideFragmentBuilder()
                .description("This is a test")
                .backgroundColor(R.color.colorPrimary)
                .build());
        addSlide(new SlideFragmentBuilder()
                .description("This is a test 2")
                .backgroundColor(R.color.green)
                .build());
        addSlide(new SlideFragmentBuilder()
                .description("This is a test 3")
                .backgroundColor(R.color.orange)
                .build());
        addSlide(new SlideFragmentBuilder()
                .description("This is a test 4")
                .backgroundColor(R.color.cyan)
                .build());


        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mOnboardingAdapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

               int colorUpdate = (Integer) evaluator.evaluate(positionOffset,  color(mOnboardingAdapter.getItem(position).backgroundColor()), color(mOnboardingAdapter.getItem(positionOffset != 0.0 ? position + 1 : position).backgroundColor()));
                mViewPager.setBackgroundColor(colorUpdate);


                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Window window = getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.setStatusBarColor(colorUpdate);
                }
            }

            @Override
            public void onPageSelected(int position) {
                btnFinish.setVisibility(position == mOnboardingAdapter.getLastItemPosition() ? View.VISIBLE : View.GONE);
                btnNext.setVisibility(position == mOnboardingAdapter.getLastItemPosition() ? View.GONE : View.VISIBLE);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private int color(@ColorRes int color){
        return ContextCompat.getColor(this, color);

    }

    public void addSlide(OnboardingFragment fragment){
        mOnboardingAdapter.addItem(fragment);
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
