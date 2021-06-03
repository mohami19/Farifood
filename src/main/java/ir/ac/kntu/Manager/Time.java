package ir.ac.kntu.Manager;

import java.util.Objects;

public class Time {
    private int hour;

    private int minute;

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

    private void setTheTimeToTheRightOne(int hour, int minute){
        if (minute >=60) {
            hour+=minute%60;
        }
        this.minute = minute % 60;
        this.hour = hour % 24;
    }

    @Override
    public String toString() {
        return "The Time is : " + hour + " : " + minute;
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