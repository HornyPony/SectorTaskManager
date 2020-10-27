package com.example.sectortaskmanager.SingleActivity.AddEvent.ChooseSound;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ChooseSoundPagerAdapter extends FragmentStatePagerAdapter {
    private int tabAmount;

    public ChooseSoundPagerAdapter(@NonNull FragmentManager fm, int tabAmount ) {
        super(fm);
        this.tabAmount = tabAmount;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new PresetMusicFragment();
            case 1:
                return new UserMusicFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabAmount;
    }
}
