package appPack;

public class MainApp {
    public static void main(String[] args) {

        UserService service = new UserService();
        int status = service.userAdd("Erkan", "Bilsin", "erkan@mail.com", "12345");

        if ( status > 0 ) {
            System.out.println("Insert success");
        }else if ( status == 0 ) {
            System.out.println("Insert Error");
        }else if ( status == -1 ) {
            System.out.println("Duplicate entry for key mail");
        }

    }
}
