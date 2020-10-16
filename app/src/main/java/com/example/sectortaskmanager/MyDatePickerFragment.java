package com.example.sectortaskmanager;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.text.format.DateFormat;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Objects;

public class MyDatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    private int HOUR;
    private int MINUTE;
    private Calendar c;
    private Fragment endDate;
    private Fragment startDate;
    private Intent dateIntent;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        c = Calendar.getInstance();
        int YEAR = c.get(Calendar.YEAR);
        int MONTH = c.get(Calendar.MONTH);
        int DAY = c.get(Calendar.DAY_OF_MONTH);

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
        endDate = (getActivity()).getSupportFragmentManager().findFragmentByTag("end date picker");
        startDate = getActivity().getSupportFragmentManager().findFragmentByTag("start date picker");
        Calendar datePickerCalendar = Calendar.getInstance();
        datePickerCalendar.set(Calendar.YEAR, year);
        datePickerCalendar.set(Calendar.MONTH, month);
        datePickerCalendar.set(Calendar.DATE, day);
        CharSequence dateCharSequence = DateFormat.format("EEE, dd MMM yyyy", datePickerCalendar);
        String dateString = dateCharSequence.toString();
        if (startDate != null) {
            showTimePicker(dateString);
        } else if (endDate != null) {
           showTimePicker(dateString);
        }
    }

    private void changeEndDate( String endDateString, String endTimeString){
        dateIntent = new Intent();
        dateIntent.putExtra("endDate", endDateString);
        dateIntent.putExtra("endTime", endTimeString);
        getTargetFragment().onActivityResult(
                getTargetRequestCode(),
                Activity.RESULT_OK,
                dateIntent);

    }

    private void changeStartDate( String startDateString, String startTimeString){
        dateIntent = new Intent();
        dateIntent.putExtra("startDate", startDateString);
        dateIntent.putExtra("startTime", startTimeString);
        getTargetFragment().onActivityResult(
                getTargetRequestCode(),
                Activity.RESULT_OK,
                dateIntent);


    }

}