package hzxy.lrp.com.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RubbishView {
    private static JFrame rubbishView;
    private JButton leixing_Button;
    private JButton lajitong_Button;
    private JButton back_Button;
    private JPanel RubbishView;

    public RubbishView() {
        leixing_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyFrame.MyFrame_show(4);
                rubbishView.dispose();
            }
        });
        lajitong_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyFrame.MyFrame_show(3);
                rubbishView.dispose();
            }
        });
        back_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainView.MainView();
                rubbishView.dispose();
            }
        });
    }

    public static void RubbishView() {
        rubbishView = new JFrame("垃圾桶管理");
        rubbishView.setContentPane(new RubbishView().RubbishView);
        rubbishView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rubbishView.setSize(300,300);
        rubbishView.setLocationRelativeTo(null);
        rubbishView.setVisible(true);
    }
}
