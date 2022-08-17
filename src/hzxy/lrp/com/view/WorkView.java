package hzxy.lrp.com.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkView {
    private static JFrame workView;
    private JButton work_addressButton;
    private JButton work_Button;
    private JButton back_Button;
    private JPanel WorkView;

    public WorkView() {
        work_addressButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyFrame.MyFrame_show(5);
                workView.dispose();
            }
        });
        work_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyFrame.MyFrame_show(6);
                workView.dispose();
            }
        });
        back_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainView.MainView();
                workView.dispose();
            }
        });
    }

    public static void WorkView() {
        workView = new JFrame("调度管理");
        workView.setContentPane(new WorkView().WorkView);
        workView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        workView.setSize(300,300);
        workView.setLocationRelativeTo(null);
        workView.setVisible(true);
    }
}
