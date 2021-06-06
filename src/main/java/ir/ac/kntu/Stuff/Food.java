package ir.ac.kntu.Stuff;

import ir.ac.kntu.Manager.ScannerWrapper;
import ir.ac.kntu.Manager.Time;

import java.util.ArrayList;
import java.util.InputMismatchException;

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
        double star = 4;
        try {
            star = ScannerWrapper.getInstance().nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("You Entered the Wrong Input and Default will be add");
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
