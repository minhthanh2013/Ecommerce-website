package com.doan2.spring.dao.userinfo;

import com.doan2.spring.entity.UserInfo;

import java.util.List;

public interface UserInfoDAO {
     UserInfo findUserInfo(String userName);

    // [USER,AMIN,..]
     List<String> getUserRoles(String userName);
    int getLatestUserId();
    void addUserInfo(UserInfo userInfo);
}
