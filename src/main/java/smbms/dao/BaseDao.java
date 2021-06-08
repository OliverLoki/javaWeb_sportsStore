package smbms.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Collection;
import java.util.Properties;

/**
 * 操作数据库的基本类
 */
public class BaseDao {
    static {
        init();
    }

    private static String driver;
    private static String url;
    private static String user;
    private static String password;

    /**
     * 读取配置文件对数据库初始化，使用静态代码块在类加载前调用
     */
    public static void init() {
        InputStream resourceAsStream = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();

        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        user = properties.getProperty("user");
        password = properties.getProperty("password");
    }

    /**
     * 此方法获得一个connection连接
     *
     * @return
     */
    public static Connection getConnection() {
        //加载驱动
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //获取连接
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    /**
     * 查询操作
     * 获取service层统一的connection对象，补充预编译sql语句，返回结果集
     * @param connection
     * @param pstm
     * @param resultSet
     * @param sql
     * @param params
     * @return
     * @throws Exception
     */
    public static ResultSet execute(Connection connection, PreparedStatement pstm,ResultSet resultSet, String sql, Object[] params) throws Exception {
        //预编译SQL语句，返回一个PreparedStatement实例
        pstm = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            pstm.setObject(i+1,params[i]);
        }
        resultSet = pstm.executeQuery();
        return resultSet;
    }

    /**
     * 更新操作,返回受影响的行数
     * @param connection
     * @param pstm
     * @param sql
     * @param params
     * @return
     * @throws Exception
     */
    public static int executeUpdate(Connection connection, PreparedStatement pstm,
                                    String sql, Object[] params) throws Exception {
        int updateRows = 0;
        pstm = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            pstm.setObject(i + 1, params[i]);
        }
        updateRows = pstm.executeUpdate();
        return updateRows;
    }

    /**
     *
     * @param connection
     * @param pstm
     * @param rs
     * @return
     */
    public static boolean closeResource(Connection connection,PreparedStatement pstm,ResultSet rs){
        boolean flag = true;
        if(rs != null){
            try {
                rs.close();
                rs = null;//GC回收
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                flag = false;
            }
        }
        if(pstm != null){
            try {
                pstm.close();
                pstm = null;//GC回收
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                flag = false;
            }
        }
        if(connection != null){
            try {
                connection.close();
                connection = null;//GC回收
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                flag = false;
            }
        }

        return flag;

    }
}
