package hzxy.lrp.com.view;

import hzxy.lrp.com.mysql.MysqlUser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView {
    private static JFrame mainview;
    private JPanel MainView;
    private JButton ren_Button;
    private JButton dizhi_Button;
    private JButton lajitong_Button;
    private JButton diaodu_Button;
    private JButton back_Button;

    public static void MainView() {
        mainview = new JFrame("功能选择");
        mainview.setContentPane(new MainView().MainView);
        mainview.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainview.setSize(400,400);
        mainview.setLocationRelativeTo(null);
        mainview.setVisible(true);
    }

    public MainView() {
        ren_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyFrame.MyFrame_show(1);
                mainview.dispose();
            }
        });
        dizhi_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyFrame.MyFrame_show(2);
                mainview.dispose();
            }
        });
        lajitong_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RubbishView.RubbishView();
                mainview.dispose();
            }
        });
        diaodu_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WorkView.WorkView();
                mainview.dispose();
            }
        });


        back_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.Login();
                mainview.dispose();
            }
        });
    }
}
