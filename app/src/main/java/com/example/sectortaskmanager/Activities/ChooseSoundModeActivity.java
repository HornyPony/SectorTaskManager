package com.example.sectortaskmanager.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.sectortaskmanager.R;

public class ChooseSoundModeActivity extends AppCompatActivity {
private ConstraintLayout chooseMusicLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_sound_mode);

        chooseMusicLayout = findViewById(R.id.chooseMusicLayout);

        chooseMusicLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChooseSoundModeActivity.this, ChooseSoundActivity.class));
            }
        });
    }
}