package ir.ac.kntu.menu;

import ir.ac.kntu.Stuff.Food;
import ir.ac.kntu.manager.Address;
import ir.ac.kntu.manager.PriceType;
import ir.ac.kntu.manager.ScannerWrapper;
import ir.ac.kntu.manager.Time;
import ir.ac.kntu.market.Restaurant;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

public class RestaurantMenuForAdmin {
    enum RestaurantMenu {
        SHOW_SAVED_RESTAURANT,ADD_RESTAURANT,CHANGE_ONE_RESTAURANTS_INFORMATION,SEE_THE_IDEAS_AND_SCORE
    }

    public RestaurantMenuForAdmin(ArrayList<Restaurant> restaurants) {
        menu(restaurants);
    }

    private void menu(ArrayList<Restaurant> restaurants) {
        printRestaurantMenu();
        switch (selector(4,1)) {
            case 1:
                sorting(restaurants);
                showSavedRestaurant(restaurants);
                break;
            case 2:
                addRestaurant(new Restaurant().addRestaurant(),restaurants);
                break;
            case 3:
                modifyRestaurant(restaurants);
                break;
            case 4:
                printIdeasOfRestaurant(restaurants);
                break;
            default:
                System.out.println("Wrong Input");
                break;
        }
    }

    private void printIdeasOfRestaurant(ArrayList<Restaurant> restaurants) {
        printRestaurants(restaurants);
        int choice = selector(restaurants.size());
        System.out.println(restaurants.get(choice).getComments());
    }

    private void addRestaurant(Restaurant restaurant,ArrayList<Restaurant> restaurants){
        restaurants.add(restaurant);
    }

