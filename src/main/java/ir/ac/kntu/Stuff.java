package ir.ac.kntu;

import ir.ac.kntu.Manager.ScannerWrapper;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;

public class Stuff {
    private String name;

    private double price;

    private double star;

    private ArrayList<String> comments;

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

    public ArrayList<String> getComments() {
        return new ArrayList<>(comments);
    }

    private double starSetterToRight(double star) {
        if (star%5 == 0) {
            return 5;
        }
        return star%5;
    }

    public void addIdea() {
        System.out.println("please enter the idea about the Stuff");
        String idea = ScannerWrapper.getInstance().nextLine();
        comments.add(idea);
        System.out.println("please enter the score for the Stuff");
        double star = 4;
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
        return "Food { " +
                "name= '" + name + '\'' + ", price ='" + price + '\'' +
                ", stars = " + star + ", Comments Number : " + comments.size() +" }\n";
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
