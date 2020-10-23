package com.example.sectortaskmanager.SingleActivity.AddEvent.AddEventUtils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.format.DateFormat;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SharedPreferencesHelper {
    public static final String SHARED_PREF_NAME = "SHARED_PREF_NAME";
    public static final String END_DATE_KEY = "END_DATE_KEY";
    public static final String START_DATE_KEY = "START_DATE_KEY";
    private SharedPreferences mSharedPreferences;
    private Date chosenStartDate, chosenEndDate;
    Calendar calendar;

    public SharedPreferencesHelper(Context context) {
        mSharedPreferences = context.getSharedPreferences(
                SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }

    private Gson mGson = new Gson();

    public void addStartCalendarDate(Date startDate) {
        mSharedPreferences.edit().putString(START_DATE_KEY, mGson.toJson(startDate, Date.class)).apply();
    }

    public void addEndCalendarDate(Date endDate) {
        mSharedPreferences.edit().putString(END_DATE_KEY, mGson.toJson(endDate, Date.class)).apply();
    }

    public boolean compareStartAndEndDates() {
        String startDateFromSP = mSharedPreferences.getString(START_DATE_KEY, "");
        String endDateFromSP = mSharedPreferences.getString(END_DATE_KEY, "");


        chosenStartDate = mGson.fromJson(startDateFromSP, Date.class);
        chosenEndDate = mGson.fromJson(endDateFromSP, Date.class);

        if (chosenEndDate.getTime() < chosenStartDate.getTime()) {
            return false;
        } else { return true; }
    }

    public  void deleteDatesSharedPreferences() {
        mSharedPreferences.edit().remove(START_DATE_KEY).commit();
        mSharedPreferences.edit().remove(END_DATE_KEY).commit();
    }

    }
