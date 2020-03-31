package com.example.webstore.mapper;

import com.example.webstore.model.Admin;
import com.example.webstore.model.Buyer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BuyerRowMapper implements RowMapper<Buyer> {

    @Override
    public Buyer mapRow(ResultSet resultSet, int i) throws SQLException {
        Buyer buyer = new Buyer();
        buyer.setUserName(resultSet.getString("userName"));
        buyer.setEmail(resultSet.getString("email"));
        buyer.setPw(resultSet.getString("pw"));
        return buyer;
    }
}
