package ir.ac.kntu.persons;

import ir.ac.kntu.market.FruitShop;

import java.util.Objects;

public class FruitShopAdmin extends Admin{
    private FruitShop fruitShop;

    public FruitShopAdmin(String name, String password, FruitShop fruitShop) {
        super(name, password);
        this.fruitShop = fruitShop;
    }

    public boolean checkRestaurantAdmin(FruitShopAdmin fruitShopAdmin){
        if (!this.getName().equals(fruitShopAdmin.getName())){
            System.out.println("The Wrong name was used");
            return false;
        } else if (!this.getPassword().equals(fruitShopAdmin.getPassword())) {
            System.out.println("Wrong password");
            return false;
        } else if (!this.fruitShop.equals(fruitShopAdmin.getFruitShop())) {
            System.out.println("this Admin doesn't own this Super Market");
            return false;
        }
        return true;
    }

    public FruitShop getFruitShop() {
        return fruitShop;
    }

    @Override
    public String toString() {
        return "FruitShopAdmin { " + super.toString()+
                "fruitShop=" + fruitShop +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        FruitShopAdmin that = (FruitShopAdmin) o;
        return Objects.equals(fruitShop, that.fruitShop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fruitShop);
    }
}
