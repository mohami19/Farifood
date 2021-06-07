package ir.ac.kntu.market;

import ir.ac.kntu.manager.Address;
import ir.ac.kntu.manager.Time;

public abstract class Market {
    private String name;

    private Address address;

    private Time beggingTime;

    private Time endingTime;

    private double star;

    public Market() {
    }

    public Market(String name, Address address, Time beggingTime, Time endingTime, double star) {
        this.name = name;
        this.address = address;
        this.beggingTime = beggingTime;
        this.endingTime = endingTime;
        this.star = starSetterToRight(star);
    }

    public double getStar() {
        return star;
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

    abstract void addComment();

    protected double starSetterToRight(double star) {
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
        return getClass().getSimpleName() +
                " {" +
                "name = " + name + '\'' +
                ", address = " + address +
                ", beggingTime = " + beggingTime +
                ", endingTime = " + endingTime +
                "\nstar = " + star +
                '}';
    }
}
