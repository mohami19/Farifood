package ir.ac.kntu.menu;

import ir.ac.kntu.Stuff.Food;
import ir.ac.kntu.Stuff.Fruit;
import ir.ac.kntu.Stuff.Item;
import ir.ac.kntu.customer.RestaurantOrder;
import ir.ac.kntu.delivery.AvailableDay;
import ir.ac.kntu.delivery.Delivery;
import ir.ac.kntu.delivery.DeliveryPriceType;
import ir.ac.kntu.delivery.DeliveryType;
import ir.ac.kntu.manager.Address;
import ir.ac.kntu.manager.PriceType;
import ir.ac.kntu.manager.ScannerWrapper;
import ir.ac.kntu.manager.Time;
import ir.ac.kntu.market.FruitShop;
import ir.ac.kntu.market.Restaurant;
import ir.ac.kntu.market.SuperMarket;
import ir.ac.kntu.menu.marketadminmenu.MarketAdminMenu;
import ir.ac.kntu.persons.Admin;
import ir.ac.kntu.persons.FruitShopAdmin;
import ir.ac.kntu.persons.RestaurantAdmin;
import ir.ac.kntu.persons.SuperMarketAdmin;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

public class MainMenu {
    enum Option {
        ADMIN_MENU,CUSTOMER_MENU,MARKET_ADMIN_MENU,FEATURES,EXIT
    }

    private final ArrayList<RestaurantOrder> restaurantOrders = new ArrayList<>();
    private final ArrayList<Delivery> deliveries = new ArrayList<>();

    private final ArrayList<Restaurant> restaurants = new ArrayList<>();

    private final ArrayList<SuperMarket> superMarkets = new ArrayList<>();

    private final ArrayList<FruitShop> fruitShops = new ArrayList<>();

    private final ArrayList<Admin> admins = new ArrayList<>();

    public MainMenu() {
        admins.add(0,new Admin("Mahdi","9928793"));
        primaryFruitShop();
        primarySuperMarket();
        primaryRestaurants();
        primaryDelivery();
        mainMenu();
    }

