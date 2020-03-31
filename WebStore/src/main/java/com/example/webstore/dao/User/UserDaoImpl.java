package com.example.webstore.dao.User;

import com.example.webstore.mapper.UserRowMapper;
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
public class UserDaoImpl implements UserDao {
    public UserDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    NamedParameterJdbcTemplate template;

    @Override
    public List<User> findAll() {
        return template.query("select * from users", new UserRowMapper());
    }

    @Override
    public void insertUser(User user) {
        final String sql = "insert into users(userName,email , pw) values(:userName,:email,:pw)";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("userName", user.getUserName())
                .addValue("email", user.getEmail())
                .addValue("pw", user.getPw());
        template.update(sql, param, holder);
    }

    @Override
    public void updateUser(User user) {
        final String sql = "update users set userName=:userName, email=:email, pw=:pw where userName=:userName";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("email", user.getEmail())
                .addValue("userName", user.getUserName())
                .addValue("pw", user.getPw());
        template.update(sql, param, holder);
    }

    @Override
    public void executeUpdateUser(User user) {
        final String sql = "update users set userName=:userName, email=:email, pw=:pw where userName=:userName";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("email", user.getEmail());
        map.put("userName", user.getUserName());
        map.put("pw", user.getPw());
        template.execute(sql, map, new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });
    }

    @Override
    public void deleteUser(User user) {
        final String sql = "delete from users where userName=:userName";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userName", user.getUserName());
        template.execute(sql, map, new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });
    }
}
