package ir.ac.kntu;

import ir.ac.kntu.Manager.Address;
import ir.ac.kntu.Manager.PriceType;
import ir.ac.kntu.Manager.ScannerWrapper;
import ir.ac.kntu.Manager.Time;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Restaurant extends Market{

    private PriceType priceType;

    private ArrayList<String> comments;

    public Restaurant(String name, Address address, Time beggingTime, Time endingTime,
                      double star, ArrayList<Stuff> stuffs, PriceType priceType) {
        super(name, address, beggingTime, endingTime, star, stuffs);
        this.priceType = priceType;
        comments = new ArrayList<>();
    }

    public ArrayList<String> getComments() {
        return new ArrayList<>(comments);
    }

    public void setPriceType(PriceType priceType) {
        this.priceType = priceType;
    }

    public void addComment(){
        System.out.println("please enter the idea about the Restaurant");
        String comment = ScannerWrapper.getInstance().nextLine();
        comments.add(comment);
        System.out.println("please enter the score for the Restaurant");
        double star = 5;
        try {
            star = ScannerWrapper.getInstance().nextDouble();
            ScannerWrapper.getInstance().nextLine();
            star = starSetterToRight(star);
        } catch (InputMismatchException e) {
            System.out.println("You Entered the Wrong Input and Default will be add -- > Star = 5");
        }
        setStar((getStar()+ star)/2);
    }

    private double starSetterToRight(double star) {
        if (star%5 == 0) {
            return 5;
        }
        return star%5;
    }

    @Override
    public String toString() {
        return "Restaurant { " + super.toString() +
                ", priceType = " + priceType +
                ", commentsNum = " + comments.size() +
                " }";
    }
}