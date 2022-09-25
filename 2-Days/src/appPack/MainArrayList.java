package appPack;

import java.util.ArrayList;
import java.util.Collections;

public class MainArrayList {
    public static void main(String[] args) {

        // ArrayList
        // Mutable özelliklere sahipler
        ArrayList<String> ls = new ArrayList<>();

        // yeni eleman eklem
        ls.add("Kaan");
        ls.add("Asya");
        ls.add("Ayşe");
        ls.add("Zehra");

        // index item
        System.out.println( ls.get(0) );
        ls.add("Kemal");

        // delete item
        ls.remove(1);

        // add item for index
        ls.add(1, "Serkan");

        // eleman  sayısı - size
        int size = ls.size();
        System.out.println(size);

        // loop
        for (int i = 0; i < ls.size(); i++) {
            String item = ls.get(i);
            System.out.println(item);
        }

        // forEach
        for ( String item : ls ) {
            System.out.println( "item " + item );
        }

        // clear - all item delete
        // ls.clear();

        boolean deleteStatus = ls.remove("Serkan");
        if ( deleteStatus ) {
            System.out.println("Delete Success");
        }

        // indexOf -> item value index
        int index = ls.indexOf("Zehra");
        if( index > -1 ) {
            System.out.println( "Index Success: " + index );
        }

        // contains -> item true, false
        boolean status = ls.contains("Kemal");
        if ( status ) {
            System.out.println("Kemal Success");
        }

        //  set -> change item value
        String change = ls.set(1, "Nihal");
        System.out.println( change );

        // List to Array
        Object[] arr = ls.toArray();

        // Sorted
        Collections.sort(ls);
        Collections.reverse(ls);

        // tüm elemanları yazdırma
        System.out.println( ls );

    }
}
