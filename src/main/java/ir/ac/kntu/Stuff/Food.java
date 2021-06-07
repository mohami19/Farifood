package ir.ac.kntu.Stuff;

import ir.ac.kntu.Manager.ScannerWrapper;
import ir.ac.kntu.Manager.Time;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

public class Food extends Stuff{
    private Time backingTime;

    private final ArrayList<String> comments = new ArrayList<>();

    public Food(String name, double price, double star, Time backingTime) {
        super(name, price, star);
        this.backingTime = backingTime;
    }

    public Food() {
    }

    @Override
    public ArrayList<String> getComments() {
        return new ArrayList<>(comments);
    }

    public Food addFood(){
        System.out.println("Enter the name of the food");
        String name = ScannerWrapper.getInstance().nextLine();
        System.out.println("Enter the price");
        double price = new Random().nextInt(25);
        try {
            price = ScannerWrapper.getInstance().nextDouble();
            ScannerWrapper.getInstance().nextLine();
        } catch (InputMismatchException e) {
            System.out.println("You Entered the Wrong Input and Random will be add\n" + e);
            System.out.println("Price is : " + price);
        }
        System.out.println("please Enter the cocking time");
        return new Food(name,price,5,new Time().addTime());
    }

    @Override
    public void addComments() {
        System.out.println("please enter the idea about the Food");
        String idea = ScannerWrapper.getInstance().nextLine();
        comments.add(idea);
        System.out.println("please enter the score for the Food");
        double star = new Random().nextInt(6);
        try {
            star = ScannerWrapper.getInstance().nextDouble();
            ScannerWrapper.getInstance().nextLine();
            star = starSetterToRight(star);
        } catch (InputMismatchException e) {
            System.out.println("You Entered the Wrong Input and Random will be add\n" + e);
            System.out.println("Score is : " + star);
        }
        setStar((star+getStar())/2);
    }

    @Override
    public String toString() {
        return "Food {" +
                super.toString()+
                ", backingTime=" + backingTime +
                " }\n";
    }
}
