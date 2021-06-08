package ir.ac.kntu.menu.marketadminmenu;

import ir.ac.kntu.manager.Address;
import ir.ac.kntu.manager.ScannerWrapper;
import ir.ac.kntu.manager.Time;
import ir.ac.kntu.market.SuperMarket;
import ir.ac.kntu.persons.SuperMarketAdmin;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

public class SuperMarketAdminMenu {
    enum Menu {MODIFY_SUPERMARKET,SEE_THE_COMMENTS}

    public SuperMarketAdminMenu(ArrayList<SuperMarket> superMarkets) {
        menu(superMarkets);
    }

    private void menu(ArrayList<SuperMarket> superMarkets) {
        printMenu();
        System.out.println("please chose the thing you want to do");
        switch (selector(2)){
            case 1:
                modifySuperMarket(superMarkets);
                break;
            case 2:
                seeTheCommentsOfOneSuperMarket(superMarkets);
                break;
            default:
                System.out.println("Wrong Input");
                break;
        }
    }

    private  void seeTheCommentsOfOneSuperMarket(ArrayList<SuperMarket> superMarkets) {
        printSuperMarkets(superMarkets);
        int choice = selector(superMarkets.size());
        System.out.println(superMarkets.get(choice).getComments());
    }

    private void modifySuperMarket(ArrayList<SuperMarket> superMarkets) {
        printSuperMarkets(superMarkets);
        System.out.println("Please Enter the Restaurant That You Want To Modify");
        int choice = selector(superMarkets.size(),1);
        SuperMarketAdmin superMarketAdmin = addSuperMarketAdmin(superMarkets.get(choice-1));
        if (!superMarkets.get(choice-1).getSuperMarketAdmin().checkSuperMarketAdmin(superMarketAdmin)) {
            System.out.println("Wrong Admin");
            return;
        }
        System.out.println("Do You Want To Modify If so Enter Yes" +
                " and If you don't want to add press Enter");
        String input = ScannerWrapper.getInstance().nextLine().trim();
        while(input.matches("[Yy]es|[Yy]")){
            System.out.println("What do You want to modify");
            printSuperMarketModifyMenu();
            switch (selector(6,1)) {
                case 1:
                    System.out.println("Enter the Name");
                    superMarkets.get(choice-1).setName(ScannerWrapper.getInstance().nextLine());
                    break;
                case 2:
                    System.out.println("Enter the address");
                    superMarkets.get(choice-1).setAddress(new Address().addAddress());
                    break;
                case 3:
                    System.out.println("please enter the starting time");
                    superMarkets.get(choice-1).setBeggingTime(new Time().addTime());
                    break;
                case 4:
                    System.out.println("please enter the ending time");
                    superMarkets.get(choice-1).setEndingTime(new Time().addTime());
                    break;
                case 5:
                    System.out.println("Enter the star");
                    superMarkets.get(choice-1).setStar(scoreGetter());
                    break;
                case 6:
                    System.out.println("please Enter the new food (the saved food will be removed)");
                    superMarkets.get(choice-1).setItems(new SuperMarket().addItems());
                    break;
                default:
                    System.out.println("nothing has been changed");
                    break;
            }
            System.out.println("The modified restaurant : " + superMarkets.get(choice - 1).toString());
            System.out.println("Do You Want To Modify more so Enter Yes" +
                    " and If you don't want to modify press Enter");
            input = ScannerWrapper.getInstance().nextLine().trim();
        }
    }

    private SuperMarketAdmin addSuperMarketAdmin(SuperMarket superMarket){
        System.out.println("please Enter the name of the owner for log in");
        String name = ScannerWrapper.getInstance().nextLine();
        System.out.println("please Enter the password of the owner for log in");
        String password = ScannerWrapper.getInstance().nextLine();
        return new SuperMarketAdmin(name,password,superMarket);
    }

    private void printSuperMarkets(ArrayList<SuperMarket> superMarkets) {
        for (int i = 0; i < superMarkets.size(); i++) {
            System.out.println(i+1 + " : " + superMarkets.get(i));
        }
    }

    private void printSuperMarketModifyMenu(){
        System.out.println("1 : Name");
        System.out.println("2 : address");
        System.out.println("3 : the starting time");
        System.out.println("4 : the ending time");
        System.out.println("5 : the star");
        System.out.println("6 : the Items");
    }

    private double scoreGetter(){
        double score = new Random().nextInt(5) + 1;
        try {
            score = ScannerWrapper.getInstance().nextDouble();
            ScannerWrapper.getInstance().nextLine();
        } catch (InputMismatchException e) {
            System.out.println("You Entered the Wrong Input and Random will be add\n" + e);
        }
        return score;
    }

    /*private void addSuperMarket(SuperMarket superMarket,ArrayList<SuperMarket> superMarkets) {
        superMarkets.add(superMarket);
    }*/

    private void printMenu(){
        Menu[] menu = Menu.values();
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i+1 +" : " + menu[i]);
        }
    }

    private int selector(int bound){
        int chosen = new Random().nextInt(bound);
        try {
            chosen = ScannerWrapper.getInstance().nextInt();
            ScannerWrapper.getInstance().nextLine();
        } catch (InputMismatchException e) {
            System.out.println("You Entered the Wrong Input and Random will be add\n" + e);
        }
        return chosen;
    }

    private int selector(int bound,int start){
        int chosen = start + new Random().nextInt(bound);
        try {
            chosen = ScannerWrapper.getInstance().nextInt();
            ScannerWrapper.getInstance().nextLine();
        } catch (InputMismatchException e) {
            System.out.println("You Entered the Wrong Input and Random will be add\n" + e);
        }
        return chosen;
    }
}
