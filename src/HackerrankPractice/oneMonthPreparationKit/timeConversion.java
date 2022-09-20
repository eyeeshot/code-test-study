package HackerrankPractice.oneMonthPreparationKit;

import sun.java2d.pipe.SpanShapeRenderer;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class timeConversion {
    public static void main(String[] args) throws IOException, ParseException {
        String pmTime = "10:20:30PM";
        String amTime = "12:05:39AM";
        System.out.println(timeConversion(pmTime));
        System.out.println(timeConversion(amTime));
    }

    public static String timeConversion(String s) throws ParseException {
        SimpleDateFormat transFormat = new SimpleDateFormat("HH:mm:ss");
        Date dateTime = transFormat.parse(s.substring(0,s.length()-2));

        Calendar cal = Calendar.getInstance();
        cal.setTime(dateTime);

        // Write your code here
        if (s.contains("PM") && !s.substring(0,2).equals("12")) {
            cal.add(Calendar.HOUR_OF_DAY , 12);
        } else if (s.contains("AM") && s.substring(0,2).equals("12")) {
            cal.add(Calendar.HOUR_OF_DAY , 12);
        }

        return transFormat.format(new Date(cal.getTimeInMillis()));
    }
}
