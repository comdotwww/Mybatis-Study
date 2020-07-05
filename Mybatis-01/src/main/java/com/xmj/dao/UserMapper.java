package com.xmj.dao;

import com.xmj.pojo.User;

import java.util.List;

/**
 * @author XmJ
 */
public interface UserMapper {

    /**
     * 获取所有用户信息
     *
     * @return List<User>
     */
    List<User> getUserList();

    /**
     * 根据ID查询用户信息
     *
     * @param id
     * @return User
     */
    User getUserById(int id);

    /**
     * 添加用户
     *
     * @param user
     * @return int
     */
    int addUser(User user);

    /**
     * 修改用户信息
     *
     * @param user
     * @return int
     */
    int updateUser(User user);

    /**
     * 删除用户
     *
     * @param id
     * @return int
     */
    int deleteUser(int id);

}
