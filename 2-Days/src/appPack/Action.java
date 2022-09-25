package appPack;

public class Action {

    public String name = "Can";

    public void noParams() {
        System.out.println("noParams call");
    }

    public void concat( String name, String surname ) {
        String con = name + " " + surname;
        System.out.println( con );
    }

    public int size( String data ) {
        return data.length();
    }

    public String arrConcat( String[] arr ) {
        String data = "";
        for (int i = 0; i < arr.length; i++) {
            data += arr[i] + " ";
        }
        return data;
    }


    public String space( String... data ) {
        String concat = "";
        for (int i = 0; i < data.length; i++) {
            concat += data[i];
        }
        return concat;
    }

    // overload methods
    public int sum( int a, int b ) {
        return a + b;
    }

    public int sum( int a, int b, int c ) {
        return a * b * c;
    }


}
