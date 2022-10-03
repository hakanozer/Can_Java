package appPack;

public interface IProfile {

    boolean updateProfile( String name, String surname, String email, int uid );
    boolean logout( int uid );

}
