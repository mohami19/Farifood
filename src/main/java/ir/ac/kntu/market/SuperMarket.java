package ir.ac.kntu.market;

import ir.ac.kntu.manager.Address;
import ir.ac.kntu.manager.ScannerWrapper;
import ir.ac.kntu.manager.Time;
import ir.ac.kntu.persons.SuperMarketAdmin;
import ir.ac.kntu.Stuff.Item;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

public class SuperMarket extends Market{
    private final ArrayList<String> comments = new ArrayList<>();

    private ArrayList<Item> items;

    private SuperMarketAdmin superMarketAdmin;

    public SuperMarket() {
    }

    public SuperMarket(String name, Address address, Time beggingTime, Time endingTime,
                       double star, ArrayList<Item> items) {
        super(name, address, beggingTime, endingTime, star);
        this.items = items;
    }

    public void setSuperMarketAdmin(SuperMarketAdmin superMarketAdmin) {
        this.superMarketAdmin = superMarketAdmin;
    }

    public SuperMarketAdmin getSuperMarketAdmin() {
        return superMarketAdmin;
    }

    public ArrayList<String> getComments() {
        return new ArrayList<>(comments);
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public SuperMarket addSuperMarket(){
        System.out.println("please Enter the new SuperMarket");
        System.out.println("Please Enter the name : ");
        String name = ScannerWrapper.getInstance().nextLine();
        Address address = new Address().addAddress();
        System.out.println("Starting Time -->");
        Time start = new Time().addTime();
        System.out.println("Ending Time -->");
        Time end = new Time().addTime();
        ArrayList<Item> items = addItems();
        SuperMarket superMarket = new SuperMarket(name,address,start,end,5,items);
        System.out.println("the new  SuperMarket :  " + superMarket);
        System.out.println("please Enter the SuperMarketAdmin name");
        String userName =ScannerWrapper.getInstance().nextLine();
        System.out.println("please Enter the SuperMarketAdmin password");
        String password =ScannerWrapper.getInstance().nextLine();
        superMarket.setSuperMarketAdmin(new SuperMarketAdmin(userName,password,superMarket));
        return superMarket;
    }

    public ArrayList<Item> addItems(){
        ArrayList<Item> items = new ArrayList<>();
        System.out.println("Adding Item  : ");
        System.out.println("Do You Want To Add Food If so Enter Yes and If you don't want to add press Enter");
        String input = ScannerWrapper.getInstance().nextLine().trim();
        while(input.matches("[Yy]es|[Yy]")){
            Item item = new Item().addItem();
            System.out.println("The Item you have saved : " + item);
            items.add(item);
            System.out.println("Do You Want To Add More If so Enter Yes and If you don't want to add press Enter");
            input = ScannerWrapper.getInstance().nextLine().trim();
        }
        return items;
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
            System.out.println(i+1 + " : "+times.get(i));
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
                " Number of comments = " + comments.size() +
                '}';
    }
}
