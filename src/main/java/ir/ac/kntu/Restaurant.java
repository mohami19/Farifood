package ir.ac.kntu;

import ir.ac.kntu.Manager.Address;
import ir.ac.kntu.Manager.PriceType;
import ir.ac.kntu.Manager.Time;

import java.util.ArrayList;

public class Restaurant extends Market{

    private PriceType priceType;

    public Restaurant(String name, Address address, Time beggingTime, Time endingTime,
                      double star, ArrayList<Stuff> stuffs, PriceType priceType) {
        super(name, address, beggingTime, endingTime, star, stuffs);
        this.priceType = priceType;
    }

    public void setPriceType(PriceType priceType) {
        this.priceType = priceType;
    }

    @Override
    public String toString() {
        return "Restaurant { " + super.toString() +
                ", priceType = " + priceType +
                "}";
    }
}
