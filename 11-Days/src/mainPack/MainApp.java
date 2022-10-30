package mainPack;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {

        int a = 10;
        String name = "Ali";

        System.out.println(name);
        System.out.println(a);

        int j = 0;
        for (int i = 0; i < 10; i++) {
            j++;
            Customer c = new Customer("name"+i, i);
            System.out.println( c.getAge() );
        }

        // generic
        List<String> ls = new ArrayList<>();
        ls.add("Can");

        Action<Customer> action = new Action<>();
        Customer ca = new Customer("Ali", 30);
        Customer cb = new Customer("Veli", 40);
        action.sum(ca, cb);

        Action<Integer> action1 = new Action<>();
        action1.sum(50, 69);

        // Thread
        DoAction doAction = new DoAction();
        doAction.start();

        System.out.println("This Line Call");


    }
}
