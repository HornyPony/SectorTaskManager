package com.example.sectortaskmanager.SingleActivity.AddEvent;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.sectortaskmanager.R;


public class ChooseNotificationBehaviourFragment extends Fragment {
    AppCompatCheckBox muteCheckBox, vibrationCheckBox, musicAndVibrationCheckBox, musicCheckBox;
    ConstraintLayout musicNameLayout;

    public ChooseNotificationBehaviourFragment() {
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
        View view = inflater.inflate(R.layout.fragment_choose_notification_behaviour, container, false);
        muteCheckBox = view.findViewById(R.id.muteCheckBox);
        vibrationCheckBox = view.findViewById(R.id.vibrationCheckBox);
        musicAndVibrationCheckBox = view.findViewById(R.id.musicAndVibrationCheckBox);
        musicCheckBox = view.findViewById(R.id.musicCheckBox);
        musicNameLayout = view.findViewById(R.id.musicNameLayout);


        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseElement(view);
            }

        };

        muteCheckBox.setOnClickListener(onClickListener);
        vibrationCheckBox.setOnClickListener(onClickListener);
        musicAndVibrationCheckBox.setOnClickListener(onClickListener);
        musicCheckBox.setOnClickListener(onClickListener);
        musicNameLayout.setOnClickListener(onClickListener);
        return  view;
    }

    private void chooseElement(View view) {
        switch (view.getId()) {
            case R.id.muteCheckBox:
                muteCheckBox.setChecked(true);
                vibrationCheckBox.setChecked(false);
                musicAndVibrationCheckBox.setChecked(false);
                musicCheckBox.setChecked(false);
                break;
            case R.id.vibrationCheckBox:
                muteCheckBox.setChecked(false);
                vibrationCheckBox.setChecked(true);
                musicAndVibrationCheckBox.setChecked(false);
                musicCheckBox.setChecked(false);
                break;
            case R.id.musicAndVibrationCheckBox:
                muteCheckBox.setChecked(false);
                vibrationCheckBox.setChecked(false);
                musicAndVibrationCheckBox.setChecked(true);
                musicCheckBox.setChecked(false);
                break;
            case R.id.musicCheckBox:
                muteCheckBox.setChecked(false);
                vibrationCheckBox.setChecked(false);
                musicAndVibrationCheckBox.setChecked(false);
                musicCheckBox.setChecked(true);
                break;
            case R.id.musicNameLayout:
                ChooseSoundFragment chooseSoundFragment = new ChooseSoundFragment();
                getFragmentManager().beginTransaction()
                        .replace(R.id.addEventContainer, chooseSoundFragment)
                        .addToBackStack(null)
                        .commit();
        }
    }
}