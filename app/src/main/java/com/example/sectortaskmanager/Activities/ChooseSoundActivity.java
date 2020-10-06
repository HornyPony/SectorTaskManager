package com.example.sectortaskmanager.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import com.example.sectortaskmanager.ChooseSound.ChooseSoundPagerAdapter;
import com.example.sectortaskmanager.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class ChooseSoundActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private TabItem ourMusicItem, usersMusicItem;
    private ViewPager viewPager;
ChooseSoundPagerAdapter chooseSoundPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_sound);

        tabLayout = findViewById(R.id.tabLayout);
        ourMusicItem = findViewById(R.id.ourMusic);
        usersMusicItem = findViewById(R.id.usersMusic);
        viewPager = findViewById(R.id.viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        chooseSoundPagerAdapter = new ChooseSoundPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(chooseSoundPagerAdapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}