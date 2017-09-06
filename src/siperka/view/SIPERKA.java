package SIPERKA.view;

import java.sql.SQLException;
import siperka.controll.User_controller;
import siperka.model.TukangKebun;
import siperka.model.Admin;

public class SIPERKA {

    public static void main(String[] args) throws SQLException {
        siperka.model.Admin adminLogin = new Admin();
        siperka.model.TukangKebun kebunLogin = new TukangKebun();
        siperka.view.login vLogin = new siperka.view.login();
        siperka.controll.User_controller Start = new User_controller(vLogin, adminLogin, kebunLogin);
    }
}
