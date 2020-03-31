package com.example.webstore.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.webstore.model.User;
import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int arg1) throws SQLException {

        User user = new User();
        user.setUserName(rs.getString("userName"));
        user.setEmail(rs.getString("email"));
        user.setPw(rs.getString("pw"));
        return user;
    }

}