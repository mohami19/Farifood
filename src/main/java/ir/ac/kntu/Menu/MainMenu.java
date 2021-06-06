package ir.ac.kntu.Menu;

import ir.ac.kntu.Manager.ScannerWrapper;

import java.util.InputMismatchException;
import java.util.Random;

public class MainMenu {
    public MainMenu() {
        mainMenu();
    }
    private void mainMenu (){
        System.out.println("pleas Enter the part you want to Enter");
        int choice = 1 + new Random().nextInt(5);
        try {
            choice = ScannerWrapper.getInstance().nextInt();
        } catch (InputMismatchException e) {
            System.out.println("You Entered the Wrong Input and Random will be add\n" + e);
            System.out.println("The choice is : " + choice);
        }
        ScannerWrapper.getInstance().nextLine();
        switch (choice) {
            case 1:
                //AdminMenu
                break;
            case 2:
                //CustomerMenu
                break;
            case 3:
                //MarketAdminMenu
                break;
            case 4:
                //Features
                break;
            case 5:
                //AddAdmin
                break;
            default:
                break;
        }
    }
}
