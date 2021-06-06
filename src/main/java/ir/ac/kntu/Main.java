package ir.ac.kntu;

import ir.ac.kntu.Manager.Address;
import ir.ac.kntu.Manager.Time;
import ir.ac.kntu.Stuff.Food;
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
        stuffs.add(stuff1);
        stuffs.add(stuff2);
        stuffs.add(stuff3);
        stuffs.add(food);
        SuperMarket superMarket= new SuperMarket("A",address1,time1,time2,5,stuffs);
        //superMarket.workingTimeParts(time1,time2);
        //System.out.println(food);
        System.out.println("comments are :\n" + food.getComments());
        //restaurant.addComment();
        System.out.println(superMarket);
        //System.out.println("comments are :\n" + restaurant.getComments());
    }
}