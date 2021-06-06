package ir.ac.kntu.Persons;

import ir.ac.kntu.Market.FruitShop;

import java.util.Objects;

public class FruitShopAdmin extends Admin{
    private FruitShop fruitShop;

    public FruitShopAdmin(String name, String password, FruitShop fruitShop) {
        super(name, password);
        this.fruitShop = fruitShop;
    }

    public boolean checkFruitShopAdminInformation(String userName, String password) {
        if (!getName().equals(userName)) {
            System.out.println("Wrong Username");
            return false;
        }
        if (!this.getPassword().equals(password)) {
            System.out.println("Wrong Password");
            return false;
        }
        System.out.println("Login was successful");
        return true;
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
