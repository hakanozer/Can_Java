package appPack;

public class Customer extends Person {

    int number = 0;
    String name = "";

    public Customer( int number ) {
        this.number = number;
        System.out.println( "Customer Call" );
    }

    public Customer( int number, String can ) {
        this.number = number;
        name = can;
    }


    @Override
    int accountNumber() {
        return number;
    }

    @Override
    String accountName() {
        return null;
    }

}
