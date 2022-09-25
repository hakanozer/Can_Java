package appPack;

import java.util.ArrayList;
import java.util.Scanner;

public class SampleArrayList {
    public static void main(String[] args) {

        // premium users
        String[] users = {"ali", "can", "kaan"};


        // kullanıcı listeleri
        // kullancıdan isimleri alınır.
        // kullanıcı kendi ismini bu listede arar
        // kullanıcı adını arar ve varsa index değerini bulur.

        ArrayList<String> ls = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // sonsuz döngü
        for (;;) {
            System.out.println("Lütfen adınızı giriniz!, yada (x) ile bitiriniz!");
            String name = scanner.nextLine();
            if ( name.equalsIgnoreCase("x") ) {
                break;
            }else {
                String user = name.toLowerCase();
                boolean isPremium = false;
                for( String item : users ) {
                    if ( user.equalsIgnoreCase(item) ) {
                        isPremium = true;
                        break;
                    }
                }
                if ( isPremium ) {
                    ls.add(0, user);
                }else {
                    ls.add(user);
                }
            }
        }

        System.out.println("Aramak istediğiniz ismi giriniz!");
        String searchName = scanner.nextLine();
        int index = ls.indexOf(searchName.toLowerCase());
        if ( index > -1 ) {
            System.out.println("Toplam Kişi: " + ls.size() + " Bulunan Kişi Index: " + index);
        }else {
            System.out.println("Kişi Yok");
        }

    }
}
