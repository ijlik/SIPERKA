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
import siperka.model.Admin;
import siperka.view.V_jampit;
import siperka.view.login;

public class User_controller {

    siperka.view.login vLogin;
    siperka.view.register regLogin;
    siperka.model.Admin adminLogin;
    siperka.model.TukangKebun kebunLogin;

    public User_controller(siperka.view.login view, siperka.model.Admin model, siperka.model.TukangKebun model2) {
        vLogin = view;
        adminLogin = model;
        kebunLogin = model2;
        vLogin.setVisible(true);
        vLogin.addLoginListener(new LoginListener());
    }

    public User_controller(siperka.view.register theView, siperka.model.Admin theModel) throws SQLException {
        this.adminLogin = theModel;
        this.regLogin = theView;
        this.regLogin.setVisible(true);
        this.regLogin.setTableModel(adminLogin.getTableModel());
        this.regLogin.addTableListener(new TableListener());
        this.regLogin.addtambahListener(new tambahListener());
        this.regLogin.addubahListener(new ubahListener());
        this.regLogin.addhapusListener(new hapusListener());

    }

    public User_controller(login v, Admin m) {
   }

    class TableListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            regLogin.enableEditAndDelete();
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

    class tambahListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            adminLogin.setidUser(regLogin.getidUser());
            adminLogin.setfirstname(regLogin.getFirstname());
            adminLogin.setlastname(regLogin.getlastname());
            adminLogin.setusername(regLogin.getusername());
            adminLogin.setpassword(regLogin.getpassword());
            adminLogin.setemail(regLogin.getemail());
            adminLogin.setlevell(regLogin.getlevel());

            try {
                if (regLogin.getidUser().equals("")) {
                    regLogin.setidUser(null);
                    adminLogin.tambah();
                } else {
                    adminLogin.setidUser((String) regLogin.getidUser());
                    adminLogin.ubah();
                }
                regLogin.clearInput();
                regLogin.setTableModel(adminLogin.getTableModel());
            } catch (SQLException ex) {
                Logger.getLogger(User_controller.class.getName()).log(Level.SEVERE, null, ex);
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

    class ubahListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            adminLogin.setSelectedRow(regLogin.getSelectedRow());
            regLogin.setidUser(adminLogin.getidUser());
            regLogin.setfirstname(adminLogin.getfirstname());
            regLogin.setlastname(adminLogin.getlastname());
            regLogin.setusername(adminLogin.getusername());
            regLogin.setpassword(adminLogin.getpassword());
            regLogin.setemail(adminLogin.getemail());
            regLogin.setlevel(adminLogin.getlevell());
            regLogin.disableEditAndDelete();
        }
    }

    class hapusListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            adminLogin.setSelectedRow(regLogin.getSelectedRow());
            try {
                adminLogin.delete();
                regLogin.disableEditAndDelete();
                regLogin.setTableModel(adminLogin.getTableModel());
            } catch (SQLException ex) {
                Logger.getLogger(User_controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    class LoginListener implements MouseListener {

        public LoginListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("oke");
            String username = vLogin.getUsername();
            String password = vLogin.getPassword();
            boolean aman = true;

            if (username.isEmpty() || password.isEmpty()) {
                vLogin.setMessages("Username and Password can't be null");
                aman = false;
            }
            if (aman) {
                try {
                    adminLogin.setUsername(MysqlRealScapeString(username));
                    adminLogin.setPassword(MysqlRealScapeString(password));
                    kebunLogin.setUsername(MysqlRealScapeString(username));
                    kebunLogin.setPassword(MysqlRealScapeString(password));

                    if (adminLogin.cekLogin(username, password)) {
                        if (kebunLogin.cekLevel(username, password)) {
                            siperka.view.kebun vv = new siperka.view.kebun();
                            siperka.model.TukangKebun mm = new siperka.model.TukangKebun();
                            siperka.controll.kebun_controller cc = new siperka.controll.kebun_controller(vv, mm);
                            mm.setLevel(kebunLogin.getLevel());
                            vLogin.setVisible(false);
                        } else if (adminLogin.cekLevel(username, password)) {
                            siperka.view.V_jampit v = new siperka.view.V_jampit();
                            siperka.model.Admin m = new siperka.model.Admin();
                            m.setLevel(adminLogin.getLevel());
                            siperka.controll.jampit_controller c = new siperka.controll.jampit_controller(v, m);
                            System.out.println("pas tombol login "+adminLogin.getLevel());
                            vLogin.setVisible(false);
                        } else {
                            System.out.println("lalala");
                        }
                    } else {
                        vLogin.setMessages("Username and Password doesn't match");
                    }
                } catch (SQLException ex) {
                    //Logger.getLogger(login_controller.class.getName()).log(Level.SEVERE, null, ex);
                }
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

    public String MysqlRealScapeString(String str) {
        String data = null;
        if (str != null && str.length() > 0) {
            str = str.replace("\\", "\\\\");
            str = str.replace("'", "\\'");
            str = str.replace("\0", "\\0");
            str = str.replace("\n", "\\n");
            str = str.replace("\r", "\\r");
            str = str.replace("\"", "\\\"");
            str = str.replace("\\x1a", "\\Z");
            str = str.replace(" OR ", " AND ");
            str = str.replace(" or ", " and ");
            data = str;
        }
        return data;
    }
}
