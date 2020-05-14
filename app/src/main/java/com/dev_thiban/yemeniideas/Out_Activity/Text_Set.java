package com.dev_thiban.yemeniideas.Out_Activity;

import android.text.format.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Text_Set {


    // التاريخ
    public static String Date_Now(String date) {

        GregorianCalendar time_post = new GregorianCalendar(
                Integer.parseInt(date.substring(0, 4)),
                Integer.parseInt(date.substring(5, 7)) - 1,
                Integer.parseInt(date.substring(8, 10)),
                Integer.parseInt(date.substring(11, 13)),
                Integer.parseInt(date.substring(14, 16)),
                Integer.parseInt(date.substring(17, 19)));

        GregorianCalendar time_now = new GregorianCalendar();
        String time = new SimpleDateFormat("Z", Locale.US).format(new Date());
        if (time.substring(0, 1).compareTo("+") == 0) {
            time_post.add(10, Integer.parseInt(time.substring(1, 3)));
            time_post.add(12, Integer.parseInt(time.substring(3, 5)));
        } else if (time.substring(0, 1).compareTo("-") == 0) {
            time_post.add(10, -Integer.parseInt(time.substring(1, 3)));
            time_post.add(12, -Integer.parseInt(time.substring(3, 5)));
        }
        String dif = DateUtils.getRelativeTimeSpanString(time_post.getTimeInMillis(),
                time_now.getTimeInMillis(), 1000).toString();
        if (dif.compareTo("أمس") == 0 || dif.compareTo("yesterday") == 0) {
            return dif + " الساعة " + time_post.get(11) + ":" + time_post.get(12);
        }
        if (dif.substring(dif.length() - 3, dif.length()).compareTo("يوم") == 0 ||
                dif.substring(dif.length() - 3, dif.length()).compareTo("day") == 0) {
            return dif + " الساعة " + time_post.get(11) + ":" + time_post.get(12);
        }
        return dif;
    }

}
