package hzxy.lrp.com.view;

import hzxy.lrp.com.mysql.MysqlUser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reg {
    private static JFrame reg;
    private JPanel Reg;
    private JTextField Reg_username;
    private JPasswordField Reg_password;
    private JPasswordField Reg_repassword;
    private JButton Reg_Button;
    private JButton Back_Button;

    public Reg() {
        Reg_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usernameText = Reg_username.getText();
                String passwordText = Reg_password.getText();
                String repasswordText = Reg_repassword.getText();
                if(usernameText.isEmpty()||passwordText.isEmpty()||repasswordText.isEmpty()){
                    JOptionPane.showMessageDialog(null,"注册用户名或密码为空","警告",JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                else if(!passwordText.equals(repasswordText)){
                    JOptionPane.showMessageDialog(null,"两次输入密码不一致","警告",JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                int Regflag = MysqlUser.Reg("admin", usernameText, passwordText);
                if(Regflag==0)
                    JOptionPane.showMessageDialog(null,"注册成功","提示",JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null,"该账号已存在","提示",JOptionPane.INFORMATION_MESSAGE);
            }
        });
        Back_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login login = new Login();
                login.Login();
                reg.dispose();
            }
        });
    }

    public static void Reg() {
        reg = new JFrame("注册");
        reg.setContentPane(new Reg().Reg);
        reg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        reg.setSize(300,300);
        reg.setLocationRelativeTo(null);
        reg.setVisible(true);
    }
}
