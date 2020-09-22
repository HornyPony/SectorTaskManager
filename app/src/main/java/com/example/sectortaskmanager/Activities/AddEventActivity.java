package com.example.sectortaskmanager.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.sectortaskmanager.MyDatePickerFragment;
import com.example.sectortaskmanager.R;

import org.w3c.dom.Text;

public class AddEventActivity extends AppCompatActivity implements MyDatePickerFragment.mDateChangedListener, MyDatePickerFragment.mTimeChangedListener {
    ConstraintLayout chooseRingtoneLayout, chooseStartTimeLayout;
public TextView startDateTextView;
public TextView startTimeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        chooseRingtoneLayout = findViewById(R.id.chooseRingtoneLayout);
        chooseStartTimeLayout = findViewById(R.id.chooseStartTimeLayout);
        startDateTextView = findViewById(R.id.startDateTextView);
        startTimeTextView = findViewById(R.id.startTimeTextView);

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

    @Override
    public void changeDate(String date) {
startDateTextView.setText(date);
    }

    @Override
    public void changeTime(String time) {
startTimeTextView.setText(time);
    }
}