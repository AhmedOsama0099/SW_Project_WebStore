package com.example.webstore.deo.User;

import com.example.webstore.model.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    void insertEmployee(User user);
    void updateEmployee(User user);
    void executeUpdateEmployee(User user);
    public void deleteEmployee(User user);
}
