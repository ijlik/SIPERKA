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

public class gudang {
    
 private koneksi conn;
    private DefaultTableModel tm;
    private String id_panen;
    private String id_sektorgudang;
    private String tgl_masuk;
    private String tgl_keluar;
    private String vol_gudang;
    private int level;
    public gudang() throws SQLException {
        this.conn = new koneksi();
        String header[] = {"ID Panen", "ID sek. Gudang", "Tgl Masuk", "Tgl keluar", "Vol gudang"};
        tm = new DefaultTableModel(null, header);

    }
    
 public void setLevel(int n) {
     level = n;
    }

    public int getLevel() {
        return level;
    }
    public void setid_panen(String id_panen) {
        this.id_panen = id_panen;
    }

    public void setid_sektorgudang(String id_sektorgudang) {
        this.id_sektorgudang = id_sektorgudang;
    }

    public void settgl_masuk(String tgl_masuk) {
        this.tgl_masuk = tgl_masuk;
    }

    public void settgl_keluar(String tgl_keluar) {
        this.tgl_keluar = tgl_keluar;
    }

    public void setvol_gudang(String vol_gudang) {
        this.vol_gudang = vol_gudang;
    }

    public DefaultTableModel getTableModel() throws SQLException {
        for (int i = tm.getRowCount() - 1; i >= 0; i--) {
            tm.removeRow(i);
        }
        String sql = "select * from gudang";
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

    public void setSelectedRow(int baris) {
        this.id_panen = tm.getValueAt(baris, 0).toString();
        this.id_sektorgudang = tm.getValueAt(baris, 1).toString();
        this.tgl_masuk = tm.getValueAt(baris, 2).toString();
        this.tgl_keluar = tm.getValueAt(baris, 3).toString();
        this.vol_gudang = tm.getValueAt(baris, 4).toString();
           }

    public String getid_panen() {
        return id_panen;
    }

    public String getid_sektorgudang() {
            return id_sektorgudang;
        }  

    public String gettgl_masuk() {
            return tgl_masuk;
        }

    public String gettgl_keluar() {
            return tgl_keluar;
        }
    
    public String getvol_gudang() {
        return vol_gudang;
    }

    public void tambah() throws SQLException {

        String sql = "insert into gudang values ('" + id_panen + "', null,'" + tgl_masuk + "','" + tgl_keluar + "','" + vol_gudang + "')";
        System.out.println(sql);
        conn.execute(sql);
    }

    public void ubah() throws SQLException {
        String sql = "update gudang set id_panen = '" + id_panen + "', tgl_masuk = '" + tgl_masuk + "', tgl_keluar = '" + tgl_keluar + "', vol_gudang = '" + vol_gudang + "' where id_sektorgudang = " + id_sektorgudang;
        conn.execute(sql);
    }

    public void delete() throws SQLException {
        String sql = "delete from gudang where id_sektorgudang = " + this.id_sektorgudang;
        conn.execute(sql);

    }

}

