package ir.ac.kntu.Stuff;

import ir.ac.kntu.Manager.ScannerWrapper;
import ir.ac.kntu.Manager.Time;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

public class Food extends Stuff{
    private Time backingTime;

    private final ArrayList<String> comments;

    public Food(String name, double price, double star, Time backingTime) {
        super(name, price, star);
        comments = new ArrayList<>();
        this.backingTime = backingTime;
    }

    @Override
    public ArrayList<String> getComments() {
        return new ArrayList<>(comments);
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
        ScannerWrapper.getInstance().nextLine();
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
