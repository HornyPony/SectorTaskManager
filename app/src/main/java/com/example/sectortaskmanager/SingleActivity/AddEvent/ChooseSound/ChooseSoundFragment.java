package com.example.sectortaskmanager.SingleActivity.AddEvent.ChooseSound;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sectortaskmanager.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;


public class ChooseSoundFragment extends Fragment {
    private TabLayout tabLayout;
    private TabItem ourMusicItem, usersMusicItem;
    private ViewPager viewPager;
    ChooseSoundPagerAdapter chooseSoundPagerAdapter;

    public ChooseSoundFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_choose_sound, container, false);

        tabLayout = view.findViewById(R.id.tabLayout);
        ourMusicItem = view.findViewById(R.id.ourMusic);
        usersMusicItem = view.findViewById(R.id.usersMusic);
        viewPager = view.findViewById(R.id.viewPager);

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

        chooseSoundPagerAdapter = new ChooseSoundPagerAdapter(getFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(chooseSoundPagerAdapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        return view;
    }
}