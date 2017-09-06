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
import siperka.model.Bibit;
import siperka.model.TukangKebun;
import siperka.model.Admin;
import siperka.view.bibit;

public class bibit_controller {

    private bibit View;
    private Bibit Model;

    public bibit_controller(bibit View, Bibit Model) throws SQLException {
        this.View = View;
        System.out.println("yyyyyyy");
        this.Model = Model;
        if (this.Model.getLevel() == 2) {
            this.View.disableTombol();

        } else if (this.Model.getLevel() == 1) {
            this.View.disableStatus();
        }
        this.View.setVisible(true);
        this.View.setTableModel(this.Model.getTableModel());
        this.View.addTableListener(new TableListener());
        this.View.addtambahListener(new tambahListener());
        this.View.addubahListener(new ubahListener());
        this.View.addhapusListener(new hapusListener());
        this.View.addButtonBack(new ButtonBack());
        this.View.addButtonLogin(new ButtonLogin());
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
                Logger.getLogger(bibit_controller.class.getName()).log(Level.SEVERE, null, ex);
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

class ButtonBack implements MouseListener {

    public ButtonBack() {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Levelnya "+Model.getLevel());
        try {
            if (Model.getLevel() == 1) {
                siperka.view.V_jampit v = new siperka.view.V_jampit();
                siperka.model.Admin m = new Admin();
                siperka.controll.jampit_controller c = new siperka.controll.jampit_controller(v, m);
                m.setLevel(Model.getLevel());
            } else if (Model.getLevel() == 2) {
                siperka.view.kebun vv = new siperka.view.kebun();
                siperka.model.TukangKebun mm = new TukangKebun();
                siperka.controll.kebun_controller cc = new siperka.controll.kebun_controller(vv, mm);
                mm.setLevel(Model.getLevel());
            }
        } catch (SQLException ex) {
            Logger.getLogger(bibit_controller.class.getName()).log(Level.SEVERE, null, ex);
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

class TableListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(Model.getLevel());
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
        Model.setIDpembibitan(View.getIDpembibitan());
        Model.settgl_pembibitan(View.gettgl_pembibitan());
        //Model.setIDtanaman(View.getIDtanaman());
        Model.setNama_tanaman(View.getTanaman());
        Model.setIDlahan(View.getLahan());
        if (View.gettgl_pembibitan().equals("")) {
            JOptionPane.showMessageDialog(View, "Tanggal salah");
        } else {
            try {
                if (View.getIDpembibitan().equals("")) {
                    Model.setIDpembibitan(null);
                    Model.tambah();
                } else {
                    if (Model.getLevel() == 1) {
                        Model.setIDpembibitan(View.getIDpembibitan());
                        Model.ubah();
                    } else if (Model.getLevel() == 2) {
                        Model.setIDpembibitan(View.getIDpembibitan());
                        Model.ubah(View.getStatus());
                        System.out.println("lalalalalalala  ajsnajn "+View.getStatus());
                    }
                }
                View.setTableModel(Model.getTableModel());
                View.clearInput();
            } catch (SQLException ex) {
                Logger.getLogger(bibit_controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}

class ubahListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Model.setSelectedRow(View.getSelectedRow());
        View.setIDpembibitan(Model.getIDpembibitan());
        View.settgl_pembibitan(Model.gettgl_pembibitan());
//            View.setIDtanaman(Model.getIDtanaman());
        //            View.setNama_tanaman(Model.get());
//             View.setIDlahan(Model.getIDlahan());
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
            Logger.getLogger(bibit_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
}
