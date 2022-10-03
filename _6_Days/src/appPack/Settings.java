package appPack;

public class Settings implements IUser {

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
}
