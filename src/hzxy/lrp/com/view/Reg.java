package hzxy.lrp.com.view;

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
        reg = new JFrame("Reg");
        reg.setContentPane(new Reg().Reg);
        reg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        reg.setSize(300,300);
        reg.setLocationRelativeTo(null);
        reg.setVisible(true);
    }
}
