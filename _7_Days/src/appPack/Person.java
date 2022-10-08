package appPack;

abstract public class Person {

    abstract int accountNumber();
    abstract String accountName();

    public int totalAmount() {
        if ( accountNumber() == 100 ) {
            return 1000000;
        }else if ( accountNumber() == 200 ) {
            return 2000000;
        }else {
            return 0;
        }
    }


}
