package com.jiang.jblog.mapper;

import com.jiang.jblog.vo.User;
import com.jiang.jblog.vo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * FILE: com.jiang.jblog.mapper.UserMapper.java
 * AUTHOR: jiang
 * DATE: 2017/4/9
 * TIME: 10:20
 */
@Mapper
public interface UserMapper {
    /**
     * 获取用户凭证
     * @param username 账号
     * @return
     */
    User getUser(@Param("username") String username);

    /**
     * 获取所有的用户
     * @return
     */
    List<User> allUser();

    UserInfo getUserInfo();

    void updateAvatar(@Param("url") String url, @Param("username") String username);

    void updatePassword(User user);

    void updateUserInfo(UserInfo userInfo);
}
