package appPack;

public interface IUser {

    boolean login( String email, String password );
    String rememberPassword( int uid );
    String userName( int uid );

}
