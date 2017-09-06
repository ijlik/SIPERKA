/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siperka.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class Panen implements Pembibitan {

    private koneksi conn;
    private DefaultTableModel tm;
    private String id_lahan;
    private String IDpanen;
    private String IDsektor;
    private String jmlh_panen;
    private String IDtanaman;
    private String tgl_panen;
    private int level;

    public Panen() throws SQLException {
        this.conn = new koneksi();
        String header[] = {"ID Panen", "Tgl panen", "Jumlah Panen", "ID tanaman", "ID sektor", "ID lahan"};
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

    public void setIDpanen(String IDpanen) {
        this.IDpanen = IDpanen;
    }

    public void setjmlh_panen(String jmlh_panen) {
        this.jmlh_panen = jmlh_panen;
    }

    @Override
    public void setIDsektor(String IDsektor) {
        this.IDsektor = IDsektor;
    }

    public void settgl_panen(String tgl_panen) {
        this.tgl_panen = tgl_panen;
    }

    public DefaultTableModel getTableModel() throws SQLException {
        for (int i = tm.getRowCount() - 1; i >= 0; i--) {
            tm.removeRow(i);
        }
        String sql = "select * from panen";
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
        this.IDpanen = tm.getValueAt(baris, 0).toString();
        this.tgl_panen = tm.getValueAt(baris, 1).toString();
        this.jmlh_panen = tm.getValueAt(baris, 2).toString();
        this.IDtanaman = tm.getValueAt(baris, 3).toString();
        this.IDsektor = tm.getValueAt(baris, 4).toString();
        this.id_lahan = tm.getValueAt(baris, 5).toString();
    }

    @Override
    public String getIDlahan() {
        return id_lahan;
    }

    public String getIDpanen() {
        return IDpanen;
    }

    public String gettgl_panen() {
        return tgl_panen;
    }

    public String getjmlh_panen() {
        return jmlh_panen;
    }

    @Override
    public String getIDsektor() {
        return IDsektor;
    }

    public void tambah() throws SQLException {

        String sql = "insert into panen values (" + IDpanen + ",'" + tgl_panen + "','" + jmlh_panen + "','" + IDtanaman + "','" + IDsektor + "','" + id_lahan + "')";
        conn.execute(sql);
    }

    public void ubah() throws SQLException {
        String sql = "update panen set id_panen = '" + IDpanen + "', tgl_panen = '" + tgl_panen + "', jumlah_panen = '" + jmlh_panen + "', id_tanaman = '" + IDtanaman + "', id_sektor = '" + IDsektor + "', id_lahan = '" + id_lahan + "' where id_panen =" + IDpanen;
        conn.execute(sql);
    }

    public void delete() throws SQLException {
        String sql = "delete from panen where id_panen = " + this.IDpanen;
        conn.execute(sql);

    }

    @Override
    public void setid_tanaman(String id_tanaman) {
        this.IDtanaman = id_tanaman;
    }

    @Override
    public void setNama_tanaman(String Nama_tanaman) {
    }

    @Override
    public String getid_tanaman() {
        return IDtanaman;
    }

    @Override
    public String getNama_tanaman() {
        return null;
    }

}
