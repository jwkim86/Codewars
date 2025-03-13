package com.codewars.fivekyu.humanreadabletime;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HumanReadableTime {
    public static String makeReadable(int seconds) {
        int s = seconds%60;
        int m = seconds/60%60;
        int h = seconds/3600;
        if(h > 99) h = 99;
        return String.format("%02d:%02d:%02d", h, m, s);
    }
}
