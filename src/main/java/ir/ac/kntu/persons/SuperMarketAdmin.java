package ir.ac.kntu.persons;

import ir.ac.kntu.market.SuperMarket;

import java.util.Objects;

public class SuperMarketAdmin extends Admin {
    private SuperMarket superMarket;

    public SuperMarketAdmin(String name, String password, SuperMarket superMarket) {
        super(name, password);
        this.superMarket = superMarket;
    }

    public SuperMarket getSuperMarket() {
        return superMarket;
    }

    public boolean checkSuperMarketAdmin(SuperMarketAdmin superMarketAdmin){
        if (!this.getName().equals(superMarketAdmin.getName())){
            System.out.println("The Wrong name was used");
            return false;
        } else if (!this.getPassword().equals(superMarketAdmin.getPassword())) {
            System.out.println("Wrong password");
            return false;
        } else if (!this.superMarket.equals(superMarketAdmin.getSuperMarket())) {
            System.out.println("this Admin doesn't own this Super Market");
            return false;
        }
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
