/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siperka.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class Bibit implements DataLahan, DataTanaman {

    private koneksi conn;
    private DefaultTableModel tm;
    private String id_lahan = null;
    private String tgl_pembibitan;
    private String IDtanaman = null;
    private String Nama_tanaman = null;
    private String IDpembibitan;
    private String status;
    private int level;

    public Bibit() throws SQLException {
        this.conn = new koneksi();
        String header[] = {"ID Pembibitan", "Tgl pembibitan", "Nama tanaman", "ID lahan", "Status"};
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

    public void setStatus(String status) {
        this.status = status;
    }

    public void settgl_pembibitan(String tgl_pembibitan) {
        this.tgl_pembibitan = tgl_pembibitan;
    }

    @Override
    public void setNama_tanaman(String Nama_tanaman) {
        this.Nama_tanaman = Nama_tanaman;
    }

    public void setIDpembibitan(String IDpembibitan) {
        this.IDpembibitan = IDpembibitan;
    }

    public String[] getTanaman() throws SQLException {
        String sql = "select nama_tanaman from tanaman";
        ResultSet rs = conn.getResult(sql);
        String tanaman = "";
        while (rs.next()) {
            tanaman += rs.getString("nama_tanaman") + "-";
        }
        return tanaman.split("-");
    }

    public String[] getLahan() throws SQLException {
        String sql = "select id_lahan from lahan";
        String lahan = "";
        ResultSet rs = conn.getResult(sql);
        while (rs.next()) {
            lahan += rs.getString("id_lahan") + "-";
        }
        System.out.println(lahan);
        return lahan.split("-");
    }

    public DefaultTableModel getTableModel() throws SQLException {
        for (int i = tm.getRowCount() - 1; i >= 0; i--) {
            tm.removeRow(i);
        }
        String sql = "select id_pembibitan, tgl_pembibitan, nama_tanaman, id_lahan, status from bibit";
        ResultSet rs = conn.getResult(sql);
        while (rs.next()) {
            String kolom[] = new String[5];
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = rs.getString(i + 1);
            }

            tm.addRow(kolom);
        }
        return tm;
    }

    public void setSelectedRow(int baris) {
        this.IDpembibitan = tm.getValueAt(baris, 0).toString();
        this.tgl_pembibitan = tm.getValueAt(baris, 1).toString();
        this.Nama_tanaman = tm.getValueAt(baris, 2).toString();
        this.id_lahan = tm.getValueAt(baris, 3).toString();
        this.status = tm.getValueAt(baris, 4).toString();

    }

    @Override
    public String getIDlahan() {
        return id_lahan;
    }

    public String getStatus() {
        return status;
    }

    public String gettgl_pembibitan() {
        return tgl_pembibitan;
    }

    public String getIDpembibitan() {
        return IDpembibitan;
    }

    public void tambah() throws SQLException {
        String sql = "insert into bibit values (" + IDpembibitan + ",'" + tgl_pembibitan + "','" + Nama_tanaman + "','" + id_lahan + "', (select id_tanaman from tanaman where nama_tanaman = '" + Nama_tanaman + "'), 'belum diproses')";
        System.out.println(sql);
        conn.execute(sql);
    }

    public void ubah() throws SQLException {
        String sql = "update bibit set tgl_pembibitan = '" + tgl_pembibitan + "', nama_tanaman = '" + Nama_tanaman + "', id_lahan = '" + id_lahan + "', status = '" + status + "' where id_pembibitan = " + IDpembibitan;
        System.out.println(sql);
        conn.execute(sql);
    }

    public void ubah(String Status) throws SQLException {
        String sql = "update bibit set status='" + Status + "' where id_pembibitan = " + IDpembibitan;
        System.out.println(sql);
        conn.execute(sql);
    }

    public void delete() throws SQLException {
        String sql = "delete from bibit where id_pembibitan = " + this.IDpembibitan;
        conn.execute(sql);

    }

    @Override
    public void setid_tanaman(String id_tanaman) {
        //nothing
    }

    @Override
    public String getid_tanaman() {
        //nothing
        return null;
    }

    @Override
    public String getNama_tanaman() {
        // nothing here
        return null;
    }

    @Override
    public void setIDsektor(String IDsektor) {
        // nothinhg
    }

    @Override
    public String getIDsektor() {
        // nothing
        return null;
    }

}
