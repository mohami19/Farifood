package ir.ac.kntu.Menu;

import ir.ac.kntu.Delivery.Delivery;
import ir.ac.kntu.Manager.ScannerWrapper;
import ir.ac.kntu.Market.Restaurant;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

public class MainMenu {
    private final ArrayList<Restaurant> restaurants = new ArrayList<>();

    private final ArrayList<Delivery> deliveries = new ArrayList<>();

    public MainMenu() {
        mainMenu();
    }
    private void mainMenu(){
        System.out.println("pleas Enter the part you want to Enter");
        int choice = 1 + new Random().nextInt(5);
        try {
            choice = ScannerWrapper.getInstance().nextInt();
            ScannerWrapper.getInstance().nextLine();
        } catch (InputMismatchException e) {
            System.out.println("You Entered the Wrong Input and Random will be add\n" + e);
            System.out.println("The choice is : " + choice);
        }
        switch (choice) {
            case 1:
                //TODO
                // AdminMenu
                break;
            case 2:
                //TODO
                // CustomerMenu
                break;
            case 3:
                //TODO
                // MarketAdminMenu
                new MarketAdminMenu(restaurants,deliveries);
                break;
            case 4:
                //TODO
                // Features
                break;
            case 5:
                //TODO
                // AddAdmin
                break;
            default:
                break;
        }
    }
}
