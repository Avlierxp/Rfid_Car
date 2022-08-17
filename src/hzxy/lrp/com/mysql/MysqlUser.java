package hzxy.lrp.com.mysql;

import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Vector;

public class MysqlUser {
    static Connection conn = null;
    static Statement stmt = null;
    private static int regflag;

    /**
     * jdbc的登录方法
     */
    public static void jdbcLogin(String url, String UserName, String password) {
        try {
            // 动态导入数据库的驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 获取数据库链接
            conn = DriverManager.getConnection(url, UserName, password);
            // ||||这里是数据库名字，用户名，密码
            // 创造SQL语句
            ResultSet rs = null;
            System.out.println("数据库连接成功");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 系统登录
     */
    public static int Login(String tableName, String username, String password ) {
        String getusername = null;
        String getpassword = null;
        ResultSet rs = null;
        try {
            String sql = "select * from " + tableName + " where username=" + "\""+username+"\"" + " and password=" + "\""+password+"\"";
            System.out.printf(sql);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                getusername = rs.getString("username");//第一列
                getpassword = rs.getString("password");//第二列
                if (getpassword.equals(password)&&getusername.equals(username)){
                    return 1;
                }
                }
            }
         catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 系统注册
     */
    public static int Reg(String tableName, String username, String password ) {
        String getusername = null;
        String getpassword = null;
        ResultSet rs = null;
        try {
            String sql = "select * from " + tableName + " where username=" + "\""+username+"\"" + " and password=" + "\""+password+"\"";
            System.out.printf(sql);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            regflag = 0;
            while (rs.next()) {
                getusername = rs.getString("username");//第一列
                getpassword = rs.getString("password");//第二列
                if (getpassword.equals(password)&&getusername.equals(username)){
                    regflag = 1;
                }
            }
            if(regflag==0){
            sql = "insert into " + tableName + " (username,password) values (" +"\""+username+"\""+","+"\""+password+"\""+")";
            System.out.printf(sql);
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        if(regflag==0)
            return 0;
        else
            return 1;
    }

        // 得到数据库表数据
        public static Vector getRows(int i){
            Vector rows = null;
            Vector columnHeads = null;
            ResultSet rs = null;
            try {
                if(i==1){
                    String sql = "select * from employee";
                    System.out.printf(sql);
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery(sql);
                }
                else if(i==2){
                    String sql = "select * from address";
                    System.out.printf(sql);
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery(sql);
                }
                else if(i==3){
                    String sql = "select * from rubbish";
                    System.out.printf(sql);
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery(sql);
                }
                else if(i==4){
                    String sql = "select * from rubbishname";
                    System.out.printf(sql);
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery(sql);
                }
                else if(i==5){
                    String sql = "select * from work_address";
                    System.out.printf(sql);
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery(sql);
                }
                else if(i==6){
                    String sql = "select * from work";
                    System.out.printf(sql);
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery(sql);
                }

                if(rs.wasNull())
                    JOptionPane.showMessageDialog(null, "结果集中无记录");

                rows = new Vector();

                ResultSetMetaData rsmd = rs.getMetaData();

                while(rs.next()){
                    rows.addElement(getNextRow(rs,rsmd,i));
                }

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                System.out.println("未成功打开数据库。");
                e.printStackTrace();
            }
            return rows;
        }

        // 得到数据库表头
        public static Vector getHead(int i){

            Vector columnHeads = null;
            ResultSet rs = null;
            try {

                if(i==1){
                    String sql = "select * from employee";
                    System.out.printf(sql);
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery(sql);
                }
                else if(i==2){
                    String sql = "select * from address";
                    System.out.printf(sql);
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery(sql);
                }
                else if(i==3){
                    String sql = "select * from rubbish";
                    System.out.printf(sql);
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery(sql);
                }
                else if(i==4){
                    String sql = "select * from rubbishname";
                    System.out.printf(sql);
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery(sql);
                }
                else if(i==5){
                    String sql = "select * from work_address";
                    System.out.printf(sql);
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery(sql);
                }
                else if(i==6){
                    String sql = "select * from work";
                    System.out.printf(sql);
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery(sql);
                }

                boolean moreRecords = rs.next();
                if(!moreRecords)
                    JOptionPane.showMessageDialog(null, "结果集中无记录");

                columnHeads = new Vector();
                ResultSetMetaData rsmd = rs.getMetaData();
                for(int j = 1; j <= rsmd.getColumnCount(); j++)
                    columnHeads.addElement(rsmd.getColumnName(j));

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                System.out.println("未成功打开数据库。");
                e.printStackTrace();
            }
            return columnHeads;
        }

        // 得到数据库中下一行数据
        private static Vector getNextRow(ResultSet rs,ResultSetMetaData rsmd,int i) throws SQLException{
            Vector currentRow = new Vector();
            if(i==6){
                for(int j = 1; j <= rsmd.getColumnCount(); j++){
                    if(j==5)
                        currentRow.addElement(getFormatDate5(rs.getTimestamp(j)));
                    else
                        currentRow.addElement(rs.getString(j));
                }
            }
            else{
                for(int j = 1; j <= rsmd.getColumnCount(); j++){
                    currentRow.addElement(rs.getString(j));
                }
            }
            return currentRow;
        }

    public static String getFormatDate5(Timestamp time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
                Locale.CHINESE);
        String str = "";
        Timestamp newTime = null;
        if (time != null){
            str = sdf.format(time);
        }
        return str;
    }

}
