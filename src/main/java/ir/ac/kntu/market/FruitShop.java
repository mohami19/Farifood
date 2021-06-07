package ir.ac.kntu.market;

import ir.ac.kntu.manager.Address;
import ir.ac.kntu.manager.ScannerWrapper;
import ir.ac.kntu.manager.Time;
import ir.ac.kntu.persons.FruitShopAdmin;
import ir.ac.kntu.Stuff.Fruit;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

public class FruitShop extends Market{
    private ArrayList<Fruit> fruits;
    private final ArrayList<String> comments;

    private FruitShopAdmin fruitShopAdmin;

    public FruitShop(String name, Address address, Time beggingTime,
                     Time endingTime, double star,ArrayList<Fruit> fruits) {
        super(name, address, beggingTime, endingTime, star);
        this.fruits = fruits;
        comments = new ArrayList<>();
    }

    public ArrayList<Fruit> getFruits() {
        return new ArrayList<>(fruits);
    }

    public FruitShopAdmin getFruitShopAdmin() {
        return fruitShopAdmin;
    }

    public void setFruitShopAdmin(FruitShopAdmin fruitShopAdmin) {
        this.fruitShopAdmin = fruitShopAdmin;
    }

    public int workingTimeParts(Time start, Time end){
        ArrayList<Time> times = new ArrayList<>();
        while(start.getHour() < end.getHour()){
            Time tepTime = new Time(start.getHour(),start.getMinute());
            System.out.println(tepTime);
            times.add(tepTime);
            start.setHour(start.getHour()+2);
        }
        for (int i = 0; i < times.size(); i++) {
            System.out.println(times.get(i));
        }
        System.out.println("please chose the time of order");
        int choice = new Random().nextInt(times.size());
        ScannerWrapper.getInstance().nextLine();
        try {
            choice = ScannerWrapper.getInstance().nextInt();
            ScannerWrapper.getInstance().nextLine();
        } catch (InputMismatchException e) {
            System.out.println("You Entered the Wrong Input and Random will be add\n" + e);
        }
        return choice - 1;
    }

    public FruitShop addFruitShop(){
        System.out.println("please Enter the new Fruit Shop");
        System.out.println("Please Enter the name : ");
        String name = ScannerWrapper.getInstance().nextLine();
        Address address = new Address().addAddress();
        Time start = new Time().addTime();
        Time end = new Time().addTime();
        ArrayList<Fruit> fruits = addFruits();
        return new FruitShop(name,address,start,end,5,fruits);
    }

    private ArrayList<Fruit> addFruits() {
        ArrayList<Fruit> fruits = new ArrayList<>();
        System.out.println("Adding Fruit  : ");
        System.out.println("Do You Want To Add Fruit If so Enter Yes and If you don't want to add press Enter");
        String input = ScannerWrapper.getInstance().nextLine().trim();
        while(input.matches("[Yy]es|[Yy]")){
            Fruit fruit = new Fruit().addFruit();
            fruits.add(fruit);
            System.out.println("The Fruit you have saved : " + fruit);
            System.out.println("Do You Want To Add More If so Enter Yes and If you don't want to add press Enter");
            input = ScannerWrapper.getInstance().nextLine().trim();
        }
        return fruits;
    }

    @Override
    public void addComment() {
        System.out.println("please enter the idea about the FruitShop");
        String comment = ScannerWrapper.getInstance().nextLine();
        comments.add(comment);
        System.out.println("please enter the score for the FruitShop");
        double star = new Random().nextInt(6);
        ScannerWrapper.getInstance().nextLine();
        try {
            star = ScannerWrapper.getInstance().nextDouble();
            ScannerWrapper.getInstance().nextLine();
            star = starSetterToRight(star);
        } catch (InputMismatchException e) {
            System.out.println("You Entered the Wrong Input and Random will be add" + e);
            System.out.println("Score is : " + star);
        }
        setStar((getStar()+ star)/2);
    }

    public ArrayList<String> getComments() {
        return new ArrayList<>(comments);
    }

    @Override
    public String toString() {
        return super.toString() +
                " Number of comments = " + comments.size()+
                " Fruits = " +
                " }";
    }
}