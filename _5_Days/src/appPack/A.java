package appPack;

public class A extends Base {

    @Override
    public String profileName() {
        int sm = sum(55,44);
        return "A profileName Call: " + sm;
    }

    public String email() {
        super.profileName();
        return "ali@mail.com";
    }

    public String aCall() {
        return "";
    }

}
