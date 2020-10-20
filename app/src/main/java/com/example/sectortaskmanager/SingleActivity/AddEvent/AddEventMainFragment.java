package com.example.sectortaskmanager.SingleActivity.AddEvent;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sectortaskmanager.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class AddEventMainFragment extends Fragment {
    private FloatingActionButton button;
    private AddEventFragment addEventFragment;

    public AddEventMainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addEventFragment = new AddEventFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add_event_main, container, false);
        button = view.findViewById(R.id.addEventMainFAB);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addEventFragment = new AddEventFragment();
                getFragmentManager().beginTransaction()
                        .replace(R.id.addEventContainer, addEventFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }


}