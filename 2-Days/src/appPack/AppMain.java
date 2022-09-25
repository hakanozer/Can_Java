package appPack;

public class AppMain {

    public static void main(String[] args) {
        Action action = new Action();
        action.noParams();
        System.out.println( action.name );

        action.concat("Ali", "Bilmem");

        int size = action.size("Can ve Java");
        System.out.println("Size : " + size);
        if  ( action.size("data infooo") > 10 ) {
            System.out.println("size > 10");
        }

        String[] cities = {"İstanbul", "İzmir", "Ankara", "Adana"};
        String data = action.arrConcat(cities);
        System.out.println( data );


        String a = action.space( "A", "B" );
        String b = action.space( "A", "B", "C" );
        String c = action.space( "A", "B", "C", "D" );
        String d = action.space( "A" );

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

        // overload
        int sm = action.sum(10,2,45);
        System.out.println(sm);

    }

}
