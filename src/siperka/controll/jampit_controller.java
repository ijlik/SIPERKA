/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siperka.controll;

import siperka.model.Admin;
import siperka.view.V_jampit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import siperka.model.TukangKebun;

public class jampit_controller {

    private V_jampit view;
    private Admin model;

    public jampit_controller(V_jampit v, Admin m) {
        this.view = v;
        this.model = m;
        this.view.setVisible(true);
        this.view.addButtonBibit(new ButtonBibit());
        this.view.addButtonPanen(new ButtonPanen());
        this.view.addButtonTanaman(new ButtonTanaman());
        this.view.addButtonPupuk(new ButtonPupuk());
        this.view.addButtonGudang(new ButtonGudang());
        this.view.addButtonLahan(new ButtonLahan());
        this.view.addButtonAddUser(new ButtonAddUser());
        this.view.addButtonKebun(new ButtonKebun());
        this.view.addButtonLogin(new ButtonLogin());

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
                view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(jampit_controller.class.getName()).log(Level.SEVERE, null, ex);
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

    class ButtonKebun implements MouseListener {

        public ButtonKebun() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                siperka.model.Tanaman m = new siperka.model.Tanaman("kondisi");
                siperka.view.kondisi v = new siperka.view.kondisi();
                siperka.controll.tanaman_controller c = new siperka.controll.tanaman_controller(v, m);
                m.setLevel(model.getLevel());
                v.disableTombol();
                view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(jampit_controller.class.getName()).log(Level.SEVERE, null, ex);
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

    class ButtonAddUser implements MouseListener {

        public ButtonAddUser() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("");
            siperka.model.Admin m = null;
            siperka.view.register v = new siperka.view.register();
            try {
                m = new siperka.model.Admin();
            } catch (SQLException ex) {
                System.err.println("model");
            }
            try {
                siperka.controll.User_controller c = new siperka.controll.User_controller(v, m);
                m.setLevel(model.getLevel());
                // TODO add your handling code here:
            } catch (SQLException ex) {
                System.err.println("Controller");
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

    class ButtonLahan implements MouseListener {

        public ButtonLahan() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                siperka.model.Lahan m = new siperka.model.Lahan();
                siperka.view.lahan v = new siperka.view.lahan();
                siperka.controll.lahan_controller c = new siperka.controll.lahan_controller(v, m);
                m.setLevel(model.getLevel());
                view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(jampit_controller.class.getName()).log(Level.SEVERE, null, ex);
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

    class ButtonGudang implements MouseListener {

        public ButtonGudang() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                siperka.model.gudang m = new siperka.model.gudang();
                siperka.view.V_gudang v = new siperka.view.V_gudang();
                siperka.controll.gudang_controller c = new siperka.controll.gudang_controller(v, m);
                m.setLevel(model.getLevel());
                view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(jampit_controller.class.getName()).log(Level.SEVERE, null, ex);
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

    class ButtonPupuk implements MouseListener {

        public ButtonPupuk() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                siperka.model.Pupuk m = new siperka.model.Pupuk();
                siperka.view.pupuk v = new siperka.view.pupuk();
                siperka.controll.pupuk_controller c = new siperka.controll.pupuk_controller(v, m);
                m.setLevel(model.getLevel());
                v.disableStatus();
                view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(jampit_controller.class.getName()).log(Level.SEVERE, null, ex);
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

    class ButtonTanaman implements MouseListener {

        public ButtonTanaman() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                siperka.model.Tanaman m = new siperka.model.Tanaman();
                siperka.view.tanaman v = new siperka.view.tanaman();
                siperka.controll.tanaman_controller c = new siperka.controll.tanaman_controller(v, m);
                m.setLevel(model.getLevel());
                view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(jampit_controller.class.getName()).log(Level.SEVERE, null, ex);
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

    class ButtonPanen implements MouseListener {

        public ButtonPanen() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                siperka.model.Panen m = new siperka.model.Panen();
                siperka.view.panen v = new siperka.view.panen();
                siperka.controll.panen_controller c = new siperka.controll.panen_controller(v, m);
                m.setLevel(model.getLevel());
                view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(jampit_controller.class.getName()).log(Level.SEVERE, null, ex);
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

    class ButtonBibit implements MouseListener {

        public ButtonBibit() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                siperka.model.Bibit m = new siperka.model.Bibit();
                siperka.view.bibit v = new siperka.view.bibit();
                siperka.controll.bibit_controller c = new siperka.controll.bibit_controller(v, m);
                v.disableStatus();
                m.setLevel(model.getLevel());
                view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(jampit_controller.class.getName()).log(Level.SEVERE, null, ex);
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
}
