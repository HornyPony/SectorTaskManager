package com.example.sectortaskmanager.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.sectortaskmanager.MyDatePickerFragment;
import com.example.sectortaskmanager.R;

public class AddEventActivity extends AppCompatActivity {
    ConstraintLayout chooseRingtoneLayout, chooseStartTimeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        chooseRingtoneLayout = findViewById(R.id.chooseRingtoneLayout);
        chooseStartTimeLayout = findViewById(R.id.chooseStartTimeLayout);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.chooseRingtoneLayout:
                        chooseRingtone();
                        break;
                    case R.id.chooseStartTimeLayout:
                        showDatePicker();

                }
            }
        };

        chooseRingtoneLayout.setOnClickListener(onClickListener);
        chooseStartTimeLayout.setOnClickListener(onClickListener);
    }


    private void chooseRingtone() {
        startActivity(new Intent(AddEventActivity.this, ChooseNotificationBehaviourActivity.class));
    }

    private void showDatePicker() {
        DialogFragment datePickerFragment = new MyDatePickerFragment();
        datePickerFragment.show(getSupportFragmentManager(), "date picker");
    }


}