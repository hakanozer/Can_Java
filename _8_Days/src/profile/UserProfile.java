package profile;

public class UserProfile {

     public String name = "Ali Bilmem";
     public static String city = "İstanbul";

     public void fileUsing( String path ) throws Exception {
          System.out.println("Path : " + path);
          if ( path.equals("a.txt") ) {
               throw new Exception("a.txt not found");
          }
     }

}
