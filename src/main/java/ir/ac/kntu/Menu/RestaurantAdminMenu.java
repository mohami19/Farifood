package ir.ac.kntu.Menu;

import ir.ac.kntu.Delivery.Delivery;
import ir.ac.kntu.Manager.Address;
import ir.ac.kntu.Manager.ScannerWrapper;
import ir.ac.kntu.Manager.Time;
import ir.ac.kntu.Market.Restaurant;
import ir.ac.kntu.Stuff.Food;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

public class RestaurantAdminMenu {

    public RestaurantAdminMenu(ArrayList<Restaurant> restaurants, ArrayList<Delivery> deliveries) {
        restaurantAdminMenu(restaurants,deliveries);
    }

    public void restaurantAdminMenu(ArrayList<Restaurant> restaurants, ArrayList<Delivery> deliveries){
        int choice = ScannerWrapper.getInstance().nextInt();
        ScannerWrapper.getInstance().nextLine();
        if (choice == 1) {
            //sorting.sorting(scan,restaurants);
            showSavedRestaurant(restaurants);
        } else if (choice == 2) {
            addRestaurant(new Restaurant().addRestaurant(),restaurants);
        } else if (choice == 3) {
            modifyRestaurant(restaurants);
        } else if (choice == 4) {
            //TODO
            // seeTheDelivery(deliveries);
            ScannerWrapper.getInstance().nextLine();
        } else if (choice == 5) {
            //TODO
            // output.printIdeasOfRestaurant(restaurants);
            ScannerWrapper.getInstance().nextLine();
        }
    }

    public void addRestaurant(Restaurant restaurant,ArrayList<Restaurant>restaurants) {
        restaurants.add(restaurant);
    }

    private void modifyRestaurant(ArrayList<Restaurant> restaurants){
        //output.printRestaurants(restaurants);
        System.out.println("Please Enter the Restaurant That You Want To Modify");
        String variable = ScannerWrapper.getInstance().nextLine();
        int choice = Integer.parseInt(variable);
        System.out.println("Do You Want To Modify If so Enter Yes" +
                " and If you don't want to add press Enter");
        String input = ScannerWrapper.getInstance().nextLine().trim();
        while(input.matches("[Yy]es|[Yy]")){
            System.out.println("What do You want to modify");
            //printRestaurantModifyMenu();
            switch (selector()) {
                case 1:
                    System.out.println("Enter the Name");
                    restaurants.get(choice-1).setName(ScannerWrapper.getInstance().nextLine());
                    break;
                case 2:
                    System.out.println("Enter the address");
                    restaurants.get(choice-1).setAddress(new Address().addAddress());
                    break;
                case 3:
                    System.out.println("please enter the starting time");
                    restaurants.get(choice-1).setBeggingTime(new Time().addTime());
                    break;
                case 4:
                    System.out.println("please enter the ending time");
                    restaurants.get(choice-1).setEndingTime(new Time().addTime());
                    break;
                case 5:
                    System.out.println("Enter the star");
                    restaurants.get(choice-1).setStar(scoreGetter());
                    break;
                case 6:
                    System.out.println("please Enter the new food (the saved food will be removed)");
                    restaurants.get(choice-1).setFoods(new Restaurant().addFoods());
                    break;
                default:
                    System.out.println("nothing has been changed");
                    break;
            }
            System.out.println("The modified restaurant : " +restaurants.get(choice - 1).toString());
            System.out.println("Do You Want To Modify more so Enter Yes" +
                    " and If you don't want to modify press Enter");
            input = ScannerWrapper.getInstance().nextLine().trim();
        }
    }

    private int selector(){
        int chosen = new Random().nextInt(3);
        try {
            chosen = ScannerWrapper.getInstance().nextInt()-1;
            ScannerWrapper.getInstance().nextLine();
        } catch (InputMismatchException e) {
            System.out.println("You Entered the Wrong Input and Random will be add\n" + e);
        }
        return chosen;
    }

    private double scoreGetter(){
        double score = 1 + new Random().nextInt(5);
        try {
            score = ScannerWrapper.getInstance().nextDouble();
            ScannerWrapper.getInstance().nextLine();
        } catch (InputMismatchException e) {
            System.out.println("You Entered the Wrong Input and Random will be add\n" + e);
        }
        return score;
    }


    private void showSavedRestaurant(ArrayList<Restaurant> restaurants){
        //output.printRestaurants(restaurants);
        System.out.println("Please chose the Restaurant : ");
        foodMenu(ScannerWrapper.getInstance().nextInt(),restaurants);
        ScannerWrapper.getInstance().nextLine();
    }

    private void foodMenu(int choice,ArrayList<Restaurant> restaurants) {
        ArrayList<Food> foods = restaurants.get(choice-1).getFoods();
        if (foods.size() == 0) {
            System.out.println("there is no food in this restaurant");
        }
        for (int i = 0; i < foods.size(); i++) {
            System.out.println(i+1 +" : " + foods.get(i));
        }
    }
}
