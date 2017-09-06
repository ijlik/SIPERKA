package siperka.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class Admin extends User {

    private DefaultTableModel tm;
    private String idUser;
    private String firstname;
    private String lastname;
    private String email;
    private String levell;

    public Admin() throws SQLException {
        super();
        this.conn = new koneksi();
        String header[] = {"ID User", "firtname", "lastname", "username", "password", "email", "level"};
        tm = new DefaultTableModel(null, header);

    }

    public void setLevel(int n) {
        level = n;
    }

    public int getLevel() {
        return level;
    }

    public void setidUser(String idUser) {
        this.idUser = idUser;
    }

    public void setfirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setlastname(String lastname) {
        this.lastname = lastname;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public void setlevell(String level) {
        this.levell = level;
    }

    public String getidUser() {
        return idUser;
    }

    public String getfirstname() {
        return firstname;
    }

    public String getlastname() {
        return lastname;
    }

    public String getusername() {
        return username;
    }

    public String getpassword() {
        return password;
    }

    public String getemail() {
        return email;
    }

    public String getlevell() {
        return levell;
    }

    public void setSelectedRow(int baris) {
        this.idUser = tm.getValueAt(baris, 0).toString();
        this.firstname = tm.getValueAt(baris, 1).toString();
        this.lastname = tm.getValueAt(baris, 2).toString();
        this.username = tm.getValueAt(baris, 3).toString();
        this.password = tm.getValueAt(baris, 4).toString();
        this.email = tm.getValueAt(baris, 5).toString();
        this.levell = tm.getValueAt(baris, 6).toString();

    }

    public DefaultTableModel getTableModel() throws SQLException {
        for (int i = tm.getRowCount() - 1; i >= 0; i--) {
            tm.removeRow(i);
        }
        String sql = "select * from login";
        ResultSet rs = conn.getResult(sql);
        int n = 1;
        while (rs.next()) {
            String kolom[] = new String[7];
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 1);
            }
            tm.addRow(kolom);
            n++;
        }
        return tm;
    }
    
    
    @Override
    public boolean cekLogin(String username, String password) throws SQLException {
        String sql = "select * from login where username = '" + username + "' and password = '" + password + "'";
        System.out.println(sql);
        ResultSet rs = conn.getResult(sql);
        System.out.println(rs.last());
        return rs.last();
    }

    public void tambah() throws SQLException {

        String sql = "insert into login values (" + idUser + ",'" + firstname + "','" + lastname + "','" + username + "','" + password + "','" + email + "','" + level + "')";
        conn.execute(sql);
    }

    public void ubah() throws SQLException {
        String sql = "update login set firstname = '" + firstname + "', lastname = '" + lastname + "', username = '" + username + "', password = '" + password + "', email = '" + email + "', level = '" + level + "' where id_user =" + idUser;
        conn.execute(sql);
    }

    public void delete() throws SQLException {
        String sql = "delete from login where id_user = " + this.idUser;
        conn.execute(sql);
    }

    @Override
    public boolean cekLevel(String username, String password) throws SQLException {
        String sql = "select * from login where username = '" + username + "' and password = '" + password + "'";
        ResultSet rs = conn.getResult(sql);
        rs.next();
        level = rs.getInt("level");
        return rs.getInt("level") == 1;
    }
}
