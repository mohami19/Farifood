package ir.ac.kntu.Stuff;

import ir.ac.kntu.manager.ScannerWrapper;

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
        System.out.println("please enter the idea about the Item");
        String idea = ScannerWrapper.getInstance().nextLine();
        comments.add(idea);
        System.out.println("please enter the score for the Item");
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
        return "Item { " + super.toString()+
                "numbers of fruit = " + numbers +
               " }\n";
    }
}
