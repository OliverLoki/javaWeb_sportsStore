package smbms.dao.user;

import smbms.dao.BaseDao;
import smbms.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDaoImpl implements UserDao {
    /**
     * 调用BaseDao中的excute方法，返回一个结果集并从中获取数据
     *
     * @param connection
     * @param username
     * @return
     * @throws Exception
     */
    @Override
    public User getUser(Connection connection, String username) throws Exception {
        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        User user = null;
        if (null != connection) {
            String sql = "select  * from user where username=?";
            Object[] params = {username};
            resultSet = BaseDao.execute(connection, pstm, resultSet, sql, params);
            if (resultSet.next()) {
                user = new User();
                user.setUid(resultSet.getInt("Uid"));
                user.setUsername(resultSet.getString("username"));
                user.setPwd(resultSet.getString("pwd"));
                user.setUname(resultSet.getString("Uname"));
            }
            BaseDao.closeResource(null, null, null);
        }

        return user;
    }

    /**
     * 返回一个List<User>集合
     * @param connection
     * @return
     * @throws Exception
     */
    @Override
    public List<User> getAllUsers(Connection connection) throws Exception {
        List<User> allUser = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet rs =null;
        User user = null;
        if(null!= connection){
            String sql = "select * from user";
            Object[] param = {};
            ResultSet resultSet = BaseDao.execute(connection, preparedStatement, rs, sql, param);
            while (resultSet.next()){
                user = new User();
                user.setUid(resultSet.getInt("Uid"));
                user.setUsername(resultSet.getString("username"));
                user.setPwd(resultSet.getString("pwd"));
                user.setUname(resultSet.getString("Uname"));
                allUser.add(user);
            }
        }
        return allUser;
    }


}