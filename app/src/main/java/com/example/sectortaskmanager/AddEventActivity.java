package com.example.sectortaskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddEventActivity extends AppCompatActivity {
FloatingActionButton addEventButton;
Button chooseRingtoneButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        chooseRingtoneButton = findViewById(R.id.chooseRingtoneButton);
        chooseRingtoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddEventActivity.this, ChooseNotificationBehaviourActivity.class);
                startActivity(intent);
            }
        });

    }


}