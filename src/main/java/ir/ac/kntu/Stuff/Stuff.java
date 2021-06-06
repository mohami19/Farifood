package ir.ac.kntu.Stuff;

import ir.ac.kntu.Manager.ScannerWrapper;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Random;

public class Stuff {
    private String name;

    private double price;

    private double star;

    private final ArrayList<String> comments;

    public Stuff(String name, double price, double star) {
        comments = new ArrayList<>();
        this.name = name;
        this.price = price;
        this.star = starSetterToRight(star);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getStar() {
        return star;
    }

    public void setStar(double star) {
        this.star = star;
    }

    public ArrayList<String> getComments() {
        return new ArrayList<>(comments);
    }

    private double starSetterToRight(double star) {
        if (star%5 == 0) {
            return 5;
        }
        return star%5;
    }

    public void addComments() {
        System.out.println("please enter the idea about the Stuff");
        String idea = ScannerWrapper.getInstance().nextLine();
        comments.add(idea);
        System.out.println("please enter the score for the Stuff");
        double star = new Random().nextDouble() % 5;
        try {
            star = ScannerWrapper.getInstance().nextDouble();
            star = starSetterToRight(star);
        } catch (InputMismatchException e) {
            System.out.println("You Entered the Wrong Input and Default will be add");
        }
        ScannerWrapper.getInstance().nextLine();
        this.star = ((this.star + star)/2);
    }

    @Override
    public String toString() {
        return "name = '" + name + '\'' + ", price ='" + price + '\'' +
                ", stars = " + star + ", Comments Number : " + comments.size() + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Stuff stuff = (Stuff) o;
        return Double.compare(stuff.price, price) == 0 && Objects.equals(name, stuff.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

}
