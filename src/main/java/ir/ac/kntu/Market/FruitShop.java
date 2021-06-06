package ir.ac.kntu.Market;

import ir.ac.kntu.Manager.Address;
import ir.ac.kntu.Manager.ScannerWrapper;
import ir.ac.kntu.Manager.Time;
import ir.ac.kntu.Persons.FruitShopAdmin;
import ir.ac.kntu.Stuff.Stuff;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

public class FruitShop extends Market{
    private final ArrayList<String> comments;

    private FruitShopAdmin fruitShopAdmin;

    public FruitShop(String name, Address address, Time beggingTime,
                     Time endingTime, double star, ArrayList<Stuff> stuffs) {
        super(name, address, beggingTime, endingTime, star, stuffs);
        comments = new ArrayList<>();
    }

    public FruitShopAdmin getFruitShopAdmin() {
        return fruitShopAdmin;
    }

    public void setFruitShopAdmin(FruitShopAdmin fruitShopAdmin) {
        this.fruitShopAdmin = fruitShopAdmin;
    }

    public int workingTimeParts(Time start, Time end){
        ArrayList<Time> times = new ArrayList<>();
        while(start.getHour() < end.getHour()){
            Time tepTime = new Time(start.getHour(),start.getMinute());
            System.out.println(tepTime);
            times.add(tepTime);
            start.setHour(start.getHour()+2);
        }
        for (int i = 0; i < times.size(); i++) {
            System.out.println(times.get(i));
        }
        System.out.println("please chose the time of order");
        int choice = new Random().nextInt(times.size());
        try {
            choice = ScannerWrapper.getInstance().nextInt();
            ScannerWrapper.getInstance().nextLine();
        } catch (InputMismatchException e) {
            System.out.println("You Entered the Wrong Input and Default will be add" + e);
        }
        return choice - 1;
    }

    @Override
    public void addComment() {
        System.out.println("please enter the idea about the FruitShop");
        String comment = ScannerWrapper.getInstance().nextLine();
        comments.add(comment);
        System.out.println("please enter the score for the FruitShop");
        double star = new Random().nextInt(6);
        try {
            star = ScannerWrapper.getInstance().nextDouble();
            ScannerWrapper.getInstance().nextLine();
            star = starSetterToRight(star);
        } catch (InputMismatchException e) {
            System.out.println("You Entered the Wrong Input and Random will be add" + e);
            System.out.println("Score is : " + star);
        }
        setStar((getStar()+ star)/2);
    }

    public ArrayList<String> getComments() {
        return new ArrayList<>(comments);
    }

    @Override
    public String toString() {
        return super.toString() +
                " comments = " + comments.size() +
                '}';
    }
}
