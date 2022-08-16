package hzxy.lrp.com.mysql;

import java.sql.*;

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

    /**
     * 删除goodsName对应的内容
     */
    public static void deleteData(String tableName, String goodsName) {
        int goodsid = searchID(tableName, goodsName);
        System.out.println(goodsid);
        if (goodsid != 0) {
            System.out.println("goodsName = '" + goodsName + "'已经找到，其id为" + goodsid);
            System.out.println("正在删除......");
            MysqlUser.deleteData(tableName, goodsid); //调用删除id的方法
        } else System.out.println("你要删除的 goodsName='" + goodsName + "'未找到，请检查是否输入有误");
    }

    /**
     * 功能：搜索goodsName是否存在，若存在则返回id,否则返回0
     */
    public static int searchID(String tableName, String goodsName) {
        int goodsid = 0;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM " + tableName;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                goodsid = rs.getInt(1);//第一列
                String getedName = rs.getString(2);//第二列
                getedName = getedName.trim();            //去掉空格
                if (goodsName.equals(getedName)) {
                    return goodsid;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 通过主键id来删除表内容，仅作为过程
     */
    public static void deleteData(String tableName, int id) {
        try {
            String sql = "DELETE FROM " + tableName + " WHERE id = " + id;
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("id为" + id + "的数据已删除");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询表的所有内容
     */
    public static void traversalData(String tableName) {
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM " + tableName;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            System.out.println();
            System.out.println("查询结果如下:");
            System.out.println("  id  -   goodsName   -   introduce   -   price");
            while (rs.next()) {
                String id = rs.getString(1);//第二列
                String goodsName = rs.getString(2);//第二列
                String introduce = rs.getString(3);//第三列
                String price = rs.getString(4);    //第四列
                System.out.println(id + "    -   " + goodsName + "    -   " + introduce + "   -   " + price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 查询单个商品的信息，若不存在则提示不存在
     */

    public static void selectData(String tableName, String goodsName) {
        ResultSet rs = null;
        try {
            if (MysqlUser.searchID(tableName, goodsName) == 0) {
                System.out.println("查无此物");
                return;
            }
            String sql = "SELECT * FROM " + tableName;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            System.out.println();
            System.out.println("查询结果如下:");
            System.out.println("  id  -   goodsName   -   introduce   -   price");
            while (rs.next()) {
                String id = rs.getString(1);//第二列
                String getedName = rs.getString(2);//第二列
                getedName = getedName.trim();            //去掉空格
                String introduce = rs.getString(3);//第三列
                String price = rs.getString(4);    //第四列
                if (goodsName.equals(getedName))
                    System.out.println(id + "    -   " + getedName + "    -   " + introduce + "   -   " + price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 重排序ID
     */
    public static void resort(String tableName) {
        try {
            String sql = "ALTER TABLE commodity_management_system DROP id";
            String sql2 = "ALTER TABLE commodity_management_system ADD id INT NOT NULL PRIMARY KEY auto_increment first";
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            stmt = conn.createStatement();
            stmt.executeUpdate(sql2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
