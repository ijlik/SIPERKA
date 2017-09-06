package siperka.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class User {

    protected String username;
    protected String password;
    protected koneksi conn;
    protected int level;
    
    public User() throws SQLException{
        conn = new koneksi() ;
    }
    public void setUsername(String s) {
        this.username = s;
    }

    public void setPassword(String s) {
        this.password = s;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public abstract boolean cekLevel(String username, String password) throws SQLException;

    public abstract boolean cekLogin(String username, String password) throws SQLException;

}
