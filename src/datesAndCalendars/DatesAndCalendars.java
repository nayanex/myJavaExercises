package datesAndCalendars;

import java.util.Calendar;
import java.util.Date;

public class DatesAndCalendars {
    public static void main(String[] args){
        displayCurrentDate();
        displaySetDate();

    }
    private static void displayCurrentDate(){
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        Date date = new Date();
        calendar.setTime(date);
        System.out.println(calendar.getTime());

    }

    private static void displaySetDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2031, 00, 02);
        Date date = calendar.getTime();
        System.out.println(date);
    }
}

//    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); to change the format of dates