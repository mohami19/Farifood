package ir.ac.kntu.persons;

import ir.ac.kntu.manager.ScannerWrapper;

import java.util.Objects;

public class Admin extends Person{

    private String password;

    public Admin(String name, String password) {
        super(name);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public Admin addAdmin(){
        System.out.println("Please Enter the Username");
        String name = ScannerWrapper.getInstance().nextLine();
        System.out.println("Please Enter the Password");
        String password = ScannerWrapper.getInstance().nextLine();
        return new Admin(name,password);
    }

    @Override
    public String toString() {
        return "Admin{" + super.toString() +
                "password='" + password + '\'' +
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
        Admin admin = (Admin) o;
        return Objects.equals(password, admin.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), password);
    }
}
