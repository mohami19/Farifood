package ir.ac.kntu.Market;

import ir.ac.kntu.Manager.Address;
import ir.ac.kntu.Manager.ScannerWrapper;
import ir.ac.kntu.Manager.Time;
import ir.ac.kntu.Persons.SuperMarketAdmin;
import ir.ac.kntu.Stuff.Item;
import ir.ac.kntu.Stuff.Stuff;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

public class SuperMarket extends Market{
    private ArrayList<Item> items;
    private final ArrayList<String> comments = new ArrayList<>();

    private SuperMarketAdmin superMarketAdmin;

    public SuperMarket(String name, Address address, Time beggingTime, Time endingTime,
                       double star, ArrayList<Item> items) {
        super(name, address, beggingTime, endingTime, star);
        this.items = items;
    }

    public ArrayList<String> getComments() {
        return new ArrayList<>(comments);
    }

    public SuperMarketAdmin getSuperMarketAdmin() {
        return superMarketAdmin;
    }

    public void setSuperMarketAdmin(SuperMarketAdmin superMarketAdmin) {
        this.superMarketAdmin = superMarketAdmin;
    }

    @Override
    public void addComment() {
        System.out.println("please enter the idea about the SuperMarket");
        String comment = ScannerWrapper.getInstance().nextLine();
        comments.add(comment);
        System.out.println("please enter the score for the SuperMarket");
        double star = new Random().nextInt(6);
        try {
            star = ScannerWrapper.getInstance().nextDouble();
            ScannerWrapper.getInstance().nextLine();
            star = starSetterToRight(star);
        } catch (InputMismatchException e) {
            System.out.println("You Entered the Wrong Input and Random will be add\n" + e);
            System.out.println("Score is : " + star);
        }
        setStar((getStar()+ star)/2);
    }

    public int workingTimeParts(Time start, Time end){
        ArrayList<Time> times = new ArrayList<>();
        while(start.getHour() < end.getHour()){
            Time tepTime = new Time(start.getHour(),start.getMinute());
            System.out.println(tepTime);
            times.add(tepTime);
            start.setHour(start.getHour()+1);
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
            System.out.println("You Entered the Wrong Input and Random will be add" + e);
        }
        return choice - 1;
    }

    @Override
    public String toString() {
        return  super.toString() +
                " comments = " + comments.size() +
                '}';
    }
}
