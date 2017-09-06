/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siperka.view;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import siperka.controll.pupuk_controller;
import siperka.model.Pupuk;

/**
 *
 * @author Kariema
 */
public class about extends javax.swing.JFrame {

    private about View;
    private Pupuk Model;
    private int level;

    public about() {
        initComponents();
    }
    public void setLevel(int n){
        level = n;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mbalik = new javax.swing.JLabel();
        mbalik1 = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        exit1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setLocation(new java.awt.Point(333, 144));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/about.png"))); // NOI18N
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
        if (level == 1) {
            try {
                siperka.view.V_jampit v = new siperka.view.V_jampit();
                siperka.model.Admin m = new siperka.model.Admin();
                siperka.controll.jampit_controller c = new siperka.controll.jampit_controller(v, m);
                m.setLevel(1);
            } catch (SQLException ex) {
                Logger.getLogger(pupuk_controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (level == 2) {
            try {
                siperka.view.kebun vv = new siperka.view.kebun();
                siperka.model.TukangKebun mm = new siperka.model.TukangKebun();
                siperka.controll.kebun_controller cc = new siperka.controll.kebun_controller(vv, mm);
                mm.setLevel(2);
            } catch (SQLException ex) {
                Logger.getLogger(pupuk_controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.setVisible(false);

    }//GEN-LAST:event_mbalik1MouseClicked

    private void exit1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit1MouseClicked
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_exit1MouseClicked

    private void exitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseEntered
        exit.setVisible(false);          // TODO add your handling code here:
    }//GEN-LAST:event_exitMouseEntered

    private void exitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseExited
        exit.setVisible(true);     // TODO add your handling code here:
    }//GEN-LAST:event_exitMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel exit;
    private javax.swing.JLabel exit1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel mbalik;
    private javax.swing.JLabel mbalik1;
    // End of variables declaration//GEN-END:variables
}
