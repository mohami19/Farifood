package ir.ac.kntu.Delivery;

import ir.ac.kntu.Manager.ScannerWrapper;
import ir.ac.kntu.Stuff.Food;
import ir.ac.kntu.Manager.Time;
import ir.ac.kntu.Restaurant;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Delivery {
    private DeliveryType deliveryType;

    private double price;

    private DeliveryPriceType deliveryPriceType;

    private ArrayList<AvailableDay> availableDay;

    private ArrayList<Restaurant> restaurants;

    private ArrayList<String> comments;

    private ArrayList<Food> foods;

    private double star;

    private Time beggingTime;

    private Time endingTime;

    public Delivery(DeliveryType deliveryType, double price, DeliveryPriceType deliveryPriceType,
                    ArrayList<AvailableDay> availableDay, double star, Time beggingTime, Time endingTime) {
        this.deliveryType = deliveryType;
        this.price = price;
        this.deliveryPriceType = deliveryPriceType;
        this.availableDay = availableDay;
        this.star = starSetterToRight(star);
        this.beggingTime = beggingTime;
        this.endingTime = endingTime;
        restaurants = new ArrayList<>();
        comments = new ArrayList<>();
        foods = new ArrayList<>();
    }

    public void setDeliveryPriceType(DeliveryPriceType deliveryPriceType) {
        this.deliveryPriceType = deliveryPriceType;
    }

    public void addIdea(String idea) {
        comments.add(idea);
    }

    public boolean addRestaurant(Restaurant restaurant) {
        if (restaurants.size() > 2 ) {
            System.out.println("This Delivery Can't Support Anymore Restaurant");
            return false;
        }
        restaurants.add(restaurant);
        return true;
    }

    public boolean deliveryIsAvailable(Time time){
        if (time.getHour() > beggingTime.getHour() && time.getHour() < endingTime.getHour()) {
            return true;
        } else if(time.getHour()==beggingTime.getHour() && time.getMinute() > time.getMinute()){
            return true;
        } else if (time.getHour() == endingTime.getHour() && time.getMinute() < endingTime.getMinute()) {
            return true;
        }
        return false;
    }

    public void addComments() {
        System.out.println("please enter the idea about the Stuff");
        String idea = ScannerWrapper.getInstance().nextLine();
        comments.add(idea);
        System.out.println("please enter the score for the Stuff");
        double star = 4;
        try {
            star = ScannerWrapper.getInstance().nextDouble();
            star = starSetterToRight(star);
        } catch (InputMismatchException e) {
            System.out.println("You Entered the Wrong Input and Default will be add" + e);
        }
        ScannerWrapper.getInstance().nextLine();
        this.star = (this.star+starSetterToRight(star))/2;
    }

    private double starSetterToRight(double star) {
        if (star%5 == 0) {
            return 5;
        }
        return star%5;
    }

    public void addToHistoryOfOrders(Food food){
        foods.add(food);
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "deliveryType=" + deliveryType +
                ", price=" + price +
                ", deliveryPriceType=" + deliveryPriceType +
                ", availableDay=" + availableDay +
                ", star=" + star +
                "\nbeggingTime=" + beggingTime +
                ", endingTime=" + endingTime +
                ", Comments Number : " + comments.size() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Delivery delivery = (Delivery) o;
        return deliveryType == delivery.deliveryType && deliveryPriceType == delivery.deliveryPriceType
                && Objects.equals(availableDay, delivery.availableDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deliveryType, deliveryPriceType, availableDay);
    }
}