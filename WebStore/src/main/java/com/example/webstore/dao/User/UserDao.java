package com.example.webstore.dao.User;

import com.example.webstore.model.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    void insertUser(User user);
    void updateUser(User user);
    void executeUpdateUser(User user);
    public void deleteUser(User user);
}
