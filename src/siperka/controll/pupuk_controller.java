/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siperka.controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import siperka.model.Pupuk;
import siperka.model.TukangKebun;
import siperka.model.Admin;
import siperka.view.pupuk;

public class pupuk_controller {

    private pupuk View;
    private Pupuk Model;

    public pupuk_controller(pupuk V, Pupuk M) throws SQLException {
        View = V;
        Model = M;
        View.setVisible(true);
        View.setTableModel(Model.getTableModel());
        View.addTableListener(new TableListener());
        View.addtambahListener(new tambahListener());
        View.addubahListener(new ubahListener());
        View.addhapusListener(new hapusListener());
        this.View.addButtonBack(new ButtonBack());
        this.View.addButtonLogin(new ButtonLogin());
    }

    class ButtonBack implements MouseListener {

        public ButtonBack() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println(Model.getLevel());
            if (Model.getLevel() == 1) {
                try {
                    siperka.view.V_jampit v = new siperka.view.V_jampit();
                    siperka.model.Admin m = new siperka.model.Admin();
                    siperka.controll.jampit_controller c = new siperka.controll.jampit_controller(v, m);
                    m.setLevel(Model.getLevel());
                } catch (SQLException ex) {
                    Logger.getLogger(pupuk_controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (Model.getLevel() == 2) {
                try {
                    siperka.view.kebun vv = new siperka.view.kebun();
                    siperka.model.TukangKebun mm = new siperka.model.TukangKebun();
                    siperka.controll.kebun_controller cc = new siperka.controll.kebun_controller(vv, mm);
                    mm.setLevel(Model.getLevel());
                } catch (SQLException ex) {
                    Logger.getLogger(pupuk_controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            View.setVisible(false);
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    class ButtonLogin implements MouseListener {

        public ButtonLogin() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                siperka.model.Admin adminLogin = new Admin();
                siperka.model.TukangKebun kebunLogin = new TukangKebun();
                siperka.view.login vLogin = new siperka.view.login();
                siperka.controll.User_controller Start = new User_controller(vLogin, adminLogin, kebunLogin);
                View.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(pupuk_controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    class TableListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            View.enableEditAndDelete();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

    }

    class tambahListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Model.setIDpemupukan(View.getIDpemupukan());
            Model.settgl_pemupukan(View.gettgl_pemupukan());
            Model.setPupuk(View.getPupuk());
            Model.setVol_pupuk(View.getVol_pupuk());
            Model.setIDlahan(View.getIDlahan());
            Model.setid_tanaman(View.getIDtanaman());
            Model.setStatus(View.getStatus());

            try {
                if (View.getIDpemupukan().equals("")) {
                    Model.setIDpemupukan(null);
                    Model.tambah();
                } else {
                    if (Model.getLevel() == 1) {
                        Model.setIDpemupukan(View.getIDpemupukan());
                        Model.ubah();
                    } else if (Model.getLevel() == 2) {
                        Model.setIDpemupukan(View.getIDpemupukan());
                        Model.ubah(View.getStatus());
                        System.out.println(View.getStatus());
                    }
                }
                View.clearInput();
                View.setTableModel(Model.getTableModel());
            } catch (SQLException ex) {
                Logger.getLogger(pupuk_controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    class ubahListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Model.setSelectedRow(View.getSelectedRow());
            View.setIDlahan(Model.getIDlahan());
            View.setIDpemupukan(Model.getIDpemupukan());
            View.setPpupuk(Model.getPupuk());
            View.setVol_pupuk(Model.getVol_pupuk());
            View.settgl_pemupukan(Model.gettgl_pemupukan());
            View.setIDtanaman(Model.getid_tanaman());
            View.setStatus(Model.getStatus());
            View.disableEditAndDelete();
        }
    }

    class hapusListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Model.setSelectedRow(View.getSelectedRow());
            try {
                Model.delete();
                View.disableEditAndDelete();
                View.setTableModel(Model.getTableModel());
            } catch (SQLException ex) {
                Logger.getLogger(pupuk_controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
