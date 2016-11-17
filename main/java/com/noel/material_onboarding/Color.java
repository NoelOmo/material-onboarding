package com.noel.material_onboarding;

import com.noel.material_onboarding.fragment.SlideFragmentBuilder;

import java.util.ArrayList;

/**
 * Created by Noel on 11/17/2016.
 */
public class Color {
    private ArrayList <Integer> backgroundColors = new ArrayList<>();


    public void setBackgroundColor(int backgroundColor){
        backgroundColors.add(backgroundColor);
    }

    public int getBackgroundColor(int position){
        return backgroundColors.get(position);
    }
    public int bgsize(){
        return backgroundColors.size();
    }

}
