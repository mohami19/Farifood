package ir.ac.kntu.menu;

import ir.ac.kntu.Stuff.Food;
import ir.ac.kntu.Stuff.Item;
import ir.ac.kntu.delivery.Delivery;
import ir.ac.kntu.manager.Address;
import ir.ac.kntu.manager.PriceType;
import ir.ac.kntu.manager.ScannerWrapper;
import ir.ac.kntu.manager.Time;
import ir.ac.kntu.market.FruitShop;
import ir.ac.kntu.market.Restaurant;
import ir.ac.kntu.market.SuperMarket;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

public class MainMenu {
    private final ArrayList<Restaurant> restaurants = new ArrayList<>();

    private final ArrayList<SuperMarket> superMarkets = new ArrayList<>();

    private final ArrayList<FruitShop> fruitShops = new ArrayList<>();

    private final ArrayList<Delivery> deliveries = new ArrayList<>();

    public MainMenu() {
        //TODO primaryFruitShop
        primarySuperMarket();
        primaryRestaurants();
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
                new MarketAdminMenu(restaurants,deliveries,superMarkets,fruitShops);
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

    private void primarySuperMarket(){
        ArrayList<Item>[] items = primaryItems();
        SuperMarket superMarket1 = new SuperMarket("DayToDay",new Address("Wild 2","13"),
                new Time(10,0),new Time(23,0),5,items[0]);
        SuperMarket superMarket2 = new SuperMarket("Saida",new Address("Asgard","13"),
                new Time(10,0),new Time(23,0),5,items[1]);
        SuperMarket superMarket3 = new SuperMarket("Ham Hame",new Address("Salehi","17"),
                new Time(10,0),new Time(23,0),5,items[2]);
        SuperMarket superMarket4 = new SuperMarket("Aref",new Address("Tehran","19"),
                new Time(10,0),new Time(23,0),5,items[3]);
        superMarkets.add(superMarket1);
        superMarkets.add(superMarket2);
        superMarkets.add(superMarket3);
        superMarkets.add(superMarket4);
    }

    private ArrayList<Item>[] primaryItems(){
        ArrayList<Item>[] items = new ArrayList[4];
        for (int i = 0; i < items.length; i++) {
            items[i]= new ArrayList<>();
        }
        items[0].add(new Item("koloche",2,5,25));
        items[0].add(new Item("Noshabe",2.5,5,15));
        items[0].add(new Item("vaifer",1,5,30));
        items[1].add(new Item("zhele",2,5,15));
        items[1].add(new Item("fanta",2.5,5,20));
        items[1].add(new Item("chips",1,5,30));
        items[2].add(new Item("pofak",2,5,25));
        items[2].add(new Item("Chocolate",2.5,5,15));
        items[2].add(new Item("abnabat",1,5,30));
        items[3].add(new Item("oil",2,5,25));
        items[3].add(new Item("Milk",2.5,5,15));
        items[3].add(new Item("egg",1,5,30));
        return items;
    }

    private void primaryRestaurants(){
        ArrayList<Food>[] foods = primaryFood();
        Restaurant restaurant1 = new Restaurant("DumpEater", new Address("Harvest","92"),
                new Time(8,0),new Time(22,0), 5,foods[0], PriceType.NORMAL );
        Restaurant restaurant2 = new Restaurant("Dine Dime", new Address("Wild ","13"),
                new Time(10,0),new Time(23,0), 5,foods[1],PriceType.NORMAL);
        Restaurant restaurant3 = new Restaurant("Dine Fine", new Address("Harvest","11"),
                new Time(1,0),new Time(16,0), 5,foods[2],PriceType.ECONOMIC);
        Restaurant restaurant4 = new Restaurant("Excellent Experience", new Address("Brook","10"),
                new Time(8,0), new Time(23,0),5,foods[3],PriceType.LUXURY);
        restaurants.add(restaurant1);
        restaurants.add(restaurant2);
        restaurants.add(restaurant3);
        restaurants.add(restaurant4);
    }

    private ArrayList<Food>[] primaryFood(){
        ArrayList<Food>[] foods = new ArrayList[4];
        for (int i = 0; i < foods.length; i++) {
            foods[i]= new ArrayList<>();
        }
        foods[0].add(new Food("Cheese",16,5,new Time(1,0)));
        foods[0].add(new Food("Margarine",20,5,new Time(2,0)));
        foods[0].add(new Food("Fish",15,5,new Time(1,30)));
        foods[0].add(new Food("Kebab",20,5,new Time(2,0)));
        foods[1].add(new Food("Hot dog",14,5,new Time(0,30)));
        foods[1].add(new Food("Sausage",17,5,new Time(1,0)));
        foods[1].add(new Food("Ham",15,5,new Time(1,0)));
        foods[1].add(new Food("Kebab",23,5,new Time(2,0)));
        foods[2].add(new Food("Sushi",16,5,new Time(1,20)));
        foods[2].add(new Food("Ham",14,5,new Time(0,30)));
        foods[2].add(new Food("Bacon",12,5,new Time(3,0)));
        foods[2].add(new Food("Ham",12,5,new Time(3,0)));
        foods[3].add(new Food("Pizza",21,5,new Time(3,0)));
        foods[3].add(new Food("Steak",22,5,new Time(2,30)));
        foods[3].add(new Food("Roast chicken",28,5,new Time(2,0)));
        foods[3].add(new Food("Wagyu beef",27,5,new Time(1,30)));
        return foods;
    }
}
