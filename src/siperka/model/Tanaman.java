/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siperka.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class Tanaman implements DataTanaman {

    private koneksi conn;
    private DefaultTableModel tm;
    private String id_tanaman;
    private String Nama_tanaman;
    private String jenis_tanaman;
    private String periode_tanaman;
    private int level;
    private String id_kondisi;
    private String kondisi_daun;
    private String kondisi_bunga;
    private String kondisi_pohon;

    public Tanaman() throws SQLException {
        this.conn = new koneksi();
        String header[] = {"ID tanaman", "Nama Tanaman", "Jenis Tanaman", "Periode Tanaman"};
        tm = new DefaultTableModel(null, header);

    }

    public Tanaman(String kondisi) throws SQLException {
        this.conn = new koneksi();
        String header[] = {"ID kondisi", "ID tanaman", "Kondisi Daun", "Kondisi Bunga", "Kondisi Pohon"};
        tm = new DefaultTableModel(null, header);

    }

    public void setLevel(int n) {
        level = n;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public void setid_tanaman(String id_tanaman) {
        this.id_tanaman = id_tanaman;
    }

    @Override
    public void setNama_tanaman(String Nama_tanaman) {
        this.Nama_tanaman = Nama_tanaman;
    }

    public void setjenis_tanaman(String jenis_tanaman) {
        this.jenis_tanaman = jenis_tanaman;
    }

    public void setperiode_tanaman(String periode_tanaman) {
        this.periode_tanaman = periode_tanaman;
    }
    public DefaultTableModel getTableModel() throws SQLException {
        for (int i = tm.getRowCount() - 1; i >= 0; i--) {
            tm.removeRow(i);
        }
        String sql = "select * from tanaman";
        ResultSet rs = conn.getResult(sql);
        int n = 1;
        while (rs.next()) {
            String kolom[] = new String[4];
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 1);
            }
            tm.addRow(kolom);
            n++;
        }
        return tm;
    }

    public void setSelectedRow(int baris) {
        this.id_tanaman = tm.getValueAt(baris, 0).toString();
        this.Nama_tanaman = tm.getValueAt(baris, 1).toString();
        this.jenis_tanaman = tm.getValueAt(baris, 2).toString();
        this.periode_tanaman = tm.getValueAt(baris, 3).toString();
    }

    @Override
    public String getid_tanaman() {
        return id_tanaman;
    }

    @Override
    public String getNama_tanaman() {
        return Nama_tanaman;
    }

    public String getjenis_tanaman() {
        return jenis_tanaman;
    }

    public String getperiode_tanaman() {
        return periode_tanaman;
    }

    public void tambah() throws SQLException {

        String sql = "insert into tanaman values (" + id_tanaman + ",'" + Nama_tanaman + "','" + jenis_tanaman + "','" + periode_tanaman + "')";
        conn.execute(sql);
    }

    public void ubah() throws SQLException {
        String sql = "update tanaman set id_tanaman = '" + id_tanaman + "', nama_tanaman = '" + Nama_tanaman + "', jenis_tanaman = '" + jenis_tanaman + "', periode_tanaman = '" + periode_tanaman + "' where id_tanaman =" + id_tanaman;
        conn.execute(sql);
    }

    public void delete() throws SQLException {
        String sql = "delete from tanaman where id_tanaman = " + this.id_tanaman;
        conn.execute(sql);

    }

    //-------kondisi------------
    public void setIDkondisi(String id_kondisi) {
        this.id_kondisi = id_kondisi;
    }

    public void setKondisiDaun(String kondisi_daun) {
        this.kondisi_daun = kondisi_daun;
    }

    public void setKondisiBunga(String kondisi_bunga) {
        this.kondisi_bunga = kondisi_bunga;
    }

    public void setKondisiPohon(String kondisi_pohon) {
        this.kondisi_pohon = kondisi_pohon;
    }
    public String getIDkondisi() {
        return id_kondisi;
    }
     public String getKondisiDaun() {
        return kondisi_daun;
    }
      public String getKondisiBunga() {
        return kondisi_bunga;
    }
        public String getKondisiPohon() {
        return kondisi_pohon;
    }

    public DefaultTableModel getTableModel(String kondisi) throws SQLException {
        for (int i = tm.getRowCount() - 1; i >= 0; i--) {
            tm.removeRow(i);
        }
        String sql = "select * from kondisi";
        ResultSet rs = conn.getResult(sql);
        int n = 1;
        while (rs.next()) {
            String kolom[] = new String[5];
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 1);
            }
            tm.addRow(kolom);
            n++;
        }
        return tm;
    }

    public void setSelectedRow(int baris, String kondisi) {
        this.id_kondisi = tm.getValueAt(baris, 0).toString();
        this.id_tanaman = tm.getValueAt(baris, 1).toString();
        this.kondisi_daun = tm.getValueAt(baris, 2).toString();
        this.kondisi_bunga = tm.getValueAt(baris, 3).toString();
        this.kondisi_pohon = tm.getValueAt(baris, 4).toString();
    }
    public void tambah(String kondisi) throws SQLException {

        String sql = "insert into kondisi values (" + id_kondisi + ",'" + id_tanaman + "','" + kondisi_daun + "','" + kondisi_bunga + "','" + kondisi_pohon + "')";
        conn.execute(sql);
    }

    public void ubah(String kondisi) throws SQLException {
        String sql = "update kondisi set id_kondisi = '" + id_kondisi + "', id_tanaman = '" + id_tanaman + "', kondisi_daun = '" + kondisi_daun + "', kondisi_bunga = '" + kondisi_bunga + "', kondisi_pohon = '" + kondisi_pohon + "' where id_kondisi = " + id_kondisi;
        conn.execute(sql);
    }

    public void delete(String kondisi) throws SQLException {
        String sql = "delete from kondisi where id_kondisi = " + this.id_kondisi;
        conn.execute(sql);

    }

}

    