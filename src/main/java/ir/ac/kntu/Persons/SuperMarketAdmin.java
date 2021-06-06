package ir.ac.kntu.Persons;

import ir.ac.kntu.Market.SuperMarket;

import java.util.Objects;

public class SuperMarketAdmin extends Admin {
    private SuperMarket superMarket;

    public SuperMarketAdmin(String name, String password, SuperMarket superMarket) {
        super(name, password);
        this.superMarket = superMarket;
    }

    public boolean checkSuperMarketAdminInformation(String userName, String password) {
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
        SuperMarketAdmin that = (SuperMarketAdmin) o;
        return Objects.equals(superMarket, that.superMarket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), superMarket);
    }
}
