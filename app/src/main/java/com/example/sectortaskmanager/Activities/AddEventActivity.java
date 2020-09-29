package com.example.sectortaskmanager.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;

import com.example.sectortaskmanager.MyDatePickerFragment;
import com.example.sectortaskmanager.R;

import java.util.Calendar;

public class AddEventActivity extends AppCompatActivity implements MyDatePickerFragment.startDateChangedListener, MyDatePickerFragment.startTimeChangedListener,
        MyDatePickerFragment.endDateChangedListener, MyDatePickerFragment.endTimeChangedListener
{
    private ConstraintLayout ringtoneLayout, startTimeLayout, endTimeLayout, reminderBeforeLayout, repeatModeLayout;
    private TextView startDateTextView, startTimeTextView, endTimeTextView, endDateTextView;
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        ringtoneLayout = findViewById(R.id.ringtoneLayout);
        startTimeLayout = findViewById(R.id.startTimeLayout);
        endTimeLayout = findViewById(R.id.endTimeLayout);
        reminderBeforeLayout = findViewById(R.id.reminderBeforeLayout);
        startDateTextView = findViewById(R.id.startDateTextView);
        endDateTextView = findViewById(R.id.endDateTextView);
        startTimeTextView = findViewById(R.id.startTimeTextView);
        endTimeTextView = findViewById(R.id.endTimeTextView);
        repeatModeLayout = findViewById(R.id.repeatModeLayout);
        calendar = Calendar.getInstance();
        setActualDate();
        setActualTime();
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.ringtoneLayout:
                        chooseRingtone();
                        break;
                    case R.id.startTimeLayout:
                        showStartDatePicker();
                        break;
                    case R.id.endTimeLayout:
                       showEndDatePicker();
                       break;
                    case R.id.reminderBeforeLayout:
                        chooseReminderBefore();
                        break;
                    case R.id.repeatModeLayout:
                        chooseRepeatMode();

                }
            }
        };

        reminderBeforeLayout.setOnClickListener(onClickListener);
        ringtoneLayout.setOnClickListener(onClickListener);
        startTimeLayout.setOnClickListener(onClickListener);
        endTimeLayout.setOnClickListener(onClickListener);
        repeatModeLayout.setOnClickListener(onClickListener);
    }

    private void chooseRepeatMode() {
        startActivity(new Intent(AddEventActivity.this, RepeatModeActivity.class));
    }

    private void chooseReminderBefore() {
        startActivity(new Intent(AddEventActivity.this, ChooseReminderBeforeActivity.class));
    }


    private void showEndDatePicker() {
        DialogFragment datePickerFragment = new MyDatePickerFragment();
        datePickerFragment.show(getSupportFragmentManager(), "end date picker");
    }

    private void showStartDatePicker() {
        DialogFragment datePickerFragment = new MyDatePickerFragment();
        datePickerFragment.show(getSupportFragmentManager(), "start date picker");
    }


    private void setActualDate() {
        CharSequence dateCharSequence = DateFormat.format("EEE, dd MMM yyyy", calendar);
        String dateString = dateCharSequence.toString();
        startDateTextView.setText(dateString);
        endDateTextView.setText(dateString);
    }

    private void setActualTime() {
        CharSequence timeCharSequence = DateFormat.format("h:mm a", calendar);
        String timeString = timeCharSequence.toString();
        startTimeTextView.setText(timeString);
        endTimeTextView.setText(timeString);
    }

    @Override
    public void changeStartDate(String date) {
        startDateTextView.setText(date);
    }

    @Override
    public void changeStartTime(String time) {
        startTimeTextView.setText(time);
    }

    @Override
    public void changeEndDate(String date) {
        endDateTextView.setText(date);
    }

    @Override
    public void changeEndTime(String time) {
        endTimeTextView.setText(time);
    }

    private void chooseRingtone() {
        startActivity(new Intent(AddEventActivity.this, ChooseSoundModeActivity.class));
    }
}