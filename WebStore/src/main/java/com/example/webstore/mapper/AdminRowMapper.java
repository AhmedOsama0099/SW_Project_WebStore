package com.example.webstore.mapper;

import com.example.webstore.model.Admin;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminRowMapper implements RowMapper<Admin> {

    @Override
    public Admin mapRow(ResultSet resultSet, int i) throws SQLException {
        Admin admin = new Admin();
        admin.setUserName(resultSet.getString("userName"));
        admin.setEmail(resultSet.getString("email"));
        admin.setPw(resultSet.getString("pw"));
        return admin;
    }
}
