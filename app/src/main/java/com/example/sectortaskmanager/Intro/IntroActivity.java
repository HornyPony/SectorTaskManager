package com.example.sectortaskmanager.Intro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import com.example.sectortaskmanager.R;
import com.example.sectortaskmanager.Resources.IntroItems;
import com.example.sectortaskmanager.ViewPagerItemFragment;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;

public class IntroActivity extends AppCompatActivity {
    private ViewPager introViewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        introViewPager = findViewById(R.id.introViewPager);
        tabLayout = findViewById(R.id.tab_layout);
        
        init();
    }

    private void init() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        IntroItem[] introItems = IntroItems.getIntroItems();
        for (IntroItem introItem : introItems){
            ViewPagerItemFragment fragment = ViewPagerItemFragment.getInstance(introItem);
            fragments.add(fragment);
        }

        IntroAdapter introAdapter = new IntroAdapter(getSupportFragmentManager(), fragments);
        introViewPager.setAdapter(introAdapter);
        tabLayout.setupWithViewPager(introViewPager, true);
    }
}