    private void printRestaurantMenu(){
        RestaurantMenu[] restaurantMenu = RestaurantMenu.values();
        for (int i = 0; i < restaurantMenu.length; i++) {
            System.out.println(i+1 + " : " + restaurantMenu[i]);
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

    private void modifyRestaurant(ArrayList<Restaurant> restaurants){
        printRestaurants(restaurants);
        System.out.println("Please Enter the Restaurant That You Want To Modify");
        int choice = selector(restaurants.size(),1);
        System.out.println("Do You Want To Modify If so Enter Yes and If you don't want to add press Enter");
        String input = ScannerWrapper.getInstance().nextLine().trim();
        while(input.matches("[Yy]es|[Yy]")) {
            System.out.println("What do You want to modify");
            printRestaurantModifyMenu();
            switch (selector(7,1)) {
                case 1:
                    System.out.println("Enter the Name");
                    restaurants.get(choice - 1).setName(ScannerWrapper.getInstance().nextLine());
                    break;
                case 2:
                    System.out.println("Enter the address");
                    restaurants.get(choice - 1).setAddress(new Address().addAddress());
                    break;
                case 3:
                    System.out.println("please enter the starting time");
                    restaurants.get(choice - 1).setBeggingTime(new Time().addTime());
                    break;
                case 4:
                    System.out.println("please enter the ending time");
                    restaurants.get(choice - 1).setEndingTime(new Time().addTime());
                    break;
                case 5:
                    System.out.println("Enter the star");
                    restaurants.get(choice - 1).setStar(scoreGetter());
                    break;
                case 6:
                    System.out.println("please Enter the new food (the saved food will be removed)");
                    restaurants.get(choice - 1).setFoods(new Restaurant().addFoods());
                    break;
                case 7:
                    restaurants.get(choice - 1).setPriceType(addPriceType());
                    break;
                default:
                    System.out.println("nothing has been changed");
                    break;
            }
            System.out.println("The modified restaurant : " + restaurants.get(choice - 1).toString());
            System.out.println("Do You Want To Modify more so Enter Yes" +
                    " and If you don't want to modify press Enter");
            input = ScannerWrapper.getInstance().nextLine().trim();
        }
    }

    private void printRestaurantModifyMenu(){
        System.out.println("1 : name;");
        System.out.println("2 : address");
        System.out.println("3 : beggingTime");
        System.out.println("4 : endingTime");
        System.out.println("5 : star");
        System.out.println("6 : add food");
        System.out.println("7 : PriceType");
    }

    private PriceType addPriceType() {
        System.out.println("please Enter the priceType you want");
        PriceType[] priceTypes= PriceType.values();
        for (int i = 0; i < priceTypes.length; i++) {
            System.out.println(i + 1 + " : " + priceTypes[i]);
        }
        int choice = new Random().nextInt(3);
        ScannerWrapper.getInstance().nextLine();
        try {
            choice = ScannerWrapper.getInstance().nextInt()-1;
            ScannerWrapper.getInstance().nextLine();
        } catch (InputMismatchException e) {
            System.out.println("You Entered the Wrong Input and Random will be add\n" + e);
        }
        return  priceTypes[choice];
    }

    private void printRestaurants(ArrayList<Restaurant> restaurants){
        for (int i = 0; i < restaurants.size(); i++) {
            System.out.println(i+1 + " : " +restaurants.get(i));
        }
    }

    private void showSavedRestaurant(ArrayList<Restaurant> restaurants){
        printRestaurants(restaurants);
        System.out.println("Please chose the Restaurant : ");
        foodMenu(ScannerWrapper.getInstance().nextInt()-1,restaurants);
        ScannerWrapper.getInstance().nextLine();
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

    private void foodMenu(int choice,ArrayList<Restaurant> restaurants) {
        ArrayList<Food> foods = restaurants.get(choice-1).getFoods();
        if (foods.size() == 0) {
            System.out.println("there is no food in this restaurant");
        }
        for (int i = 0; i < foods.size(); i++) {
            System.out.println(i+1 +" : " + foods.get(i));
        }
    }

    private void sorting(ArrayList<Restaurant> restaurants){
        System.out.println("Please chose the Restaurant 's sorting");
        printSortOfRestaurants();
        int choice = ScannerWrapper.getInstance().nextInt();
        sortRestaurant(choice,restaurants);
        System.out.println("Please chose the Food 's sorting");
        printSortOfFoods();
        choice = ScannerWrapper.getInstance().nextInt();
        ScannerWrapper.getInstance().nextLine();
        sortFood(choice,restaurants);
    }

    private void printSortOfFoods(){
        System.out.println("1 : Sort by star Ascending");
        System.out.println("2 : Sort by star Descending");
        System.out.println("3 : Sort by Price Ascending");
        System.out.println("4 : Sort by Price Descending");
    }

    private void printSortOfRestaurants(){
        System.out.println("1 : by star Ascending");
        System.out.println("2 : by star Descending");
        System.out.println("3 : by the numbers of ideas up down");
        System.out.println("4 : by the numbers of ideas down up");
    }

    private void sortRestaurant(int choice,ArrayList<Restaurant> restaurants) {
        if (choice == 1) {
            sortRestaurantByStarAscending(restaurants);
        } else if (choice == 2) {
            sortRestaurantByStarDescending(restaurants);
        } else if (choice == 3) {
            sortRestaurantByIdeaAscending(restaurants);
        } else if (choice == 4) {
            sortRestaurantByIdeaDescending(restaurants);
        } else {
            System.out.println("Wrong Input");
        }
    }

    private void sortFood(int choice,ArrayList<Restaurant> restaurants) {
        if (choice == 1) {
            sortFoodByStarAscending(restaurants);
        } else if (choice == 2) {
            sortFoodByStarDescending(restaurants);
        } else if (choice == 3) {
            sortFoodByPriceAscending(restaurants);
        } else if (choice == 4) {
            sortFoodByPriceDescending(restaurants);
        } else {
            System.out.println("Wrong Input");
        }
    }

    private void restaurantSwap(int first,int second,ArrayList<Restaurant> restaurants) {
        Restaurant temp = restaurants.get(first);
        restaurants.set(first,restaurants.get(second));
        restaurants.set(second,temp);
    }

    private void sortRestaurantByStarAscending(ArrayList<Restaurant> restaurants){
        for (int i = 0; i < restaurants.size(); i++) {
            for (int j = 0; j < restaurants.size()- i - 1; j++) {
                if (restaurants.get(j+1).getStar() < restaurants.get(j).getStar()) {
                    restaurantSwap(j,j+1,restaurants);
                }
            }
        }
    }

    private void sortRestaurantByStarDescending(ArrayList<Restaurant> restaurants){
        for (int i = 0; i < restaurants.size(); i++) {
            for (int j = 0; j < restaurants.size()- i - 1; j++) {
                if (restaurants.get(j+1).getStar() > restaurants.get(j).getStar()) {
                    restaurantSwap(j,j+1,restaurants);
                }
            }
        }
    }

    private void sortRestaurantByIdeaAscending(ArrayList<Restaurant> restaurants){
        for (int i = 0; i < restaurants.size(); i++) {
            for (int j = 0; j < restaurants.size()- i - 1; j++) {
                if (restaurants.get(j+1).getComments().size() < restaurants.get(j).getComments().size()) {
                    restaurantSwap(j,j+1,restaurants);
                }
            }
        }
    }

    private void sortRestaurantByIdeaDescending(ArrayList<Restaurant> restaurants){
        for (int i = 0; i < restaurants.size(); i++) {
            for (int j = 0; j < restaurants.size()- i - 1; j++) {
                if (restaurants.get(j+1).getComments().size() > restaurants.get(j).getComments().size()) {
                    restaurantSwap(j,j+1,restaurants);
                }
            }
        }
    }

    private void foodSwap(int restaurant,int first,int second,ArrayList<Restaurant> restaurants){
        Restaurant restaurant1 = restaurants.get(restaurant);
        Food temp = restaurant1.getFoods().get(first);
        restaurant1.getFoods().set(first, restaurants.get(restaurant).getFoods().get(second));
        restaurant1.getFoods().set(second, temp);
    }

    private void sortFoodByPriceAscending(ArrayList<Restaurant> restaurants){
        for (int i = 0; i < restaurants.size(); i++) {
            Restaurant restaurant = restaurants.get(i);
            for (int j = 0; j < restaurant.getFoods().size(); j++) {
                for (int k = 0; k < restaurant.getFoods().size() - j - 1; k++) {
                    if (restaurant.getFoods().get(k+1).getPrice() < restaurant.getFoods().get(k).getPrice()) {
                        foodSwap(i,k,k+1,restaurants);
                    }
                }
            }
        }
    }

    private void sortFoodByPriceDescending(ArrayList<Restaurant> restaurants){
        for (int i = 0; i < restaurants.size(); i++) {
            Restaurant restaurant = restaurants.get(i);
            for (int j = 0; j < restaurant.getFoods().size(); j++) {
                for (int k = 0; k < restaurant.getFoods().size() - j - 1; k++) {
                    if (restaurant.getFoods().get(k+1).getPrice() > restaurant.getFoods().get(k).getPrice()) {
                        foodSwap(i,k,k+1,restaurants);
                    }
                }
            }
        }
    }

    private void sortFoodByStarAscending(ArrayList<Restaurant> restaurants) {
        for (int i = 0; i < restaurants.size(); i++) {
            Restaurant restaurant = restaurants.get(i);
            for (int j = 0; j < restaurant.getFoods().size(); j++) {
                for (int k = 0; k < restaurant.getFoods().size() - j - 1; k++) {
                    if (restaurant.getFoods().get(k).getStar() > restaurant.getFoods().get(k + 1).getStar()) {
                        foodSwap(i,k,k+1,restaurants);
                    }
                }
            }
        }
    }

    private void sortFoodByStarDescending(ArrayList<Restaurant> restaurants) {
        for (int i = 0; i < restaurants.size(); i++) {
            Restaurant restaurant = restaurants.get(i);
            for (int j = 0; j < restaurant.getFoods().size(); j++) {
                for (int k = 0; k < restaurant.getFoods().size() - j - 1; k++) {
                    if (restaurant.getFoods().get(k).getStar() < restaurant.getFoods().get(k + 1).getStar()) {
                        foodSwap(i,k,k+1,restaurants);
                    }
                }
            }
        }
    }
}
