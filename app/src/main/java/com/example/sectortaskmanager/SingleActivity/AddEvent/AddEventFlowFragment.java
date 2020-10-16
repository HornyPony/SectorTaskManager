package com.example.sectortaskmanager.SingleActivity.AddEvent;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sectortaskmanager.R;


public class AddEventFlowFragment extends Fragment {
    private AddEventMainFragment addEventMainFragment;
    private AddEventFragment addEventFragment;


    public AddEventFlowFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addEventMainFragment = new AddEventMainFragment();
        addEventFragment = new AddEventFragment();
        getFragmentManager().beginTransaction()
                .replace(R.id.flowFragmentsContainer, addEventMainFragment)
                .commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        
        return inflater.inflate(R.layout.fragment_add_event_flow, container, false);
    }


}