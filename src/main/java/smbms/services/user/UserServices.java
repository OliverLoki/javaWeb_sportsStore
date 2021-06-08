package smbms.services.user;

import smbms.pojo.User;

import java.util.List;

public interface UserServices {

    /**
     * 登录功能
     * @param username
     * @param userpassword
     * @return
     */
    public User login(String username,String userpassword);

    public int register();

    /**
     * 调用此方法返回一个List<User>集合
     * @return
     */
    public List<User> getAllUsers();
}
