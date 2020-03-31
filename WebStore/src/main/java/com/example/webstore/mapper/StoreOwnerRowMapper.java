package com.example.webstore.mapper;

import com.example.webstore.model.Buyer;
import com.example.webstore.model.StoreOwner;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StoreOwnerRowMapper implements RowMapper<StoreOwner> {

    @Override
    public StoreOwner mapRow(ResultSet resultSet, int i) throws SQLException {
        StoreOwner storeOwner = new StoreOwner();
        storeOwner.setUserName(resultSet.getString("userName"));
        storeOwner.setEmail(resultSet.getString("email"));
        storeOwner.setPw(resultSet.getString("pw"));
        return storeOwner;
    }
}
