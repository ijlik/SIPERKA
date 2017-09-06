/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siperka.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import siperka.model.koneksi;

public class Pupuk implements Pembibitan {

    private koneksi conn;
    private DefaultTableModel tmm;
    private String IDpemupukan;
    private String tgl_pemupukan;
    private String Pupuk;
    private String Vol_pupuk;
    private String IDlahan;
    private String IDtanaman;
    private int level;
    private String status;

    public Pupuk() throws SQLException {
        this.conn = new koneksi();
        String header[] = {"ID Pemupukan", "Tgl pemupukan", "Pupuk", "Vol pupuk", "ID lahan", "ID tanaman", "status"};
        tmm = new DefaultTableModel(null, header);

    }

    public void setLevel(int n) {
        level = n;
    }

    public int getLevel() {
        return level;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setIDpemupukan(String IDpemupukan) {
        this.IDpemupukan = IDpemupukan;
    }

    public void settgl_pemupukan(String tgl_pemupukan) {
        this.tgl_pemupukan = tgl_pemupukan;
    }

    public void setPupuk(String Pupuk) {
        this.Pupuk = Pupuk;
    }

    public void setVol_pupuk(String Vol_pupuk) {
        this.Vol_pupuk = Vol_pupuk;
    }

    @Override
    public void setIDlahan(String IDlahan) {
        this.IDlahan = IDlahan;
    }

    public DefaultTableModel getTableModel() throws SQLException {
        for (int i = tmm.getRowCount() - 1; i >= 0; i--) {
            tmm.removeRow(i);
        }
        String sql = "select * from pupuk";
        ResultSet rs = conn.getResult(sql);
        while (rs.next()) {
            String kolom[] = new String[7];
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 1);
            }
            tmm.addRow(kolom);
        }
        return tmm;
    }

    public void setSelectedRow(int baris) {
        this.IDpemupukan = tmm.getValueAt(baris, 0).toString();
        this.tgl_pemupukan = tmm.getValueAt(baris, 1).toString();
        this.Pupuk = tmm.getValueAt(baris, 2).toString();
        this.Vol_pupuk = tmm.getValueAt(baris, 3).toString();
        this.IDlahan = tmm.getValueAt(baris, 4).toString();
        this.IDtanaman = tmm.getValueAt(baris, 5).toString();
        this.status = tmm.getValueAt(baris, 6).toString();
        System.out.println(IDpemupukan);
        System.out.println(tgl_pemupukan);
        System.out.println(Pupuk);
        System.out.println(Vol_pupuk);
        System.out.println(IDlahan);
        System.out.println(IDtanaman);
        System.out.println(status);
    }

    public String getIDpemupukan() {
        return IDpemupukan;
    }

    public String gettgl_pemupukan() {
        return tgl_pemupukan;
    }

    public String getVol_pupuk() {
        if (Integer.parseInt(Vol_pupuk) < 2) {
            return Vol_pupuk = null;
        } else {
            return Vol_pupuk;
        }
    }

    @Override
    public String getIDlahan() {
        return IDlahan;
    }

    public String getPupuk() {
        return Pupuk;
    }

    public String getStatus() {
        return status;
    }

    public void tambah() throws SQLException {

        String sql = "insert into pupuk values (" + IDpemupukan + ",'" + tgl_pemupukan + "','" + Pupuk + "','" + Vol_pupuk + "','" + IDlahan + "','" + IDtanaman + "', 'belum diproses')";
        conn.execute(sql);
    }

    public void ubah() throws SQLException {
        String sql = "update pupuk set id_pemupukan = '" + IDpemupukan + "', tgl_pemupukan = '" + tgl_pemupukan + "', pupuk = '" + Pupuk + "', vol_pupuk = '" + Vol_pupuk + "', id_lahan = '" + IDlahan + "', id_tanaman = '" + IDtanaman + "', status = '" + status + "' where id_pemupukan =" + IDpemupukan;
        conn.execute(sql);
    }

    public void ubah(String Status) throws SQLException {
        String sql = "update pupuk set status='" + Status + "' where id_pemupukan = " + IDpemupukan;
        System.out.println(sql);
        conn.execute(sql);
    }

    public void delete() throws SQLException {
        String sql = "delete from pupuk where id_pemupukan = " + this.IDpemupukan;
        conn.execute(sql);

    }

    @Override
    public void setIDsektor(String IDsektor) {
    }

    @Override
    public String getIDsektor() {
        return null;
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
