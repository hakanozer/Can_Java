package settings;

import profile.UserProfile;

public class UserSettings {

    String email = "ali@mail.com";
    private String surname = "Bilsin";

    public void call() {
        UserProfile userProfile = new UserProfile();
        System.out.println( userProfile.name );
        System.out.println( UserProfile.city );
    }


}
