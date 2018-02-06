package com.example.sara.mysimplemath.other;

/**
 * Created by Sara on 16.3.2017..
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.sara.mysimplemath.fragment.Tab1ExplanationFragment;
import com.example.sara.mysimplemath.fragment.Tab2ExplanationFragment;
import com.example.sara.mysimplemath.fragment.TabExample1Fragment;
import com.example.sara.mysimplemath.fragment.TabExample2Fragment;

/**
 * It is part of TabLessonActivity
 *
 * Here is created viewpageradapter for an individual lesson after choosing field of study
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapter is created
    int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created


    // Build a Constructor and assign the passed Values to appropriate values in the class
    public ViewPagerAdapter(FragmentManager fm, CharSequence mTitles[], int mNumbOfTabsumb) {
        super(fm);

        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;

    }
    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            Tab1ExplanationFragment tab1explantion = new Tab1ExplanationFragment();
            return tab1explantion;
        }
        else if(position == 1){
            TabExample1Fragment tabExample = new TabExample1Fragment();
            return tabExample;
        }
        else if(position == 2){
            Tab2ExplanationFragment tab2explanation = new Tab2ExplanationFragment();
            return tab2explanation;
        }
        else{
            TabExample2Fragment tabQuestion = new TabExample2Fragment();
            return tabQuestion;
        }
    }

    // This method return the titles for the Tabs in the Tab Strip
    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

    // This method return the Number of tabs for the tabs Strip
    @Override
    public int getCount() {
        return NumbOfTabs;
    }
}
