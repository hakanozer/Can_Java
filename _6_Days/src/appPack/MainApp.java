package appPack;

import java.util.*;

public class MainApp {
    public static void main(String[] args) {

        User user = new User();
        boolean status = user.login("ali@mail.com", "12345");
        String imagePath = user.imagePath(10);
        System.out.println( imagePath );

        IUser iUser = new User();
        IUser settings = new Settings();
        call(iUser);
        call(settings);

        Map<String, String> hm = new HashMap<>();
        Map<String, String> hmx = new LinkedHashMap<>();
        Map<String, String> hmy = new Hashtable<>();
        callMap(hm);
        callMap(hmx);
        callMap(hmy);

        List<String> ls = new ArrayList<>();

        // interface new class
        IUser iObj = new IUser() {
            @Override
            public boolean login(String email, String password) {
                return false;
            }

            @Override
            public String rememberPassword(int uid) {
                return null;
            }

            @Override
            public String userName(int uid) {
                return null;
            }
        };
        iObj.userName(10);


    }


    public static void call( IUser iUser ) {
        iUser.userName(100);
    }

    public static void callMap( Map map ) {
        System.out.println(map);
    }


}
