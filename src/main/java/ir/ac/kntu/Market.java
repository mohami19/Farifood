package ir.ac.kntu;

import ir.ac.kntu.Manager.Address;
import ir.ac.kntu.Manager.Time;

import java.util.ArrayList;

public class Market {
    private String name;

    private Address address;

    private Time beggingTime;

    private Time endingTime;

    private double star;

    private ArrayList<Stuff> stuffs;

    public Market(String name, Address address, Time beggingTime, Time endingTime, double star,
                  ArrayList<Stuff> stuffs) {
        this.name = name;
        this.address = address;
        this.beggingTime = beggingTime;
        this.endingTime = endingTime;
        this.star = starSetterToRight(star);
        this.stuffs = stuffs;
    }

    public double getStar() {
        return star;
    }

    public ArrayList<Stuff> getStuffs() {
        return stuffs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setBeggingTime(Time beggingTime) {
        this.beggingTime = beggingTime;
    }

    public void setEndingTime(Time endingTime) {
        this.endingTime = endingTime;
    }

    public void setStar(double star) {
        this.star = star;
    }

    public void setStuffs(ArrayList<Stuff> stuffs) {
        this.stuffs = stuffs;
    }

    private double starSetterToRight(double star) {
        if (star%5 == 0) {
            return 5;
        }
        return star%5;
    }

    public boolean isAvailable(Time time){
        if (time.getHour() > beggingTime.getHour() && time.getHour()<endingTime.getHour()) {
            return true;
        } else if (time.getHour()==beggingTime.getHour() || time.getHour()==endingTime.getHour()) {
            if (time.getMinute() >= beggingTime.getMinute() || time.getMinute() <= endingTime.getMinute()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Market {" +
                "name = " + name + '\'' +
                ", address = " + address +
                ", beggingTime = " + beggingTime +
                ", endingTime = " + endingTime +
                "\nstar = " + star +
                ",stuffs=" + stuffs +
                '}';
    }
}
