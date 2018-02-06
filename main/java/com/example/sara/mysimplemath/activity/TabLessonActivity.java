package com.example.sara.mysimplemath.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.sara.mysimplemath.R;
import com.example.sara.mysimplemath.other.ViewPagerAdapter;


/**
 * Activity Tab lesson
 * After you choose smaller part of field this activity opens
 * Contains explanation tab, example tab, explanation tab, question tab
 */
public class TabLessonActivity extends AppCompatActivity{

    public Toolbar toolbar;
    ViewPager pager;
    ViewPagerAdapter adapter;
    TabLayout tabs;
    CharSequence Titles[]={"First part","Example one", "Second part", "Example two"};
    int Numboftabs =4;

    public String cardTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_lesson);

        toolbar =(Toolbar) findViewById(R.id.tab_lesson_tool_bar);
        setSupportActionBar(toolbar);

        adapter = new ViewPagerAdapter(getSupportFragmentManager(),Titles,Numboftabs);

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);

        // Assiging the Tab Layout View
        tabs = (TabLayout) findViewById(R.id.tabs);

        // Setting the ViewPager For the TabsLayout
        tabs.setupWithViewPager(pager);

        cardTitle = getIntent().getStringExtra("CardTitle");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_settings_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public String getCardTitle(){return cardTitle;}
    public Toolbar getToolbar(){return toolbar;}
}

