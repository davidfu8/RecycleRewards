package com.example.recyclerewards;

import java.util.*;
import android.widget.*;
import android.media.*;
import android.view.*;
import android.os.*;
import android.app.*;
import android.content.*;

public class PersonalRecycles {
    String username;
    String email;
    private int totalRecycles;
    private int[] weekRecycles = new int[7];
    private ArrayList<int[]> weeklyRecycles;
    private GregorianCalendar currentTime;

    PersonalRecycles(String username, String email) {
        this.username = username;
        this.email = email;
        totalRecycles = 0;
        currentTime = new GregorianCalendar();
    }

    public String getUsername() { return username; }

    public String getEmail() { return email; }

    public int getTotalRecycles() {
        return totalRecycles;
    }

    public int[] getWeekRecycles() {
        return weekRecycles;
    }

    public int getTotalWeekRecycles() {
        int recycleCount = 0;
        for (int day : weekRecycles) {
            recycleCount += day;
        }
        return recycleCount;
    }

    public int getDailyRecycles() { return weekRecycles[currentTime.DAY_OF_WEEK - 1]; }

    public ArrayList<int[]> getWeeklyRecycles() {
        return weeklyRecycles;
    }

    public void addRecycles() {
        totalRecycles++;
        weekRecycles[currentTime.DAY_OF_WEEK - 1]++;
    }
}
