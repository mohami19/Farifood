package ir.ac.kntu.Stuff;

import ir.ac.kntu.Manager.ScannerWrapper;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

public class Fruit extends Stuff{
    private double quantity;

    private final ArrayList<String> comments = new ArrayList<>();

    public Fruit() {
    }

    public Fruit(String name, double price, double star, double quantity) {
        super(name, price, star);
        this.quantity = quantity;
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
        setStar((star+getStar())/2);
    }

    public Fruit addFruit(){
        System.out.println("Enter the name of the food");
        String name = ScannerWrapper.getInstance().nextLine();
        System.out.println("Enter the price");
        double price = new Random().nextInt(30);
        try {
            price = ScannerWrapper.getInstance().nextInt()-1;
            ScannerWrapper.getInstance().nextLine();
        } catch (InputMismatchException e) {
            System.out.println("You Entered the Wrong Input and Random will be add\n" + e);
            System.out.println("Price is :" + price);
        }
        System.out.println("Enter the quantity");
        int quantity = new Random().nextInt() % 50;
        try {
            quantity = ScannerWrapper.getInstance().nextInt()-1;
            ScannerWrapper.getInstance().nextLine();
        } catch (InputMismatchException e) {
            System.out.println("You Entered the Wrong Input and Random will be add\n" + e);
            System.out.println("the quantity is" + quantity);
        }
        return new Fruit(name,price,5,quantity);
    }

    @Override
    public String toString() {
        return "Fruit { " + super.toString() +
                "quantity=" + quantity +
                ", Numbers of comments = " + comments.size() +
                " }\n";
    }
}
