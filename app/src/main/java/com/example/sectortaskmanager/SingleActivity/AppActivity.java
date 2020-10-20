package com.example.sectortaskmanager.SingleActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.example.sectortaskmanager.R;
import com.example.sectortaskmanager.SingleActivity.AddEvent.AddEventFlowFragment;

public class AppActivity extends AppCompatActivity {
    private AddEventFlowFragment addEventFlowFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        addEventFlowFragment = new AddEventFlowFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.flowFragmentsContainer, addEventFlowFragment)
                .commit();
    }
}