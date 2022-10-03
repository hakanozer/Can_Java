package appPack;

public class User implements IUser, IProfile {

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

    public String imagePath( int uid ) {
        return "userProfilePath";
    }

    @Override
    public boolean updateProfile(String name, String surname, String email, int uid) {
        return false;
    }

    @Override
    public boolean logout(int uid) {
        return false;
    }

}
