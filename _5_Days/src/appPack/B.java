package appPack;

public class B extends Base {

    @Override
    public String profileName() {
        int sm = sum(33,11);
        return  "B profileName Call: " + sm;
    }

}
