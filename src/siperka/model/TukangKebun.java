package siperka.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TukangKebun extends User {

    public TukangKebun() throws SQLException {
        super();
    }
     public void setLevel(int n) {
        level = n;
    }

    public int getLevel() {
        return level;
    }

    
    @Override
    public boolean cekLogin(String username, String password) throws SQLException {
      String sql = "select * from login where username = '" + username +"' and password = '" + password + "'";
        System.out.println(sql);
        ResultSet rs = conn.getResult(sql);
        System.out.println(rs.last());
        return rs.last();
    }

    @Override
    public boolean cekLevel(String username, String password) throws SQLException {
        String sql = "select * from login where username = '" + username +"' and password = '" + password + "'";
        ResultSet rs = conn.getResult(sql);
        rs.next();
        level = rs.getInt("level");
        return rs.getInt("level") == 2;
    }

}
