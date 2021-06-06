package ir.ac.kntu.Stuff;

import ir.ac.kntu.Manager.ScannerWrapper;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

public class Fruit extends Stuff{
    private double quantity;

    private final ArrayList<String> comments;

    public Fruit(String name, double price, double star, double quantity) {
        super(name, price, star);
        this.quantity = quantity;
        comments = new ArrayList<>();
    }

    @Override
    void addComments() {
        System.out.println("please enter the idea about the Fruit");
        String idea = ScannerWrapper.getInstance().nextLine();
        comments.add(idea);
        System.out.println("please enter the score for the Fruit");
        double star = new Random().nextInt(6);
        try {
            star = ScannerWrapper.getInstance().nextDouble();
            ScannerWrapper.getInstance().nextLine();
            star = starSetterToRight(star);
        } catch (InputMismatchException e) {
            System.out.println("You Entered the Wrong Input and Random will be add" + e);
            System.out.println("Score is : " + star);
        }
        ScannerWrapper.getInstance().nextLine();
        setStar((star+getStar())/2);
    }

    @Override
    public String toString() {
        return "Fruit { " + super.toString() +
                "quantity=" + quantity +
                ", Numbers of comments = " + comments.size() +
                " }\n";
    }
}
