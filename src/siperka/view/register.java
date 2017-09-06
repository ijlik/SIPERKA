/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siperka.view;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;

/**
 *
 * @author Kariema
 */
public class register extends javax.swing.JFrame {

    public register() {
        initComponents();
    }

    public int getSelectedRow() {
        int baris = tabel.getSelectedRow();
        return baris;
    }

    public String getidUser() {
        return idUser.getText();
    }

    public String getFirstname() {
        return firstname.getText();
    }

    public String getlastname() {
        return lastname.getText();
    }

    public String getusername() {
        return username.getText();
    }

    public String getpassword() {
        return password.getText();
    }

    public String getemail() {
        return email.getText();
    }

    public String getlevel() {
        return level.getText();
    }

    public void setidUser(String idUser) {
        this.idUser.setText(idUser);
    }

    public void setfirstname(String IDpembibitan) {
        this.firstname.setText(IDpembibitan);
    }

    public void setlastname(String IDpembibitan) {
        this.lastname.setText(IDpembibitan);
    }

    public void setusername(String IDpembibitan) {
        this.username.setText(IDpembibitan);
    }

    public void setpassword(String IDpembibitan) {
        this.password.setText(IDpembibitan);
    }

    public void setemail(String IDpembibitan) {
        this.email.setText(IDpembibitan);
    }

    public void setlevel(String IDpembibitan) {
        this.level.setText(IDpembibitan);
    }

    public void addTableListener(MouseListener listener) {
        tabel.addMouseListener(listener);
    }

    public void addubahListener(ActionListener listener) {
        ubah.addActionListener(listener);
    }

    public void addtambahListener(MouseListener listener) {
        tambah.addMouseListener(listener);
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

    public void clearInput() {
        idUser.setText("");
        firstname.setText("");
        lastname.setText("");
        username.setText("");
        password.setText("");
        email.setText("");
        level.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        regmurup = new javax.swing.JLabel();
        backmurup = new javax.swing.JLabel();
        backmati = new javax.swing.JLabel();
        tambah = new javax.swing.JLabel();
        firstname = new javax.swing.JTextField();
        lastname = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        level = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        ubah = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        idUser = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setLocation(new java.awt.Point(333, 144));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        regmurup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/register2.png"))); // NOI18N
        regmurup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                regmurupMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                regmurupMouseExited(evt);
            }
        });
        getContentPane().add(regmurup, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 330, -1, -1));

        backmurup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/back.png"))); // NOI18N
        backmurup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backmurup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backmurupMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backmurupMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backmurupMouseExited(evt);
            }
        });
        getContentPane().add(backmurup, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 400, -1, -1));

        backmati.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/back1.png"))); // NOI18N
        backmati.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backmati.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backmatiMouseClicked(evt);
            }
        });
        getContentPane().add(backmati, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 400, -1, -1));

        tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/register1.png"))); // NOI18N
        getContentPane().add(tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 330, -1, -1));
        getContentPane().add(firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 150, -1));
        getContentPane().add(lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, 150, -1));
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, 150, -1));
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, 150, -1));
        getContentPane().add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 150, -1));
        getContentPane().add(level, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 290, 150, -1));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 380, 290));

        ubah.setText("Ubah");
        getContentPane().add(ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 70, 30));

        hapus.setText("Hapus");
        getContentPane().add(hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 70, 30));

        idUser.setText("jLabel2");
        getContentPane().add(idUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 90, 40, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/register.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backmurupMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backmurupMouseEntered
        backmurup.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_backmurupMouseEntered

    private void backmurupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backmurupMouseClicked
        this.setVisible(false);
     //   new login().setVisible(true);
    }//GEN-LAST:event_backmurupMouseClicked

    private void backmurupMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backmurupMouseExited
        backmurup.setVisible(true);
    }//GEN-LAST:event_backmurupMouseExited

    private void backmatiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backmatiMouseClicked
        this.setVisible(false);
        try {
            siperka.view.V_jampit v = new siperka.view.V_jampit();
            siperka.model.Admin m = new siperka.model.Admin();
          //siperka.controll.jampit_controller c = new siperka.controll.jampit_controller(v, m);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_backmatiMouseClicked

    private void regmurupMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regmurupMouseEntered
        regmurup.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_regmurupMouseEntered

    private void regmurupMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regmurupMouseExited
        regmurup.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_regmurupMouseExited

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backmati;
    private javax.swing.JLabel backmurup;
    private javax.swing.JTextField email;
    private javax.swing.JTextField firstname;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel idUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lastname;
    private javax.swing.JTextField level;
    private javax.swing.JTextField password;
    private javax.swing.JLabel regmurup;
    private javax.swing.JTable tabel;
    private javax.swing.JLabel tambah;
    private javax.swing.JButton ubah;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
