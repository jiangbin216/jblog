package com.jiang.jblog.service;


import com.jiang.jblog.vo.User;
import com.jiang.jblog.vo.UserInfo;

/**
* Created by jiang on 2017-04-11.
*/
public interface UserService {


    User loadUserByUsername(String username);

    UserInfo getUserInfo();

    void updateAvatar(String url, String username);

    void updatePassword(User user);

    void updateUserInfo(UserInfo userInfo);

    User getCurrentUser();
}
