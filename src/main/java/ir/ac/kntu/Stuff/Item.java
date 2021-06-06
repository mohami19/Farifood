package ir.ac.kntu.Stuff;

import ir.ac.kntu.Manager.ScannerWrapper;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

public class Item extends Stuff {
    private int numbers;

    private final ArrayList<String> comments;

    public Item(String name, double price, double star, int numbers) {
        super(name, price, star);
        this.numbers = numbers;
        comments = new ArrayList<>();
    }

    @Override
    public void addComments() {
        System.out.println("please enter the idea about the Food");
        String idea = ScannerWrapper.getInstance().nextLine();
        comments.add(idea);
        System.out.println("please enter the score for the Food");
        double star = new Random().nextDouble() % 5;
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
        return "Fruit { " +
                "numbers of fruit = " + numbers +
               " }";
    }
}
