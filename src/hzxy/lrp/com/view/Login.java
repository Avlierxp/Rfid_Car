package hzxy.lrp.com.view;

import hzxy.lrp.com.mysql.MysqlUser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    private static JFrame login;
    private JPanel Login;
    private JTextField Login_username;
    private JPasswordField Login_password;
    private JButton Login_Button;
    private JButton Reg_Button;

    public Login() {
        Login_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = Login_username.getText();
                String password = Login_password.getText();
                if(username.isEmpty()||password.isEmpty()){
                    JOptionPane.showMessageDialog(null,"用户名或密码为空","警告",JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                int Login_flag = MysqlUser.Login("admin", username, password);
                if(Login_flag==1){
                    MainView mainView = new MainView();
                    mainView.MainView();
                    login.dispose();
                }
                else {
                    JOptionPane.showMessageDialog(null,"用户名或密码错误","警告",JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });
        Reg_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Reg reg = new Reg();
                reg.Reg();
                login.dispose();
            }
        });
    }

    public static void Login() {
        login = new JFrame("登录");
        login.setContentPane(new Login().Login);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setSize(300,300);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }
}
