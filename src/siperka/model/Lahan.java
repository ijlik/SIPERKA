package siperka.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class Lahan implements DataLahan {

    private koneksi conn;
    private DefaultTableModel tm;
    private String id_lahan;
    private String Nama_lahan;
    private String Luas_lahan;
    private String Ph_tanah;
    private String IDsektor;
    private String Nama_sektor;
    private int level;

    public Lahan() throws SQLException {
        this.conn = new koneksi();
        String header[] = {"ID lahan", "Nama Lahan", "Luas Lahan", "PH tanah", "ID sektor", "Nama Sektor"};
        tm = new DefaultTableModel(null, header);

    }

    public void setLevel(int n) {
        level = n;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public void setIDlahan(String id_lahan) {
        this.id_lahan = id_lahan;
    }

    public void setNama_lahan(String Nama_lahan) {
        this.Nama_lahan = Nama_lahan;
    }

    public void setLuas_lahan(String Luas_lahan) {
        this.Luas_lahan = Luas_lahan;
    }

    public void setPh_tanah(String Ph_tanah) {
        this.Ph_tanah = Ph_tanah;
    }

    public void setIDsektor(String IDsektor) {
        this.IDsektor = IDsektor;
    }

    public void setNama_sektor(String Nama_sektor) {
        this.Nama_sektor = Nama_sektor;
    }

    public DefaultTableModel getTableModel() throws SQLException {
        for (int i = tm.getRowCount() - 1; i >= 0; i--) {
            tm.removeRow(i);
        }
        String sql = "select * from lahan";
        ResultSet rs = conn.getResult(sql);
        int n = 1;
        while (rs.next()) {
            String kolom[] = new String[6];
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 1);
            }
            tm.addRow(kolom);
            n++;
        }
        return tm;
    }

    public void setSelectedRow(int baris) {
        this.id_lahan = tm.getValueAt(baris, 0).toString();
        this.Nama_lahan = tm.getValueAt(baris, 1).toString();
        this.Luas_lahan = tm.getValueAt(baris, 2).toString();
        this.Ph_tanah = tm.getValueAt(baris, 3).toString();
        this.IDsektor = tm.getValueAt(baris, 4).toString();
        this.Nama_sektor = tm.getValueAt(baris, 5).toString();
    }

    @Override
    public String getIDlahan() {
        return id_lahan;
    }

    public String getNama_lahan() {
        if (Nama_lahan.length() < 2) {
            return Nama_lahan = null;
        } else {
            return Nama_lahan;
        }
    }

    public String getLuas_lahan() {
        if (Integer.parseInt(Luas_lahan) < 2) {
            return Luas_lahan = null;
        } else {
            return Luas_lahan;
        }
    }

    public String getPh_tanah() {
        if (Integer.parseInt(Ph_tanah) < 2) {
            return Ph_tanah = null;
        } else {
            return Ph_tanah;
        }
    }

    public String getIDsektor() {
        return IDsektor;
    }

    public String getNama_sektor() {
        return Nama_sektor;
    }

    public void tambah() throws SQLException {

        String sql = "insert into lahan values (" + id_lahan + ",'" + Nama_lahan + "','" + Luas_lahan + "','" + Ph_tanah + "','" + IDsektor + "','" + Nama_sektor + "')";
        conn.execute(sql);
    }

    public void ubah() throws SQLException {
        String sql = "update lahan set id_lahan = '" + id_lahan + "', nama_lahan = '" + Nama_lahan + "',luas_lahan = '" + Luas_lahan + "', ph_tanah = '" + Ph_tanah + "', id_sektor = '" + IDsektor + "', nama_sektor = '" + Nama_sektor + "' where id_lahan =" + id_lahan;
        conn.execute(sql);
    }

    public void delete() throws SQLException {
        String sql = "delete from lahan where id_lahan = " + this.id_lahan;
        conn.execute(sql);

    }

}
