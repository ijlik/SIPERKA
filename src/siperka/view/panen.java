/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siperka.view;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kariema
 */
public class panen extends javax.swing.JFrame {

    /**
     * Creates new form panen
     */
    public panen() {
        initComponents();
    }
    
 public String getIDpanen() {
        return IDpanen.getText();
    }

    public String gettgl_panen() {
        return tgl_panen.getText();
    }

    public String getjmlh_panen() {
        return jmlh_panen.getText();
    }

    public String getIDtanaman() {
        return IDtanaman.getText();
    }

    public String getIDsektor() {
        return IDsektor.getText();
    }

    public String getIDlahan() {
        return IDlahan.getText();
    }

    public int getSelectedRow() {
        int baris = tabel.getSelectedRow();
        return baris;
    }

    public void setIDlahan(String IDlahan) {
        this.IDlahan.setText(IDlahan);
    }

    public void setIDsektor(String IDsektor) {
        this.IDsektor.setText(IDsektor);
    }

    public void setIDtanaman(String IDtanaman) {
        this.IDtanaman.setText(IDtanaman);
    }

    public void settgl_panen(String tgl_panen) {
        this.tgl_panen.setText(tgl_panen);
    }

    public void setjmlh_panen(String jmlh_panen) {
        this.jmlh_panen.setText(jmlh_panen);
    }

    public void setIDpanen(String IDpanen) {
        this.IDpanen.setText(IDpanen);
    }

    public void addTableListener(MouseListener listener) {
        tabel.addMouseListener(listener);
    }

    public void addubahListener(ActionListener listener) {
        ubah.addActionListener(listener);
    }

    public void addtambahListener(ActionListener listener) {
        tambah.addActionListener(listener);
    }

    public void addhapusListener(ActionListener listener) {
        hapus.addActionListener(listener);
    }

    public void setTableModel(DefaultTableModel tm) {
        tabel.setModel(tm);
    }

    public void enableEditAndDelete() {
        ubah.setEnabled(true);
        hapus.setEnabled(true);
    }

    public void disableEditAndDelete() {
        ubah.setEnabled(false);
        hapus.setEnabled(false);
    }
     public void addButtonBack(MouseListener e) {
        mbalik1.addMouseListener(e);
    }
    public void addButtonLogin(MouseListener e) {
        jLabel2.addMouseListener(e);
    }

    public void clearInput() {
        IDlahan.setText("");
        IDpanen.setText("");
        IDtanaman.setText("");
        jmlh_panen.setText("");
        IDsektor.setText("");
        tgl_panen.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        IDlahan = new javax.swing.JTextField();
        IDtanaman = new javax.swing.JTextField();
        tgl_panen = new javax.swing.JTextField();
        jmlh_panen = new javax.swing.JTextField();
        IDsektor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        mbalik = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        exit1 = new javax.swing.JLabel();
        mbalik1 = new javax.swing.JLabel();
        hapus = new javax.swing.JButton();
        tambah = new javax.swing.JButton();
        ubah = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        IDpanen = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setLocation(new java.awt.Point(333, 144));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(IDlahan, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 110, -1));
        getContentPane().add(IDtanaman, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 110, -1));
        getContentPane().add(tgl_panen, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 110, -1));
        getContentPane().add(jmlh_panen, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 110, -1));
        getContentPane().add(IDsektor, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 110, -1));

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabel);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 470, 280));

        mbalik.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/mbalik.png"))); // NOI18N
        mbalik.setText("jLabel2");
        mbalik.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mbalik.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mbalikMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mbalikMouseExited(evt);
            }
        });
        getContentPane().add(mbalik, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 80, -1));

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/exit.png"))); // NOI18N
        exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitMouseExited(evt);
            }
        });
        getContentPane().add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, 30, 30));

        exit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/exit2.png"))); // NOI18N
        exit1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit1MouseClicked(evt);
            }
        });
        getContentPane().add(exit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, 30, 30));

        mbalik1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/mbalik1.png"))); // NOI18N
        mbalik1.setText("jLabel3");
        mbalik1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mbalik1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mbalik1MouseClicked(evt);
            }
        });
        getContentPane().add(mbalik1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 80, 50));

        hapus.setText("Hapus");
        getContentPane().add(hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 420, 70, 30));

        tambah.setText("Tambah");
        getContentPane().add(tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 420, 80, 30));

        ubah.setText("Ubah");
        getContentPane().add(ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 420, 70, 30));

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Tgl panen");
        jLabel3.setToolTipText("");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 220, 70, -1));

        jLabel4.setFont(new java.awt.Font("Tempus Sans ITC", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Jumlah panen");
        jLabel4.setToolTipText("");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tempus Sans ITC", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("ID tanaman");
        jLabel5.setToolTipText("");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 280, 90, -1));

        jLabel6.setFont(new java.awt.Font("Tempus Sans ITC", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("ID sektor");
        jLabel6.setToolTipText("");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 80, -1));

        jLabel7.setFont(new java.awt.Font("Tempus Sans ITC", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("ID lahan");
        jLabel7.setToolTipText("");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 80, -1));

        jLabel8.setFont(new java.awt.Font("Tempus Sans ITC", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("ID panen");
        jLabel8.setToolTipText("");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 70, -1));

        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 60, 20));
        getContentPane().add(IDpanen, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 194, 110, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/panen.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mbalikMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mbalikMouseEntered
mbalik.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_mbalikMouseEntered

    private void mbalikMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mbalikMouseExited
 mbalik.setVisible(true);          // TODO add your handling code here:
    }//GEN-LAST:event_mbalikMouseExited

    private void mbalik1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mbalik1MouseClicked
       // TODO add your handling code here:
    }//GEN-LAST:event_mbalik1MouseClicked

    private void exitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseEntered
        exit.setVisible(false);          // TODO add your handling code here:
    }//GEN-LAST:event_exitMouseEntered

    private void exitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseExited
        exit.setVisible(true);     // TODO add your handling code here:
    }//GEN-LAST:event_exitMouseExited

    private void exit1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit1MouseClicked
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_exit1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
       // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IDlahan;
    private javax.swing.JLabel IDpanen;
    private javax.swing.JTextField IDsektor;
    private javax.swing.JTextField IDtanaman;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel exit1;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jmlh_panen;
    private javax.swing.JLabel mbalik;
    private javax.swing.JLabel mbalik1;
    private javax.swing.JTable tabel;
    private javax.swing.JButton tambah;
    private javax.swing.JTextField tgl_panen;
    private javax.swing.JButton ubah;
    // End of variables declaration//GEN-END:variables
}
