package appPack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainApp {
    public static void main(String[] args) {

        // Object ata class'tır
        Base base = new Base();
        base.hashCode();
        Object data = 10;
        data = "Can";
        data = true;
        data = new Base();

        List<String> ls = new ArrayList<>();
        Map<String, String> hm = new HashMap<>();

        Base a = new A();
        Base b = new B();
        Base c = new C();

        int sm = a.sum(60,99);
        System.out.println( "Sm : " + sm );

        System.out.println( call(a) );
        System.out.println( call(b) );
        System.out.println( call(c) );

    }

    // polimorfizm - çok biçimlilik
    public static String call( Base base ) {
        if ( base instanceof A ) {
            A convertA = (A) base;
            System.out.println( convertA.email() );
            return convertA.profileName();
        }
        return base.profileName();
    }


}
