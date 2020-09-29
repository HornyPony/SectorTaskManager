package com.example.sectortaskmanager.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.example.sectortaskmanager.Intro.IntroItem;
import com.example.sectortaskmanager.R;
import com.example.sectortaskmanager.databinding.ActivityChooseReminderBeforeBinding;


public class ChooseReminderBeforeActivity extends AppCompatActivity {

    private ActivityChooseReminderBeforeBinding binding;

    AppCompatCheckBox muteCheckBox, vibrationCheckBox, musicAndVibrationCheckBox, musicCheckBox;
    ConstraintLayout musicNameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_choose_reminder_before);


        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseElement(view);
            }

        };

        binding.daysBefore2CheckBox.setOnClickListener(onClickListener);
    //    vibrationCheckBox.setOnClickListener(onClickListener);
    //    musicAndVibrationCheckBox.setOnClickListener(onClickListener);
       // musicCheckBox.setOnClickListener(onClickListener);
       // musicNameLayout.setOnClickListener(onClickListener);
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

        }
    }
}