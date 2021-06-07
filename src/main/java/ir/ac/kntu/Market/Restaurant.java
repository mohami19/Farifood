package ir.ac.kntu.Market;

import ir.ac.kntu.Manager.Address;
import ir.ac.kntu.Manager.PriceType;
import ir.ac.kntu.Manager.ScannerWrapper;
import ir.ac.kntu.Manager.Time;
import ir.ac.kntu.Persons.RestaurantAdmin;
import ir.ac.kntu.Stuff.Food;
import ir.ac.kntu.Stuff.Stuff;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

public class Restaurant extends Market{

    private ArrayList<Food> foods;

    private PriceType priceType;

    private final ArrayList<String> comments;

    private RestaurantAdmin restaurantAdmin;

    public Restaurant(String name, Address address, Time beggingTime, Time endingTime,
                      double star, ArrayList<Food> foods, PriceType priceType) {
        super(name, address, beggingTime, endingTime, star);
        this.foods = foods;
        this.priceType = priceType;
        comments = new ArrayList<>();
    }

    public ArrayList<Food> getFoods() {
        return new ArrayList<>(foods);
    }

    public PriceType getPriceType() {
        return priceType;
    }

    public RestaurantAdmin getRestaurantAdmin() {
        return restaurantAdmin;
    }

    public void setRestaurantAdmin(RestaurantAdmin restaurantAdmin) {
        this.restaurantAdmin = restaurantAdmin;
    }

    public ArrayList<String> getComments() {
        return new ArrayList<>(comments);
    }

    public void setPriceType(PriceType priceType) {
        this.priceType = priceType;
    }

    @Override
    public void addComment() {
        System.out.println("please enter the idea about the Restaurant");
        String comment = ScannerWrapper.getInstance().nextLine();
        comments.add(comment);
        System.out.println("please enter the score for the Restaurant");
        double star = new Random().nextInt(6);
        try {
            star = ScannerWrapper.getInstance().nextDouble();
            ScannerWrapper.getInstance().nextLine();
            star = starSetterToRight(star);
        } catch (InputMismatchException e) {
            System.out.println("You Entered the Wrong Input and Random will be add\n" + e);
            System.out.println("Score is : " + star);
        }
        setStar((getStar()+ star)/2);
    }

    @Override
    public String toString() {
        return  super.toString() +
                "priceType = " + priceType +
                ", comments = " + comments +
                '}';
    }
}