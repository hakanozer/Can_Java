package appPack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class UseSet {
    public static void main(String[] args) {

        // Set -> benzersiz değerler tutmak için kullanılır.
        Set<String> set = new HashSet<>();

        ArrayList<String> newList = new ArrayList<>();
        for ( String item : newList ) {
            set.add(item);
        }

        // add item
        set.add("Ali");
        set.add("Ali");
        set.add("Ali");
        set.add("Ali");
        set.add("Ali");
        set.add("Serkan");
        set.add("Zehra");

        System.out.println( set );
        System.out.println("========================");
        // benzersiz değerler tutmak için kullanılır, sıralama bizim eklemediğimiz şekilde olur.
        Set<String> set1 = new LinkedHashSet<>();

        set1.add("Ali");
        set1.add("Ali");
        set1.add("Ali");
        set1.add("Ali");
        set1.add("Ali");
        set1.add("Serkan");
        set1.add("Zehra");
        System.out.println( set1 );

    }
}
