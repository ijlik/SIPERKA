
package siperka.controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import siperka.model.Tanaman;
import siperka.model.TukangKebun;
import siperka.model.Admin;
import siperka.view.V_jampit;
import siperka.view.kondisi;
import siperka.view.tanaman;

public class tanaman_controller {

    private tanaman View;
    private kondisi KView;
    private Tanaman Model;

    public tanaman_controller(tanaman View, Tanaman Model) throws SQLException {
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
                    Logger.getLogger(tanaman_controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (Model.getLevel() == 2) {
                try {
                    siperka.view.kebun vv = new siperka.view.kebun();
                    siperka.model.TukangKebun mm = new siperka.model.TukangKebun();
                    siperka.controll.kebun_controller cc = new siperka.controll.kebun_controller(vv, mm);
                    mm.setLevel(Model.getLevel());
                } catch (SQLException ex) {
                    Logger.getLogger(tanaman_controller.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(tanaman_controller.class.getName()).log(Level.SEVERE, null, ex);
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

    class mbalik1Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new V_jampit().setVisible(true);  //To change body of generated methods, choose Tools | Templates.
            View.dispose();
        }

    }

    class tambahListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (View.getnama_tanaman().equals("") || View.getjenis_tanaman().equals("") || View.getperiode_tanaman().equals("")) {

            } else {
                Model.setid_tanaman(View.getid_tanaman());
                Model.setNama_tanaman(View.getnama_tanaman());
                Model.setjenis_tanaman(View.getjenis_tanaman());
                Model.setperiode_tanaman(View.getperiode_tanaman());

                try {
                    if (View.getid_tanaman().equals("")) {
                        Model.setid_tanaman(null);
                        Model.tambah();

                    } else {
                        Model.setid_tanaman((String) View.getid_tanaman());
                        Model.ubah();

                    }
                    View.clearInput();
                    View.setTableModel(Model.getTableModel());

                } catch (SQLException ex) {
                    Logger.getLogger(tanaman_controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    class ubahListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Model.setSelectedRow(View.getSelectedRow());
            View.setid_tanaman(Model.getid_tanaman());
            View.setnama_tanaman(Model.getNama_tanaman());
            View.setjenis_tanaman(Model.getjenis_tanaman());
            View.setperiode_tanaman(Model.getperiode_tanaman());
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
                Logger.getLogger(tanaman_controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    ////---------kondisi------------
 public tanaman_controller(kondisi KondisiView, Tanaman Model) throws SQLException {
        this.KView = KondisiView;
        this.Model = Model;
        this.KView.setVisible(true);
        this.KView.setTableModel(this.Model.getTableModel("kondisi"));
        this.KView.addTableListener(new TableListenerKondisi());
        this.KView.addtambahListener(new tambahListenerKondisi());
        this.KView.addubahListener(new ubahListenerKondisi());
        this.KView.addhapusListener(new hapusListenerKondisi());
        this.KView.addButtonBack(new ButtonbackKondisi());
        this.KView.addButtonLogin(new ButtonLoginKondisi());
    }

    class ButtonbackKondisi implements MouseListener {

        public ButtonbackKondisi() {
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
                    Logger.getLogger(tanaman_controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (Model.getLevel() == 2) {
                try {
                    siperka.view.kebun vv = new siperka.view.kebun();
                    siperka.model.TukangKebun mm = new siperka.model.TukangKebun();
                    siperka.controll.kebun_controller cc = new siperka.controll.kebun_controller(vv, mm);
                    mm.setLevel(Model.getLevel());
                } catch (SQLException ex) {
                    Logger.getLogger(tanaman_controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            KView.setVisible(false);
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

    class ButtonLoginKondisi implements MouseListener {

        public ButtonLoginKondisi() {
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
                Logger.getLogger(tanaman_controller.class.getName()).log(Level.SEVERE, null, ex);
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

    class TableListenerKondisi implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            KView.enableEditAndDelete();
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

    class tambahListenerKondisi implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Model.setIDkondisi(KView.getIDkondisi());
            Model.setid_tanaman(KView.getIDtanaman());
            Model.setKondisiDaun(KView.getKondisiDaun());
            Model.setKondisiBunga(KView.getKondisiBunga());
            Model.setKondisiPohon(KView.getKondisiPohon());

            try {
                if (KView.getIDkondisi().equals("")) {
                    Model.setIDkondisi(null);
                    Model.tambah("kondisi");
                } else {
                    Model.setIDkondisi((String) KView.getIDkondisi());
                    Model.ubah("kondisi");
                }
                KView.clearInput();
                KView.setTableModel(Model.getTableModel("kondisi"));
            } catch (SQLException ex) {
                Logger.getLogger(tanaman_controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    class ubahListenerKondisi implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Model.setSelectedRow(KView.getSelectedRow(), "kondisi");
            KView.setIDkondisi(Model.getIDkondisi());
            KView.setIDtanaman(Model.getid_tanaman());
            KView.setKondisiDaun(Model.getKondisiDaun());
            KView.setKondisiBunga(Model.getKondisiBunga());
            KView.setKondisiPohon(Model.getKondisiPohon());
            KView.disableEditAndDelete();
        }
    }

    class hapusListenerKondisi implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Model.setSelectedRow(KView.getSelectedRow(), "kondisi");
            try {
                Model.delete("kondisi");
                KView.disableEditAndDelete();
                KView.setTableModel(Model.getTableModel("kondisi"));
            } catch (SQLException ex) {
                Logger.getLogger(tanaman_controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

