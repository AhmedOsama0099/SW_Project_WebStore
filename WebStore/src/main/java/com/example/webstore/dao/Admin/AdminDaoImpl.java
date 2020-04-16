package com.example.webstore.dao.Admin;

import com.example.webstore.dao.User.UserDaoImpl;
import com.example.webstore.dao.UserDaoCommon;
import com.example.webstore.mapper.AdminRowMapper;
import com.example.webstore.model.Admin;
import com.example.webstore.model.User;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;


@Repository
public class AdminDaoImpl implements AdminDao, UserDaoCommon {
    @Resource
    UserDaoImpl userDao;
    public AdminDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    NamedParameterJdbcTemplate template;

    @Override
    public List<Admin> findAll() {
        return template.query("SELECT *\n" +
                "FROM users\n" +
                "INNER JOIN admin\n" +
                "ON users.userName = admin.userName;", new AdminRowMapper());
    }


    /*@Override
    public void insertAdmin(Admin admin) {
        final String sql = "insert into admin(userName) values(:userName)";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("userName", admin.getUserName());

        template.update(sql, param, holder);
    }*/

    /* @Override
     public void updateAdmin(User admin) {
         final String sql = "update users set userName=:userName, email=:email, pw=:pw where userName=:userName";
         KeyHolder holder = new GeneratedKeyHolder();
         SqlParameterSource param = new MapSqlParameterSource()
                 .addValue("email", admin.getEmail())
                 .addValue("userName", admin.getUserName())
                 .addValue("pw", admin.getPw());
         template.update(sql, param, holder);
     }
     @Override
     public void deleteAdmin(User admin) {
         final String sql = "delete from users where userName=:userName";
         Map<String, Object> map = new HashMap<String, Object>();
         map.put("userName", admin.getUserName());
         template.execute(sql, map, new PreparedStatementCallback<Object>() {
             @Override
             public Object doInPreparedStatement(PreparedStatement ps)
                     throws SQLException, DataAccessException {
                 return ps.executeUpdate();
             }
         });
     }*/

    /*@Override
    public Admin loginAdmin(String userName, String pw) {
        List<Admin> admins = template.query("SELECT *\n" +
                "FROM users\n" +
                "INNER JOIN admin\n" +
                "ON users.userName = admin.userName\n" +
                "where pw='" + pw + "' and admin.userName= '" + userName + "';", new AdminRowMapper());
        if (admins.size() == 0)
            return null;
        else
            return admins.get(0);
//        return admins.get(0);

    }*/

    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
        final String sql = "insert into admin(userName) values(:userName)";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("userName", user.getUserName());

        template.update(sql, param, holder);
    }
}
