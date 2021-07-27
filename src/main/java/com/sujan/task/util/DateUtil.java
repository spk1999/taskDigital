package com.sujan.task.util;


import java.sql.Timestamp;
import java.util.Date;

public class DateUtil {

    public static Timestamp getTimestamp() {
        Date date = new Date();
        //getTime() returns current time in milliseconds
        long time = date.getTime();
        Timestamp timestamp = new Timestamp(time);

        return timestamp;
    }
}
