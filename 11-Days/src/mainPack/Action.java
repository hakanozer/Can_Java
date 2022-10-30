package mainPack;

public class Action<T> {

    public void sum( T a, T b ) {
        if ( a instanceof Integer ) {
            Integer ca = (Integer) a;
            Integer cb = (Integer) b;
            int sm = ca + cb;
            System.out.println("Sum : " + sm);
        }
        System.out.println( a );
        System.out.println( b );
    }

}
