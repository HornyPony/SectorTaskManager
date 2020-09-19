package com.example.sectortaskmanager.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.sectortaskmanager.R;

public class ChooseNotificationBehaviourActivity extends AppCompatActivity {
    AppCompatCheckBox muteCheckBox, vibrationCheckBox, musicAndVibrationCheckBox, musicCheckBox;
    ConstraintLayout musicNameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_notifications_behaviour);
        muteCheckBox = findViewById(R.id.muteCheckBox);
        vibrationCheckBox = findViewById(R.id.vibrationCheckBox);
        musicAndVibrationCheckBox = findViewById(R.id.musicAndVibrationCheckBox);
        musicCheckBox = findViewById(R.id.musicCheckBox);
        musicNameLayout = findViewById(R.id.musicNameLayout);


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
                startActivity(new Intent(ChooseNotificationBehaviourActivity.this, ChooseSoundActivity.class));
        }
    }
}