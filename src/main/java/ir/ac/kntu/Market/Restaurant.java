package ir.ac.kntu.Market;

import ir.ac.kntu.Manager.Address;
import ir.ac.kntu.Manager.PriceType;
import ir.ac.kntu.Manager.ScannerWrapper;
import ir.ac.kntu.Manager.Time;
import ir.ac.kntu.Persons.RestaurantAdmin;
import ir.ac.kntu.Stuff.Food;
import ir.ac.kntu.Stuff.Fruit;
import ir.ac.kntu.Stuff.Stuff;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

public class Restaurant extends Market{

    private ArrayList<Food> foods;

    private PriceType priceType;

    private final ArrayList<String> comments = new ArrayList<>();

    private RestaurantAdmin restaurantAdmin;

    public Restaurant() {
    }

    public Restaurant(String name, Address address, Time beggingTime, Time endingTime,
                      double star, ArrayList<Food> foods, PriceType priceType) {
        super(name, address, beggingTime, endingTime, star);
        this.foods = foods;
        this.priceType = priceType;
    }


    public ArrayList<Food> getFoods() {
        return new ArrayList<>(foods);
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public ArrayList<String> getComments() {
        return new ArrayList<>(comments);
    }

    public void setPriceType(PriceType priceType) {
        this.priceType = priceType;
    }

    public Restaurant addRestaurant(){
        System.out.println("please Enter the new Restaurant");
        System.out.println("Please Enter the name : ");
        String name = ScannerWrapper.getInstance().nextLine();
        Address address = new Address().addAddress();
        System.out.println("Starting Time -->");
        Time start = new Time().addTime();
        System.out.println("Ending Time -->");
        Time end = new Time().addTime();
        ArrayList<Food> foods = addFoods();
        PriceType priceType = addPriceType();
        return new Restaurant(name,address,start,end,5,foods,priceType);
    }

    public ArrayList<Food> addFoods(){
        ArrayList<Food> foods = new ArrayList<>();
        System.out.println("Adding food  : ");
        System.out.println("Do You Want To Add Food If so Enter Yes and If you don't want to add press Enter");
        String input = ScannerWrapper.getInstance().nextLine().trim();
        while(input.matches("[Yy]es|[Yy]")){
            Food food = new Food().addFood();
            System.out.println("The food you have saved : " + food);
            foods.add(food);
            System.out.println("Do You Want To Add More If so Enter Yes and If you don't want to add press Enter");
            input = ScannerWrapper.getInstance().nextLine().trim();
        }
        return foods;
    }

    private PriceType addPriceType() {
        System.out.println("please Enter the priceType you want");
        PriceType[] priceTypes= PriceType.values();
        for (int i = 0; i < priceTypes.length; i++) {
            System.out.println(i + 1 + " : " + priceTypes[i]);
        }
        int choice = new Random().nextInt(3);
        ScannerWrapper.getInstance().nextLine();
        try {
            choice = ScannerWrapper.getInstance().nextInt()-1;
            ScannerWrapper.getInstance().nextLine();
        } catch (InputMismatchException e) {
            System.out.println("You Entered the Wrong Input and Random will be add\n" + e);
        }
        return priceTypes[choice];
    }

    @Override
    public void addComment() {
        System.out.println("please enter the idea about the Restaurant");
        String comment = ScannerWrapper.getInstance().nextLine();
        comments.add(comment);
        System.out.println("please enter the score for the Restaurant");
        double star = new Random().nextInt(6);
        ScannerWrapper.getInstance().nextLine();
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