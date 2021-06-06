package ir.ac.kntu;

import ir.ac.kntu.Manager.Address;
import ir.ac.kntu.Manager.ScannerWrapper;
import ir.ac.kntu.Manager.Time;
import ir.ac.kntu.Stuff.Item;
import ir.ac.kntu.Stuff.Stuff;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class SuperMarket extends Market{
    private final ArrayList<String> comments;

    public SuperMarket(String name, Address address, Time beggingTime,
                       Time endingTime, double star, ArrayList<Stuff> stuffs) {
        super(name, address, beggingTime, endingTime, star, stuffs);
        comments = new ArrayList<>();
    }

    @Override
    public void addComment() {
        System.out.println("please enter the idea about the SuperMarket");
        String comment = ScannerWrapper.getInstance().nextLine();
        comments.add(comment);
        System.out.println("please enter the score for the SuperMarket");
        double star = new Random().nextDouble() % 5;
        try {
            star = ScannerWrapper.getInstance().nextDouble();
            ScannerWrapper.getInstance().nextLine();
            star = starSetterToRight(star);
        } catch (InputMismatchException e) {
            System.out.println("You Entered the Wrong Input and Default will be add -- > Star = Random" + e);
        }
        setStar((getStar()+ star)/2);
    }

    private double starSetterToRight(double star) {
        if (star%5 == 0) {
            return 5;
        }
        return star%5;
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
        } catch (InputMismatchException e) {
            System.out.println("You Entered the Wrong Input and Default will be add" + e);
        }
        return choice - 1;
    }

}
