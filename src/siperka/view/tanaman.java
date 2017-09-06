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
public class tanaman extends javax.swing.JFrame {

    /**
     * Creates new form tanaman
     */
    public tanaman() {
        initComponents();
    }
    
    public String getid_tanaman() {
        return id_tanaman.getText();
    }
    
    public void disableTombol() {
        ubah.setVisible(false);
        hapus.setVisible(false);
        tambah.setVisible(false);
        Nama_tanaman.setEditable(false);
        jenis_tanaman.setEditable(false);
        periode_tanaman.setEditable(false);
    }
    
    public String getnama_tanaman() {
        return Nama_tanaman.getText();
    }
    
    public String getjenis_tanaman() {
        return jenis_tanaman.getText();
    }
    
    public String getperiode_tanaman() {
        return periode_tanaman.getText();
    }
    
    public int getSelectedRow() {
        int baris = tabel.getSelectedRow();
        return baris;
    }
    
    public void setid_tanaman(String id_tanaman) {
        this.id_tanaman.setText(id_tanaman);
    }
    
    public void setnama_tanaman(String nama_tanaman) {
        this.Nama_tanaman.setText(nama_tanaman);
    }
    
    public void setjenis_tanaman(String jenis_tanaman) {
        this.jenis_tanaman.setText(jenis_tanaman);
    }
    
    public void setperiode_tanaman(String periode_tanaman) {
        this.periode_tanaman.setText(periode_tanaman);
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

    public void addButtonBack(MouseListener e) {
        mbalik1.addMouseListener(e);
    }

    public void addButtonLogin(MouseListener e) {
        jLabel2.addMouseListener(e);
    }
    
    public void disableEditAndDelete() {
        ubah.setEnabled(false);
        hapus.setEnabled(false);
    }
    
    public void clearInput() {
        id_tanaman.setText("");
        Nama_tanaman.setText("");
        jenis_tanaman.setText("");
        periode_tanaman.setText("");
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Nama_tanaman = new javax.swing.JTextField();
        jenis_tanaman = new javax.swing.JTextField();
        periode_tanaman = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        mbalik = new javax.swing.JLabel();
        mbalik1 = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        exit1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ubah = new javax.swing.JButton();
        tambah = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        id_tanaman = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setLocation(new java.awt.Point(333, 144));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(Nama_tanaman, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 110, -1));
        getContentPane().add(jenis_tanaman, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 110, -1));
        getContentPane().add(periode_tanaman, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 110, -1));

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

        mbalik1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/mbalik1.png"))); // NOI18N
        mbalik1.setText("jLabel3");
        mbalik1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mbalik1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mbalik1MouseClicked(evt);
            }
        });
        getContentPane().add(mbalik1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 80, 50));

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

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 3, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ID tanaman");
        jLabel3.setToolTipText("");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tempus Sans ITC", 3, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Nama tanaman");
        jLabel4.setToolTipText("");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 220, 110, -1));

        jLabel5.setFont(new java.awt.Font("Tempus Sans ITC", 3, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Jenis tanaman");
        jLabel5.setToolTipText("");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tempus Sans ITC", 3, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Per. tanaman");
        jLabel6.setToolTipText("");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        ubah.setText("Ubah");
        getContentPane().add(ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 420, 70, 30));

        tambah.setText("Tambah");
        getContentPane().add(tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 420, 80, 30));

        hapus.setText("Hapus");
        getContentPane().add(hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 420, 70, 30));
        getContentPane().add(id_tanaman, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 40, 20));

        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, 60, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/tanaman.png"))); // NOI18N
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
    private javax.swing.JTextField Nama_tanaman;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel exit1;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel id_tanaman;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jenis_tanaman;
    private javax.swing.JLabel mbalik;
    private javax.swing.JLabel mbalik1;
    private javax.swing.JTextField periode_tanaman;
    private javax.swing.JTable tabel;
    private javax.swing.JButton tambah;
    private javax.swing.JButton ubah;
    // End of variables declaration//GEN-END:variables
}
