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
import siperka.model.Lahan;
import siperka.model.TukangKebun;
import siperka.model.Admin;
import siperka.view.lahan;

public class lahan_controller {

    private lahan View;
    private Lahan Model;

    public lahan_controller(lahan View, Lahan Model) throws SQLException {
        this.View = View;
        this.Model = Model;
        this.View.setVisible(true);
        this.View.setTableModel(this.Model.getTableModel());
        this.View.addTableListener(new TableListener());
        this.View.addtambahListener(new tambahListener());
        this.View.addubahListener(new ubahListener());
        this.View.addhapusListener(new hapusListener());
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
                    Logger.getLogger(lahan_controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (Model.getLevel() == 2) {
                try {
                    siperka.view.kebun vv = new siperka.view.kebun();
                    siperka.model.TukangKebun mm = new siperka.model.TukangKebun();
                    siperka.controll.kebun_controller cc = new siperka.controll.kebun_controller(vv, mm);
                    mm.setLevel(Model.getLevel());
                } catch (SQLException ex) {
                    Logger.getLogger(lahan_controller.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(lahan_controller.class.getName()).log(Level.SEVERE, null, ex);
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
            Model.setIDlahan(View.getIDlahan());
            Model.setNama_lahan(View.getNama_lahan());
            Model.setLuas_lahan(View.getLuas_lahan());
            Model.setPh_tanah(View.getPh_tanah());
            Model.setIDsektor(View.getIDsektor());
            Model.setNama_sektor(View.getNama_sektor());

            try {
                if (View.getIDlahan().equals("")) {
                    Model.setIDlahan(null);
                    Model.tambah();
                } else {
                    Model.setIDlahan((String) View.getIDlahan());
                    Model.ubah();
                }
                View.clearInput();
                View.setTableModel(Model.getTableModel());
            } catch (SQLException ex) {
                Logger.getLogger(lahan_controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    class ubahListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Model.setSelectedRow(View.getSelectedRow());
            View.setIDlahan(Model.getIDlahan());
            View.setNama_lahan(Model.getNama_lahan());
            View.setLuas_lahan(Model.getLuas_lahan());
            View.setPh_tanah(Model.getPh_tanah());
            View.setIDsektor(Model.getIDsektor());
            View.setNama_sektor(Model.getNama_sektor());
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
                Logger.getLogger(lahan_controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
