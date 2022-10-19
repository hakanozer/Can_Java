package appPack;

import java.sql.PreparedStatement;

public class UserService {

    // user Add
    public int userAdd( String name, String surname, String email, String password ) {
        DB db = new DB();
        int status = 0;
        try {
            String sql = "insert into user values( null, ?, ?, ?, ?, now() )";
            PreparedStatement pre = db.conn.prepareStatement(sql);
            pre.setString(1, name);
            pre.setString(2, surname);
            pre.setString(3, email);
            pre.setString(4, password);
            status = pre.executeUpdate();
        }catch (Exception ex) {
            if ( ex.toString().contains("SQLIntegrityConstraintViolationException") ) {
                status = -1;
            }
            System.err.println("Insert Error : " + ex);
        }finally {
            db.close();
        }
        return status;
    }

}
