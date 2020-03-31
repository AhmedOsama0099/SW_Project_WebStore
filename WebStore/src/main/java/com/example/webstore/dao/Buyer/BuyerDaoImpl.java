package com.example.webstore.dao.Buyer;

import com.example.webstore.mapper.UserRowMapper;
import com.example.webstore.model.Buyer;
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
public class BuyerDaoImpl implements BuyerDao {
    public BuyerDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    NamedParameterJdbcTemplate template;

    @Override
    public List<User> findAll() {
        return template.query("SELECT *\n" +
                "FROM users\n" +
                "INNER JOIN buyer\n" +
                "ON users.userName = buyer.userName;", new UserRowMapper());
    }

    @Override
    public void insertBuyer(Buyer buyer) {
        final String sql = "insert into buyer(userName) values(:userName)";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("userName", buyer.getUserName());

        template.update(sql, param, holder);

    }

    @Override
    public void updateBuyer(User buyer) {
        final String sql = "update users set userName=:userName, email=:email, pw=:pw where userName=:userName";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("email", buyer.getEmail())
                .addValue("userName", buyer.getUserName())
                .addValue("pw", buyer.getPw());
        template.update(sql, param, holder);
    }

    @Override
    public void executeUpdateBuyer(User buyer) {
        final String sql = "update users set userName=:userName, email=:email, pw=:pw where userName=:userName";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("email", buyer.getEmail());
        map.put("userName", buyer.getUserName());
        map.put("pw", buyer.getPw());
        template.execute(sql, map, new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });
    }

    @Override
    public void deleteBuyer(User buyer) {
        final String sql = "delete from users where userName=:userName";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userName", buyer.getUserName());
        template.execute(sql, map, new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });
    }
}
