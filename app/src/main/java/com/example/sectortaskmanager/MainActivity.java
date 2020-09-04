package com.example.sectortaskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private ImageButton calendarImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendarImageButton = findViewById(R.id.calendarImageButton);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.calendarImageButton:
                        Uri.Builder builder = UserCalendar.createCalendar();
                        Intent intent = new Intent(Intent.ACTION_VIEW, builder.build());
                        startActivity(intent);
                }

            }

        };

        calendarImageButton.setOnClickListener(onClickListener);

    }
}