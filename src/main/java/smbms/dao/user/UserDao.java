package smbms.dao.user;

import smbms.pojo.User;

import java.sql.Connection;
import java.util.List;


/**
 * dao层抛出异常，让service层去捕获处理
 */
public interface UserDao {
    /**
     * 通过username获取User信息
     * @param connection
     * @param username
     * @return
     * @throws Exception
     */
    public User getUser(Connection connection, String username) throws Exception;

    /**
     * 调用此方法返回用户信息列表
     * @param connection
     * @return
     * @throws Exception
     */
    public List<User> getAllUsers(Connection connection) throws Exception;






}
