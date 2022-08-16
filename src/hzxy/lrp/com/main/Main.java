package hzxy.lrp.com.main;

import hzxy.lrp.com.mysql.MysqlUser;
import hzxy.lrp.com.view.Login;

public class Main {
    public static void main(String[] args) {
        MysqlUser.jdbcLogin("jdbc:mysql://183.56.198.63:3306/rfid_car","root","sfk53wy86...");
        Login login = new Login();
        login.Login();
    }
}
