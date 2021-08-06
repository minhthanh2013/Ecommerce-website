package com.doan2.spring.mapper;

import com.doan2.spring.entity.UserInfo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper  implements RowMapper<UserInfo> {


    @Override
    public UserInfo mapRow(ResultSet resultSet, int i) throws SQLException {
        String userName = resultSet.getString("username");
        String password = resultSet.getString("password");
        return new UserInfo(userName, password);

    }
}
