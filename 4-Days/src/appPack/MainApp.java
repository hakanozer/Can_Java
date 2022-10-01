package appPack;

import java.util.ArrayList;
import java.util.Scanner;

import appPack.props.User;

public class MainApp {
    public static void main(String[] args) {

        ArrayList<User> ls = new ArrayList<>();

        User u1 = new User();
        u1.setNo(100);
        u1.setName("Erkan");
        u1.setEmail("erkan@mail.com");

        User u2 = new User(110, "Serkan", "serkan@mail.com");

        ls.add(u1);
        ls.add(u2);

        // ls.remove(0);
        // ls.clear();

        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        for ( ;; ) {
            System.out.println("No?");
            int no = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Name?");
            String n = scanner.nextLine();
            System.out.println("Email?");
            String e = scanner.nextLine();
            User u3 = new User(no, n, e);
            ls.add(u3);
            System.out.println("exit x");
            String exit = scanner.nextLine();
            if ( exit.equals("x") ) {
                break;
            }
        }

        for( User item : ls ) {
            System.out.println( item.getNo() + " " + item.getName() + " " + item.getEmail() );
        }

        // Fail
        ArrayList<String> lsx = new ArrayList<>();
        String name = "Ali";
        String email = "ali@mail.com";

        lsx.add(name);
        lsx.add(email);

        name = "Veli";
        email = "veli@mail.com";
        lsx.add(name);
        lsx.add(email);

        System.out.println( lsx.size() );
        System.out.println( lsx );


    }
}
