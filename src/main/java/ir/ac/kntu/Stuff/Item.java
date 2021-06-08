package ir.ac.kntu.Stuff;

import ir.ac.kntu.manager.ScannerWrapper;
import ir.ac.kntu.manager.Time;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

public class Item extends Stuff {
    private int numbers;

    private final ArrayList<String> comments = new ArrayList<>();

    public Item() {
    }

    public Item(String name, double price, double star, int numbers) {
        super(name, price, star);
        this.numbers = numbers;
    }

    public int getNumbers() {
        return numbers;
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

    public Item addItem(){
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
        System.out.println("please Enter the Numbers of Item");
        int numbers = new Random().nextInt(60);
        try {
            numbers = ScannerWrapper.getInstance().nextInt();
            ScannerWrapper.getInstance().nextLine();
        } catch (InputMismatchException e) {
            System.out.println("You Entered the Wrong Input and Random will be add\n" + e);
            System.out.println("Price is : " + numbers);
        }
        return new Item(name,price,5,numbers);
    }

    @Override
    public String toString() {
        return "Item { " + super.toString()+
                "numbers of fruit = " + numbers +
               " }\n";
    }
}
