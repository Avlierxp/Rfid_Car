package hzxy.lrp.com.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView {
    private static JFrame mainview;
    private JPanel MainPanel;
    private JButton Employee_Button;
    private JButton Address_Button;
    private JButton Rubbish_Button;
    private JButton Work_Button;
    private JPanel CardPanel;
    private JTable Table_View;
    private JButton AddButton;
    private JButton ModButton;
    private JButton DelButton;
    private JButton ExitButton;

    public MainView() {
        Employee_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        Address_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        Rubbish_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        Work_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        AddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        ModButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        DelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        ExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login login = new Login();
                login.Login();
                mainview.dispose();
            }
        });
    }

    public static void MainView() {
        mainview = new JFrame("管理界面");
        mainview.setContentPane(new MainView().MainPanel);
        mainview.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainview.setSize(600,450);
        mainview.setLocationRelativeTo(null);
        mainview.setVisible(true);
    }
}
