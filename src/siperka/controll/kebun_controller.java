/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siperka.controll;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import siperka.model.Admin;
import siperka.model.TukangKebun;
import siperka.view.V_jampit;
import siperka.view.kebun;

/**
 *
 * @author Kariema
 */
public class kebun_controller {

    private kebun view;
    private TukangKebun model;

    public kebun_controller(kebun v, TukangKebun m) {
        this.view = v;
        this.model = m;
        this.view.setVisible(true);
        this.view.addButtonLogin(new ButtonLogin());
        this.view.addButtonPupuk(new ButtonPupuk());
        this.view.addButtonTanaman(new ButtonTanaman());
        this.view.addButtonBibit(new ButtonBibit());
        this.view.addButtonKondisi(new ButtonKondisi());

    }

    class ButtonKondisi implements MouseListener {

        public ButtonKondisi() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                siperka.model.Tanaman m = new siperka.model.Tanaman("kondisi");
                siperka.view.kondisi v = new siperka.view.kondisi();
                siperka.controll.tanaman_controller c = new siperka.controll.tanaman_controller(v, m);
                m.setLevel(model.getLevel());
                view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(kebun_controller.class.getName()).log(Level.SEVERE, null, ex);
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
                v.disableTombol();
                view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(kebun_controller.class.getName()).log(Level.SEVERE, null, ex);
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
                v.disableTombol();
                view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(kebun_controller.class.getName()).log(Level.SEVERE, null, ex);
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
                v.disableTombol();
                m.setLevel(model.getLevel());
                view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(kebun_controller.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(kebun_controller.class.getName()).log(Level.SEVERE, null, ex);
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
