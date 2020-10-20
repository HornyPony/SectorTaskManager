package com.example.sectortaskmanager.SingleActivity.AddEvent;


import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sectortaskmanager.R;


public class AddEventFlowFragment extends Fragment {
    private AddEventMainFragment addEventMainFragment;


    public AddEventFlowFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addEventMainFragment = new AddEventMainFragment();
        getFragmentManager().beginTransaction()
                .replace(R.id.addEventContainer, addEventMainFragment)
                .commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        
        return inflater.inflate(R.layout.fragment_add_event_flow, container, false);
    }


}