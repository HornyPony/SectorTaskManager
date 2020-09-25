package com.example.sectortaskmanager;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class MyTimePickerFragment extends DialogFragment {
    private Calendar c;
    private endTimeChangedListener endTimeChangedListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        c = Calendar.getInstance();
        int HOUR = c.get(Calendar.HOUR_OF_DAY);
        int MINUTE = c.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(), timeSetListener, HOUR, MINUTE, DateFormat.is24HourFormat(getActivity()));
    }

    private TimePickerDialog.OnTimeSetListener timeSetListener
            = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int hour, int minute) {
            Calendar timePickerCalendar = Calendar.getInstance();
            timePickerCalendar.set(Calendar.HOUR_OF_DAY, hour);
            timePickerCalendar.set(Calendar.MINUTE, minute);

            CharSequence timeCharSequence = DateFormat.format("h:mm a", timePickerCalendar);
            String timeString = timeCharSequence.toString();
            endTimeChangedListener.changeEndTime(timeString);
        }
    };

    private void showTimePicker() {

        int HOUR = c.get(Calendar.HOUR_OF_DAY);
        int MINUTE = c.get(Calendar.MINUTE);
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
                        endTimeChangedListener.changeEndTime(timeString);
                    }
                }, HOUR, MINUTE, is24HourFormat);
        timePickerDialog.show();
    }

    public  interface endTimeChangedListener {
        void changeEndTime(String endTime);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            endTimeChangedListener = (endTimeChangedListener) context;
        } catch (Exception e) {
            throw  new ClassCastException(context.toString() + "must implement mTimeChangedListener");
        }
    }
}
