package hzxy.lrp.com.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import hzxy.lrp.com.mysql.MysqlUser;

public class MyFrame extends JFrame{

//    private final JButton que;
//    private final JTextField que_text;
    DefaultTableModel tableModel;		// 默认显示的表格
    JButton add,del,exit,save;		// 各处理按钮
    JTable table;		// 表格

    JPanel panelUP;	//增加信息的面板
    public static int frameflag;

    // 构造函数
    public MyFrame(int i){
        frameflag=i;
        this.setBounds(300, 200, 600, 450);		// 设置窗体大小
        this.setTitle("管理界面");		// 设置窗体名称
        this.setLayout(new BorderLayout());	// 设置窗体的布局方式

        // 新建各按钮组件
//        que = new JButton("查询");
//        que_text = new JTextField();
        add = new JButton("增加");
        del = new JButton("删除");
        save = new JButton("保存");
        exit = new JButton("返回");
//        que_text.setPreferredSize(new Dimension(100,30));

        panelUP = new JPanel();		// 新建按钮组件面板
        panelUP.setLayout(new FlowLayout(FlowLayout.LEFT));	// 设置面板的布局方式

        // 将各按钮组件依次添加到面板中
//        panelUP.add(que);
//        panelUP.add(que_text);
        panelUP.add(add);
        panelUP.add(del);
        panelUP.add(save);
        panelUP.add(exit);

        // 取得haha数据库的aa表的各行数据
        Vector rowData = MysqlUser.getRows(i);
        // 取得haha数据库的aa表的表头数据
        Vector columnNames = MysqlUser.getHead(i);


        // 新建表格
        tableModel = new DefaultTableModel(rowData,columnNames);
        table = new JTable(tableModel);

        JScrollPane s = new JScrollPane(table);

        // 将面板和表格分别添加到窗体中
        this.add(panelUP,BorderLayout.NORTH);
        this.add(s);

        // 事件处理
        MyEvent();

        this.setVisible(true);		// 显示窗体
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		 // 设置窗体可关闭
    }

    // 事件处理
    public void MyEvent(){

        // 增加
        add.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // 增加一行空白区域
                tableModel.addRow(new Vector());
            }

        });

//        que.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String text = que_text.getText();
//            }
//        });

        // 删除
        del.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                // 删除指定行
                int rowcount = table.getSelectedRow();
                if(rowcount >= 0){
                    tableModel.removeRow(rowcount);
                }
            }

        });

        /**
         * 保存
         * 我的解决办法是直接将aa表中的全部数据删除，
         * 将表格中的所有内容获取到,
         * 然后将表格数据重新写入aa表
         */
        save.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                int column = table.getColumnCount();		// 表格列数
                int row = table.getRowCount();		// 表格行数

                // value数组存放表格中的所有数据
                String[][] value = new String[row][column];

                for(int i = 0; i < row; i++){
                    for(int j = 0; j < column; j++){
                        value[i][j] = table.getValueAt(i,j).toString();
                    }
                }

                // 以下均为对数据库的操作
                String sql_url = "jdbc:mysql://183.56.198.63:3306/rfid_car";	//数据库路径（一般都是这样写），haha是数据库名称
                String name = "root";		//用户名
                String password = "sfk53wy86...";	//密码
                Connection conn;
                PreparedStatement preparedStatement = null;

                try {
                    Class.forName("com.mysql.jdbc.Driver");		//连接驱动
                    conn = DriverManager.getConnection(sql_url, name, password);	//连接数据库
                    if(!conn.isClosed())
                        System.out.println("成功连接数据库");
                    if(frameflag==1){
                        preparedStatement = conn.prepareStatement("delete from aa where true");
                        preparedStatement.executeUpdate();

                        for(int i = 0; i < row; i++){
                            preparedStatement = conn.prepareStatement("insert into aa values(" + Integer.parseInt(value[i][0]) + ",'" + value[i][1] + "')");
                            preparedStatement.executeUpdate();
                        }
                    }
                    else if(frameflag==2){
                        preparedStatement = conn.prepareStatement("delete from aa where true");
                        preparedStatement.executeUpdate();

                        for(int i = 0; i < row; i++){
                            preparedStatement = conn.prepareStatement("insert into aa values(" + Integer.parseInt(value[i][0]) + ",'" + value[i][1] + "')");
                            preparedStatement.executeUpdate();
                        }
                    }
                    else if(frameflag==3){
                        preparedStatement = conn.prepareStatement("delete from aa where true");
                        preparedStatement.executeUpdate();

                        for(int i = 0; i < row; i++){
                            preparedStatement = conn.prepareStatement("insert into aa values(" + Integer.parseInt(value[i][0]) + ",'" + value[i][1] + "')");
                            preparedStatement.executeUpdate();
                        }
                    }
                    else if(frameflag==4){
                        preparedStatement = conn.prepareStatement("delete from aa where true");
                        preparedStatement.executeUpdate();

                        for(int i = 0; i < row; i++){
                            preparedStatement = conn.prepareStatement("insert into aa values(" + Integer.parseInt(value[i][0]) + ",'" + value[i][1] + "')");
                            preparedStatement.executeUpdate();
                        }
                    }
                    else if(frameflag==5){
                        preparedStatement = conn.prepareStatement("delete from aa where true");
                        preparedStatement.executeUpdate();

                        for(int i = 0; i < row; i++){
                            preparedStatement = conn.prepareStatement("insert into aa values(" + Integer.parseInt(value[i][0]) + ",'" + value[i][1] + "')");
                            preparedStatement.executeUpdate();
                        }
                    }
                    else if(frameflag==6){
                        preparedStatement = conn.prepareStatement("delete from work where id");
                        preparedStatement.executeUpdate();

                        for(int i = 0; i < row; i++){
                            preparedStatement = conn.prepareStatement("insert into work values(" + Integer.parseInt(value[i][0]) + "," + Integer.parseInt(value[i][1])+ "," + Integer.parseInt(value[i][2])+ "," + Integer.parseInt(value[i][3])+ ",'" + MysqlUser.getFormatDate5(Timestamp.valueOf((value[i][4]))) + "')");
                            preparedStatement.executeUpdate();
                        }
                    }
                } catch (ClassNotFoundException e1) {
                    // TODO Auto-generated catch block
                    System.out.println("未成功加载驱动。");
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    System.out.println("未成功打开数据库。");
                    e1.printStackTrace();
                }
            }
        });

        // 退出
        exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                MainView.MainView();
                MyFrame.this.dispose();
            }

        });
    }

    // 主函数
    public static void MyFrame_show(int i){
        new MyFrame(i);
    }
}
