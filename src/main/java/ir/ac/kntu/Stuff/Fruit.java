package ir.ac.kntu.Stuff;

import ir.ac.kntu.Manager.ScannerWrapper;

import java.sql.Time;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

public class Fruit extends Stuff{
    private double quantity;

    private final ArrayList<String> comments;

    public Fruit() {
        comments = new ArrayList<>();
    }

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
            System.out.println("You Entered the Wrong Input and Random will be add\n" + e);
            System.out.println("Score is : " + star);
        }
        ScannerWrapper.getInstance().nextLine();
        setStar((star+getStar())/2);
    }

    public ArrayList<Fruit> addFruits() {
        ArrayList<Fruit> fruits = new ArrayList<>();
        System.out.println("Adding Fruit  : ");
        System.out.println("Do You Want To Add Fruit If so Enter Yes and If you don't want to add press Enter");
        String input = ScannerWrapper.getInstance().nextLine().trim();
        while(input.matches("[Yy]es|[Yy]")){
            System.out.println("Enter the name of the food");
            String name = ScannerWrapper.getInstance().nextLine();
            System.out.println("Enter the price");
            double price = ScannerWrapper.getInstance().nextDouble();
            ScannerWrapper.getInstance().nextLine();
            System.out.println("Enter the quantity");
            int quantity = ScannerWrapper.getInstance().nextInt();
            ScannerWrapper.getInstance().nextLine();
            Fruit fruit = new Fruit(name,price,5,quantity);
            System.out.println("The Fruit you have saved : " + fruit);
            fruits.add(fruit);
            System.out.println("Do You Want To Add More If so Enter Yes and If you don't want to add press Enter");
            input = ScannerWrapper.getInstance().nextLine().trim();
        }
        return fruits;
    }

    @Override
    public String toString() {
        return "Fruit { " + super.toString() +
                "quantity=" + quantity +
                ", Numbers of comments = " + comments.size() +
                " }\n";
    }
}
