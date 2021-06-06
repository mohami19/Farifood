package ir.ac.kntu;

import ir.ac.kntu.Manager.Address;
import ir.ac.kntu.Manager.Time;
import ir.ac.kntu.Market.FruitShop;
import ir.ac.kntu.Market.Market;
import ir.ac.kntu.Market.SuperMarket;
import ir.ac.kntu.Stuff.Food;
import ir.ac.kntu.Stuff.Fruit;
import ir.ac.kntu.Stuff.Item;
import ir.ac.kntu.Stuff.Stuff;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Address address1 = new Address("sus1","19");
        Time time1 = new Time(12,30);
        Time time2 = new Time(22,30);
        ArrayList<Stuff> stuffs = new ArrayList<>();
        Stuff stuff1 = new Food("Pitza",15,5,time2);
        Stuff stuff2 = new Food("Ali",15,5,time1);
        Stuff stuff3 = new Item("pizza",15,5,10);
        Food food = new Food("kebab",15,5,time1);
        Fruit fruit = new Fruit("Apple",2,5,10);
        stuffs.add(stuff1);
        stuffs.add(stuff2);
        stuffs.add(stuff3);
        stuffs.add(food);
        stuffs.add(fruit);
        SuperMarket superMarket= new SuperMarket("A",address1,time1,time2,5,stuffs);
        Market fruitShop = new FruitShop("abdol",address1,time1,time2,5,stuffs);
        FruitShop fruitShop1 = (FruitShop) fruitShop;
        //((FruitShop) fruitShop).workingTimeParts(time1,time2);
        //superMarket.workingTimeParts(time1,time2);
        //System.out.println(food);
        fruitShop1.addComment();
        System.out.println("comments are :\n" + fruitShop1.getComments());
        //restaurant.addComment();
        System.out.println(fruitShop);
        System.out.println(superMarket);
        //System.out.println("comments are :\n" + restaurant.getComments());
    }
}