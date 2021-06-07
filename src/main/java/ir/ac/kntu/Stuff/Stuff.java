package ir.ac.kntu.Stuff;

import ir.ac.kntu.Manager.ScannerWrapper;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Random;

public abstract class Stuff {
    private String name;

    private double price;

    private double star;

    private final ArrayList<String> comments;

    public Stuff() {
        comments = new ArrayList<>();
    }

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

    protected double starSetterToRight(double star) {
        if (star%5 == 0) {
            return 5;
        }
        return star%5;
    }

    abstract void addComments();

    @Override
    public String toString() {
        return "name = '" + name + '\'' + ", price ='" + price + '\'' +
                ", stars = " + star + ", Comments Number : " + comments.size() + " ";
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
