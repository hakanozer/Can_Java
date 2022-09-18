package appmain;

public class MainApp {

    public static void main(String[] args) {

        String ageString = "30";
        // type Cast
        int age = Integer.parseInt(ageString);
        //Float.parseFloat("");
        //Double.parseDouble("");
        int sum = age * 3;
        System.out.println( sum );

        byte num = 127;

        Object obj = "Can";
        obj = 100;
        obj = 10.5;
        System.out.println( obj );


        int num1 = 10;
        int num2  = 11;
        if ( num1 > 9 ) {
            System.out.println("num1 9'dan büyük");
        }else {
            System.out.println("num1 9'dan büyük değil");
        }

        // && ||
        if ( num1 == 10 && num2 > 11 && num1 > 9 ) {
            System.out.println("");
            System.out.println("");
        }else {

        }

        String oneLine = num1 == 10 ? "Eşit" : "Eşit Değil";
        System.out.println(oneLine);

        // for loop
        String[] cities = { "İstanbul", "İzmir", "Adana", "Samsun", "Ankara" };
        //System.out.println( cities[0] );
        //System.out.println( cities[1] );
        //System.out.println( cities[2] );

        int x = 0;
        // x++  = x = x + 1
        System.out.println(x++);
        System.out.println(x);
        System.out.println(++x);

        for( int i = 0; i < cities.length; i++ ) {
            System.out.println( cities[i] );
        }

    }

}
