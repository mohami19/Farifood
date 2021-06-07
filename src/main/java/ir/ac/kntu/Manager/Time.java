package ir.ac.kntu.Manager;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Random;

public class Time {
    private int hour;

    private int minute;

    public Time() {
    }

    public Time(int hour, int minute) {
        setTheTimeToTheRightOne(hour,minute);
    }

    public int getHour() {
        return hour%24;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute&60;
    }

    public Time addTime() {
        System.out.println("please Enter the time");
        System.out.println("Please Enter the hour :  ");
        int hour = new Random().nextInt(24);
        try {
            hour = ScannerWrapper.getInstance().nextInt();
        } catch (InputMismatchException e) {
            System.out.println("You Entered the Wrong Input and Random will be add\n" + e);
        }
        System.out.println("please Enter the minute :  ");
        int minute = new Random().nextInt(60);
        try {
            minute = ScannerWrapper.getInstance().nextInt();
            ScannerWrapper.getInstance().nextLine();
        } catch (InputMismatchException e) {
            System.out.println("You Entered the Wrong Input and Random will be add\n" + e);
        }
        Time time = new Time(hour,minute);
        time.setTheTimeToTheRightOne(hour,minute);
        return time;
    }

    private void setTheTimeToTheRightOne(int hour, int minute){
        if (minute >=60) {
            hour+=minute%60;
        }
        this.minute = minute % 60;
        this.hour = hour % 24;
    }

    @Override
    public String toString() {
        return "The Time is --> " + hour + " : " + minute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Time time = (Time) o;
        return hour == time.hour && minute == time.minute;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hour, minute);
    }
}