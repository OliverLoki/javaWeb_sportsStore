package smbms.services.user;

import smbms.dao.BaseDao;
import smbms.dao.user.UserDao;
import smbms.dao.user.UserDaoImpl;
import smbms.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * service层捕获异常，进行事务处理
 * 事务处理：调用不同dao的多个方法，必须使用同一个connection（connection作为参数传递）
 * 事务完成之后，需要在service层进行connection的关闭，在dao层关闭（PreparedStatement和ResultSet对象）
 */
public class UserServicesImpl implements UserServices {
    //本实现类中所有操作需要用到UserDao中方法，创建实现类对象
    private UserDao userDao;

    public UserServicesImpl() {
        userDao = new UserDaoImpl();
    }

    /**
     * 调用getUser方法，获得user对象并返回
     *
     * @param username
     * @param userpassword
     * @return
     */
    @Override
    public User login(String username, String userpassword) {
        Connection connection = null;
        User user = null;
        try {
            connection = BaseDao.getConnection();
            user = userDao.getUser(connection, username);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }

        return user;
    }

    @Override
    public int register() {
        return 0;
    }

    /**
     * @return
     */
    @Override
    public List<User> getAllUsers() {
        Connection connection = null;
        List<User> allUsers = null;
        try {
            connection = BaseDao.getConnection();
            allUsers =new ArrayList<>();
            if (connection!=null){
                allUsers = userDao.getAllUsers(connection);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return allUsers;
    }
}
