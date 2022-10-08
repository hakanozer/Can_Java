package appPack;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {

        Customer customer = new Customer(200);
        int total = customer.totalAmount();
        System.out.println( total );

        Person person = new Person() {
            @Override
            int accountNumber() {
                return 100;
            }

            @Override
            String accountName() {
                return null;
            }
        };
        person.totalAmount();

    }
}
