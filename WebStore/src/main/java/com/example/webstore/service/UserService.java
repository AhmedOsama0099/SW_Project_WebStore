package com.example.webstore.service;

import java.util.List;

import javax.annotation.Resource;

import com.example.webstore.dao.User.UserDao;
import com.example.webstore.dao.User.UserDaoImpl;
import com.example.webstore.model.User;
import org.springframework.stereotype.Component;


@Component
public class UserService implements CommonServiceInt {
    @Resource
    UserDaoImpl userDao;

    public List<User> findAll() {
        return userDao.findAll();
    }
    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    public User getUserByUserName(String userName) {
        return userDao.getUserByUserName(userName);
    }
    public int getTableSize(){return userDao.getTableSize();}
  /*  public void updateUser(User user) {
        userDao.updateUser(user);
    }
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }*/
}
