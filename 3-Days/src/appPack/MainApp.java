package appPack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainApp {
    public static void main(String[] args) {

        // Hashmap
        HashMap<String, String> hm = new HashMap<>();

        // add item
        hm.put("name", "Asya");
        hm.put("name", "Kaan");
        hm.put("status", "true");
        hm.put("surname", "Bilmem");
        hm.put("email", "kaan@mail.com");
        hm.put("age", "30");

        // get item
        System.out.println( hm.get("email") );

        // remove
        hm.remove("status");

        // all keys
        Set<String> keys = hm.keySet();
        for( String key : keys ) {
            System.out.println( key + " - " + hm.get(key) );
        }

        // all keys and val
        Set<Map.Entry<String, String>> keyVal = hm.entrySet();
        System.out.println(keyVal);

        // forEach
        hm.forEach( (key, val) -> {
            System.out.println( key + " " + val.hashCode() );
        });

        // size
        System.out.println( hm.size() );

        System.out.println( hm );

        ArrayList<HashMap<String, String>> ls = new ArrayList<>();
        HashMap<String, String> m1 = new HashMap<>();
        m1.put("title", "m1");
        m1.put("size", "30");

        HashMap<String, String> m2 = new HashMap<>();
        m1.put("title", "m2");
        m1.put("size", "600");

        ls.add(m1);
        ls.add(m2);
    }
}
