package com.example.sectortaskmanager;

import android.content.Intent;
import android.net.Uri;
import android.provider.CalendarContract;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class UserCalendar {
    public static Uri.Builder createCalendar(){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        long time = calendar.getTime().getTime();
        Uri.Builder builder =
                CalendarContract.CONTENT_URI.buildUpon();
        builder.appendPath("time");
        builder.appendPath(Long.toString(time));
        return builder;
    }

}