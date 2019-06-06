package com.hjp.luban.aop;

/**
 * @auther huang jianping
 * @date 2019/6/6 14:41
 */
public class UserDaoImpl implements UserDao {

    @Override
    public void saveUser() {
        System.out.println("持久层：用户保存");
    }
}