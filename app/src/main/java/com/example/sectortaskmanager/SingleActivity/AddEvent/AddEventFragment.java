package com.example.sectortaskmanager.SingleActivity.AddEvent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sectortaskmanager.R;

import java.util.Calendar;


public class AddEventFragment extends Fragment {
    private TextView startDateTextView, startTimeTextView, endTimeTextView, endDateTextView;
    private Calendar calendar;
    private static final int REQUEST_END_DATE = 1;
    private static final int REQUEST_START_DATE = 2;

    public AddEventFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_add_event, container, false);
        ConstraintLayout ringtoneLayout = view.findViewById(R.id.ringtoneLayout);
        ConstraintLayout startTimeLayout = view.findViewById(R.id.startTimeLayout);
        ConstraintLayout endTimeLayout = view.findViewById(R.id.endTimeLayout);
        startDateTextView = view.findViewById(R.id.startDateTextView);
        endDateTextView = view.findViewById(R.id.endDateTextView);
        startTimeTextView = view.findViewById(R.id.startTimeTextView);
        endTimeTextView = view.findViewById(R.id.endTimeTextView);
        calendar = Calendar.getInstance();
        setInitialDate();
        setInitialTime();
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.ringtoneLayout:
                        chooseNotificationBehaviour();
                        break;
                    case R.id.startTimeLayout:
                        showStartDatePicker();
                        break;
                    case R.id.endTimeLayout:
                        showEndDatePicker();
                        break;
                }
            }
        };

        ringtoneLayout.setOnClickListener(onClickListener);
        startTimeLayout.setOnClickListener(onClickListener);
        endTimeLayout.setOnClickListener(onClickListener);

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        String time;
        String date;
        if (requestCode == REQUEST_END_DATE && resultCode == Activity.RESULT_OK) {
            // get date from string
            date = data.getStringExtra("endDate");
            time = data.getStringExtra("endTime");
            // set the value of the editText
            endDateTextView.setText(date);
            endTimeTextView.setText(time);
        }  else if (requestCode == REQUEST_START_DATE && resultCode == Activity.RESULT_OK) {
            // get date from string
            date = data.getStringExtra("startDate");
            time = data.getStringExtra("startTime");
            // set the value of the editText
            startDateTextView.setText(date);
            startTimeTextView.setText(time);
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void showEndDatePicker() {
        final FragmentManager fm = getActivity().getSupportFragmentManager();
        DialogFragment datePickerFragment = new MyDatePickerFragment();
        datePickerFragment.setTargetFragment(this, REQUEST_END_DATE);
        datePickerFragment.show(fm, "end date picker");
    }

    private void showStartDatePicker() {
        final FragmentManager fm = getActivity().getSupportFragmentManager();
        DialogFragment datePickerFragment = new MyDatePickerFragment();
        datePickerFragment.setTargetFragment(this, REQUEST_START_DATE);
        datePickerFragment.show(fm, "start date picker");
    }


    private void setInitialDate() {
        CharSequence dateCharSequence = DateFormat.format("EEE, dd MMM yyyy", calendar);
        String dateString = dateCharSequence.toString();
        startDateTextView.setText(dateString);
        endDateTextView.setText(dateString);
    }

    private void setInitialTime() {
        CharSequence timeCharSequence = DateFormat.format("h:mm a", calendar);
        String timeString = timeCharSequence.toString();
        startTimeTextView.setText(timeString);
        endTimeTextView.setText(timeString);
    }

    private void chooseNotificationBehaviour() {
        ChooseNotificationBehaviourFragment chooseNotificationBehaviourFragment = new ChooseNotificationBehaviourFragment();
        getFragmentManager().beginTransaction()
                .replace(R.id.addEventContainer, chooseNotificationBehaviourFragment)
                .addToBackStack(null)
                .commit();
    }


}
