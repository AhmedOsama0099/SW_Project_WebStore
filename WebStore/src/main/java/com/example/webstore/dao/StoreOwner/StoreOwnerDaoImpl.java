package com.example.webstore.dao.StoreOwner;

import com.example.webstore.mapper.BuyerRowMapper;
import com.example.webstore.mapper.StoreOwnerRowMapper;
import com.example.webstore.mapper.UserRowMapper;
import com.example.webstore.model.Buyer;
import com.example.webstore.model.StoreOwner;
import com.example.webstore.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StoreOwnerDaoImpl implements StoreOwnerDao{
    public StoreOwnerDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    NamedParameterJdbcTemplate template;

    @Override
    public List<StoreOwner> findAll() {
        return template.query("SELECT *\n" +
                "FROM users\n" +
                "INNER JOIN store_owner\n" +
                "ON users.userName = store_owner.userName;", new StoreOwnerRowMapper());
    }

    @Override
    public void insertStoreOwner(StoreOwner storeOwner) {
        final String sql = "insert into store_owner(userName) values(:userName)";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("userName", storeOwner.getUserName());

        template.update(sql, param, holder);

    }

    @Override
    public void updateStoreOwner(User storeOwner) {
        final String sql = "update users set userName=:userName, email=:email, pw=:pw where userName=:userName";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("email", storeOwner.getEmail())
                .addValue("userName", storeOwner.getUserName())
                .addValue("pw", storeOwner.getPw());
        template.update(sql, param, holder);

    }

    @Override
    public void executeUpdateStoreOwner(User storeOwner) {
        final String sql = "update users set userName=:userName, email=:email, pw=:pw where userName=:userName";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("email", storeOwner.getEmail());
        map.put("userName", storeOwner.getUserName());
        map.put("pw", storeOwner.getPw());
        template.execute(sql, map, new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });

    }

    @Override
    public void deleteStoreOwner(User storeOwner) {
        final String sql = "delete from users where userName=:userName";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userName", storeOwner.getUserName());
        template.execute(sql, map, new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });
    }

    @Override
    public StoreOwner loginStoreOwner(String userName, String pw) {
        List<StoreOwner> buyers = template.query("SELECT *\n" +
                "FROM users\n" +
                "INNER JOIN store_owner\n" +
                "ON users.userName = store_owner.userName\n" +
                "where pw='"+pw+"' and store_owner.userName= '"+userName+"';", new StoreOwnerRowMapper());
        if(buyers.size() == 0)
            return null;
        else
            return buyers.get(0);
    }
}
