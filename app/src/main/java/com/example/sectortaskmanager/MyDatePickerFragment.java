package com.example.sectortaskmanager;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.text.format.DateFormat;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

public class MyDatePickerFragment extends DialogFragment {
    private int HOUR;
    private int MINUTE;
    private Calendar c;
    private startDateChangedListener startDateChangedListener;
    private startTimeChangedListener startTimeChangedListener;
    private endDateChangedListener endDateChangedListener;
    private endTimeChangedListener endTimeChangedListener;
    private Fragment endDate;
    private Fragment startDate;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        c = Calendar.getInstance();
        int YEAR = c.get(Calendar.YEAR);
        int MONTH = c.get(Calendar.MONTH);
        int DAY = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), dateSetListener, YEAR, MONTH, DAY);
    }

    private DatePickerDialog.OnDateSetListener dateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int month, int day) {
                    endDate = getActivity().getSupportFragmentManager().findFragmentByTag("end date picker");
                    startDate = getActivity().getSupportFragmentManager().findFragmentByTag("start date picker");

                    Calendar datePickerCalendar = Calendar.getInstance();
                    datePickerCalendar.set(Calendar.YEAR, year);
                    datePickerCalendar.set(Calendar.MONTH, month);
                    datePickerCalendar.set(Calendar.DATE, day);
                    CharSequence dateCharSequence = DateFormat.format("EEE, dd MMM yyyy", datePickerCalendar);
                    String dateString = dateCharSequence.toString();
                    if (startDate != null) {
                        startDateChangedListener.changeStartDate(dateString);
                    } else if (endDate != null) {
                        endDateChangedListener.changeEndDate(dateString);
                    }
                    showTimePicker();
                }
            };

    private void showTimePicker() {
        HOUR = c.get(Calendar.HOUR_OF_DAY);
        MINUTE = c.get(Calendar.MINUTE);
        boolean is24HourFormat = android.text.format.DateFormat.is24HourFormat(getActivity());

        // Launch Time Picker Dialog
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
                            startTimeChangedListener.changeStartTime(timeString);
                        } else if (endDate != null) {
                            endTimeChangedListener.changeEndTime(timeString);
                        }
                    }
                }, HOUR, MINUTE, is24HourFormat);
        timePickerDialog.show();
    }

    public interface startDateChangedListener {
        void changeStartDate(String date);
    }

    public interface startTimeChangedListener {
        void changeStartTime(String time);
    }

    public interface endDateChangedListener {
        void changeEndDate(String date);
    }

    public interface endTimeChangedListener {
        void changeEndTime(String time);
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            startDateChangedListener = (startDateChangedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement startDateChangedListener");
        }
        try {
            startTimeChangedListener = (startTimeChangedListener) context;
        } catch (Exception e) {
            throw new ClassCastException(context.toString() + "must implement startTimeChangedListener");
        }
        try {
            endDateChangedListener = (endDateChangedListener) context;
        } catch (Exception e) {
            throw new ClassCastException(context.toString() + "must implement endDateChangedListener");
        }
        try {
            endTimeChangedListener = (endTimeChangedListener) context;
        } catch (Exception e) {
            throw new ClassCastException(context.toString() + "must implement endTimeChangedListener");
        }
    }
}