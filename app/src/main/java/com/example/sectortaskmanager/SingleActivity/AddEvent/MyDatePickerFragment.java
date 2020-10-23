package com.example.sectortaskmanager.SingleActivity.AddEvent;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.text.format.DateFormat;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.sectortaskmanager.SingleActivity.AddEvent.AddEventUtils.SharedPreferencesHelper;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class MyDatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    private int HOUR;
    private int MINUTE;
    private Calendar c;
    private Fragment endDate;
    private Fragment startDate;
    private Intent dateIntent;
    private SharedPreferencesHelper mSharedPreferencesHelper;
    private String startDateString, endDateString;
    private Calendar startDatePickerCalendar, endDatePickerCalendar;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        c = Calendar.getInstance();
        int YEAR = c.get(Calendar.YEAR);
        int MONTH = c.get(Calendar.MONTH);
        int DAY = c.get(Calendar.DAY_OF_MONTH);

        mSharedPreferencesHelper = new SharedPreferencesHelper(Objects.requireNonNull(getActivity()));
        return new DatePickerDialog(getActivity(), MyDatePickerFragment.this, YEAR, MONTH, DAY);
    }

    private void showTimePicker(final String dateString) {
        HOUR = c.get(Calendar.HOUR_OF_DAY);
        MINUTE = c.get(Calendar.MINUTE);
        boolean is24HourFormat = android.text.format.DateFormat.is24HourFormat(getActivity());

        TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(),
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Calendar timePickerCalendar = Calendar.getInstance();
                        timePickerCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        timePickerCalendar.set(Calendar.MINUTE, minute);
                        CharSequence timeCharSequence = DateFormat.format("h:mm a", timePickerCalendar);
                        String timeString = timeCharSequence.toString();
                        if (startDate != null) {
                            changeStartDate(dateString, timeString);
                        } else if (endDate != null) {
                            changeEndDate(dateString, timeString);
                        }
                    }
                }, HOUR, MINUTE, is24HourFormat);
        timePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        endDate = getActivity().getSupportFragmentManager().findFragmentByTag("end date picker");
        startDate = getActivity().getSupportFragmentManager().findFragmentByTag("start date picker");

        if (startDate != null) {
            startDateString = chooseStartDate(year, month, day);
            saveStartDateInSP(startDatePickerCalendar);
            showTimePicker(startDateString);
        } else if (endDate != null) {
            endDateString = chooseEndDate(year, month, day);
            saveEndDateInSP(endDatePickerCalendar);
            showTimePicker(endDateString);
        }
    }

    private String chooseEndDate(int year, int month, int day) {
        endDatePickerCalendar = Calendar.getInstance();
        endDatePickerCalendar.set(Calendar.YEAR, year);
        endDatePickerCalendar.set(Calendar.MONTH, month);
        endDatePickerCalendar.set(Calendar.DATE, day);
        CharSequence endDateCharSequence = DateFormat.format("EEE, dd MMM yyyy", endDatePickerCalendar);
        return endDateCharSequence.toString();

    }

    private String chooseStartDate(int year, int month, int day) {
        startDatePickerCalendar = Calendar.getInstance();
        startDatePickerCalendar.set(Calendar.YEAR, year);
        startDatePickerCalendar.set(Calendar.MONTH, month);
        startDatePickerCalendar.set(Calendar.DATE, day);
        CharSequence startDateCharSequence = DateFormat.format("EEE, dd MMM yyyy", startDatePickerCalendar);
        return startDateCharSequence.toString();
    }

    private void changeEndDate(String endDateString, String endTimeString) {
        dateIntent = new Intent();
        dateIntent.putExtra("endDate", endDateString);
        dateIntent.putExtra("endTime", endTimeString);
        getTargetFragment().onActivityResult(
                getTargetRequestCode(),
                Activity.RESULT_OK,
                dateIntent);
    }

    private void changeStartDate(String startDateString, String startTimeString) {
        dateIntent = new Intent();
        dateIntent.putExtra("startDate", startDateString);
        dateIntent.putExtra("startTime", startTimeString);
        getTargetFragment().onActivityResult(
                getTargetRequestCode(),
                Activity.RESULT_OK,
                dateIntent);
    }

    private void saveStartDateInSP(Calendar startDatePickerCalendar) {
        Date startDate = startDatePickerCalendar.getTime();
        mSharedPreferencesHelper.addStartCalendarDate(startDate);
    }

    private void saveEndDateInSP(Calendar endDatePickerCalendar) {
        Date endDate = endDatePickerCalendar.getTime();
        mSharedPreferencesHelper.addEndCalendarDate(endDate);
    }
}