    private void mainMenu(){
        System.out.println("if you want to do sth please enter yes else enter anything you want");
        String input = ScannerWrapper.getInstance().nextLine();
        while (input.matches("[Yy]es|[Yy]")) {
            printMainMenu();
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
                    new AdminMenu(restaurants,superMarkets,fruitShops,admins,deliveries, restaurantOrders);
                    break;
                case 2:
                    //TODO
                    // CustomerMenu
                    break;
                case 3:
                    new MarketAdminMenu(restaurants,superMarkets,fruitShops);
                    break;
                case 4:
                    //TODO
                    new Features(restaurants,superMarkets,fruitShops);
                    break;
                default:
                    System.out.println("Wrong Input");
                    break;
            }
            System.out.println("if you want to do more enter yes else enter anything you want");
            input = ScannerWrapper.getInstance().nextLine().trim();
        }
    }

    private void printMainMenu(){
        Option[] options = Option.values();
        for (int i = 0; i < options.length; i++) {
            System.out.println(i+1 + " : "+options[i]);
        }
    }

    private void primaryFruitShop() {
        ArrayList<Fruit>[] fruits = primaryFruits();
        FruitShop fruitShop1 = new FruitShop("Majid",new Address("Wild 1","15"),
                new Time(11,0),new Time(22,0),5,fruits[0]);
        fruitShop1.setFruitShopAdmin(new FruitShopAdmin("Ali","213",fruitShop1));
        FruitShop fruitShop2 = new FruitShop("Majid",new Address("Wild 1","15"),
                new Time(11,0),new Time(22,0),5,fruits[1]);
        fruitShop2.setFruitShopAdmin(new FruitShopAdmin("Ali","213",fruitShop2));
        FruitShop fruitShop3 = new FruitShop("Majid",new Address("Wild 1","15"),
                new Time(11,0),new Time(22,0),5,fruits[2]);
        fruitShop3.setFruitShopAdmin(new FruitShopAdmin("Ali","213",fruitShop3));
        FruitShop fruitShop4 = new FruitShop("Majid",new Address("Wild 1","15"),
                new Time(11,0),new Time(22,0),5,fruits[3]);
        fruitShop4.setFruitShopAdmin(new FruitShopAdmin("Ali","213",fruitShop4));
        fruitShops.add(fruitShop1);
        fruitShops.add(fruitShop2);
        fruitShops.add(fruitShop3);
        fruitShops.add(fruitShop4);
    }

    private ArrayList<Fruit>[] primaryFruits(){
        ArrayList<Fruit>[] fruits = new ArrayList[4];
        for (int i = 0; i < fruits.length; i++) {
            fruits[i]= new ArrayList<>();
        }
        fruits[0].add(new Fruit("Apple",15,5,4));
        fruits[0].add(new Fruit("onion",10,5,3));
        fruits[0].add(new Fruit("mango",10,5,3));
        fruits[0].add(new Fruit("banana",10,5,3));
        fruits[1].add(new Fruit("fig",10,5,3));
        fruits[1].add(new Fruit("grape",10,5,3));
        fruits[1].add(new Fruit("pineapple",10,5,3));
        fruits[1].add(new Fruit("apple",10,5,3));
        fruits[2].add(new Fruit("Kiwi",10,5,3));
        fruits[2].add(new Fruit("avocado",10,5,3));
        fruits[2].add(new Fruit("banana",10,5,3));
        fruits[2].add(new Fruit("Lemon",10,5,3));
        fruits[3].add(new Fruit("pomegranate",10,5,3));
        fruits[3].add(new Fruit("water apple",10,5,3));
        fruits[3].add(new Fruit("orange",10,5,3));
        fruits[3].add(new Fruit("banana",10,5,3));
        return fruits;
    }

    private void primarySuperMarket(){
        ArrayList<Item>[] items = primaryItems();
        SuperMarket superMarket1 = new SuperMarket("DayToDay",new Address("Wild 2","13"),
                new Time(10,0),new Time(23,0),5,items[0]);
        superMarket1.setSuperMarketAdmin(new SuperMarketAdmin("Ali","123",superMarket1));
        SuperMarket superMarket2 = new SuperMarket("Saida",new Address("Asgard","13"),
                new Time(10,0),new Time(23,0),5,items[1]);
        superMarket2.setSuperMarketAdmin(new SuperMarketAdmin("Hossein","1234",superMarket2));
        SuperMarket superMarket3 = new SuperMarket("Ham Hame",new Address("Salehi","17"),
                new Time(10,0),new Time(23,0),5,items[2]);
        superMarket3.setSuperMarketAdmin(new SuperMarketAdmin("Hassan","1234",superMarket3));
        SuperMarket superMarket4 = new SuperMarket("Aref",new Address("Tehran","19"),
                new Time(10,0),new Time(23,0),5,items[3]);
        superMarket4.setSuperMarketAdmin(new SuperMarketAdmin("Mahdi","1234",superMarket4));
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
        restaurant1.setRestaurantAdmin(new RestaurantAdmin("Ali","12",restaurant1));
        Restaurant restaurant2 = new Restaurant("Dine Dime", new Address("Wild ","13"),
                new Time(10,0),new Time(23,0), 5,foods[1],PriceType.NORMAL);
        restaurant2.setRestaurantAdmin(new RestaurantAdmin("Hossein","12",restaurant2));
        Restaurant restaurant3 = new Restaurant("Dine Fine", new Address("Harvest","11"),
                new Time(1,0),new Time(16,0), 5,foods[2],PriceType.ECONOMIC);
        restaurant3.setRestaurantAdmin(new RestaurantAdmin("Mahdi","12",restaurant3));
        Restaurant restaurant4 = new Restaurant("Excellent Experience", new Address("Brook","10"),
                new Time(8,0), new Time(23,0),5,foods[3],PriceType.LUXURY);
        restaurant4.setRestaurantAdmin(new RestaurantAdmin("Hassan","12",restaurant4));
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

    private void primaryDelivery(){
        ArrayList<AvailableDay> availableDays1= new ArrayList<>();
        availableDays1.add(AvailableDay.FRIDAY);
        availableDays1.add(AvailableDay.SUNDAY);
        Delivery delivery1 = new Delivery(DeliveryType.CAR,1, DeliveryPriceType.HOURLY,availableDays1,
                5,new Time(8,0),new Time(19,0));
        ArrayList<AvailableDay> availableDays2= new ArrayList<>();
        availableDays2.add(AvailableDay.TUESDAY);
        availableDays2.add(AvailableDay.SUNDAY);
        availableDays2.add(AvailableDay.MONDAY);
        Delivery delivery2 = new Delivery(DeliveryType.CAR,5, DeliveryPriceType.PER_ORDER,
                availableDays2,5,new Time(10,30),new Time(15,0));
        ArrayList<AvailableDay> availableDays3 = new ArrayList<>();
        availableDays3.add(AvailableDay.TUESDAY);
        availableDays3.add(AvailableDay.SUNDAY);
        availableDays3.add(AvailableDay.MONDAY);
        Delivery delivery3 = new Delivery(DeliveryType.MOTOR,4, DeliveryPriceType.PER_ORDER,
                availableDays3,5,new Time(10,30),new Time(24,0));
        deliveries.add(delivery1);
        deliveries.add(delivery2);
        deliveries.add(delivery3);
    }
}
