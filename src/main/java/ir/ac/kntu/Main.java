package ir.ac.kntu;

import ir.ac.kntu.Manager.Address;
import ir.ac.kntu.Manager.PriceType;
import ir.ac.kntu.Manager.Time;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Address address1 = new Address("sus1","19");
        Time time1 = new Time(12,30);
        Time time2 = new Time(23,30);
        ArrayList<Stuff> stuffs = new ArrayList<>();
        Stuff stuff1 = new Stuff("Pitza",15,5);
        Stuff stuff2 = new Stuff("Pitza",15,5);
        Stuff stuff3 = new Stuff("Pitza",15,5);
        stuffs.add(stuff1);
        stuffs.add(stuff2);
        stuffs.add(stuff3);
        Restaurant restaurant = new Restaurant("A",address1,time1,time2,5,stuffs, PriceType.ECONOMIC);
        restaurant.addComment();
        System.out.println(restaurant);
        System.out.println("comments are :\n" + restaurant.getComments());
    }
}