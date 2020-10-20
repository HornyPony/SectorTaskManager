package com.example.sectortaskmanager.SingleActivity.AddEvent.AddEventUtils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SharedPreferencesHelper {
    public static final String SHARED_PREF_NAME = "SHARED_PREF_NAME";
    public static final String DATE_KEY = "DATE_KEY";
    private SharedPreferences mSharedPreferences;

    public SharedPreferencesHelper(Context context) {
        mSharedPreferences = context.getSharedPreferences(
                SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }

    public static final Type DATE_TYPE = new TypeToken<List<Date>>() {}.getType();

    private Gson mGson = new Gson();


    public List<Date> getChosenDates() {
        List<Date> chosenDates = mGson.fromJson(mSharedPreferences.getString(DATE_KEY, ""), DATE_TYPE);
        return chosenDates == null ? new ArrayList<Date>() : chosenDates;
    }

    public boolean addUniqueCalendarDate(Date date) {
        List<Date> chosenDates = getChosenDates();
        for (Date d : chosenDates) {
            if (d.equals(date)) {
                return false;//если существует - просто не добавляем
            }
        }
        chosenDates.add(date);
        mSharedPreferences.edit().putString(DATE_KEY, mGson.toJson(chosenDates, DATE_TYPE)).apply();
        return true;
    }

}