package com.example.webstore.dao.User;

import com.example.webstore.dao.UserDaoCommon;
import com.example.webstore.mapper.AdminRowMapper;
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
import java.util.*;

@Repository
public class UserDaoImpl implements UserDao, UserDaoCommon {
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

    public String getUserRoles(String userName) {
        ArrayList<String> roles = new ArrayList<>();
        if (!template.query("SELECT *\n" +
                "FROM users\n" +
                "INNER JOIN admin\n" +
                "ON users.userName = admin.userName\n" +
                "where admin.userName= '" + userName + "';", new AdminRowMapper()).isEmpty())
            roles.add("admin");

        else if (!template.query("SELECT *\n" +
                "FROM users\n" +
                "INNER JOIN buyer\n" +
                "ON users.userName = buyer.userName\n" +
                "where buyer.userName= '" + userName + "';", new AdminRowMapper()).isEmpty())
            roles.add("buyer");
        else if (!template.query("SELECT *\n" +
                "FROM users\n" +
                "INNER JOIN store_owner\n" +
                "ON users.userName = store_owner.userName\n" +
                "where store_owner.userName= '" + userName + "';", new AdminRowMapper()).isEmpty())
            roles.add("store_owner");
        return roles.get(0);
    }

   /* @Override
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
    }*/

    @Override
    public User getUserByUserName(String userName) {
        List<User> users = template.query("select * from users where userName='" + userName + "'", new UserRowMapper());
        if (users.isEmpty()) return null;
        else return users.get(0);
    }

    public int getTableSize() {
        return template.query("select * from users", new UserRowMapper()).size();
    }
}
