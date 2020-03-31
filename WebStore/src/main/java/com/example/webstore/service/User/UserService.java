package com.example.webstore.service.User;

import java.util.List;

import com.example.webstore.model.User;

public interface UserService {
    List<User> findAll();

    void insertEmployee(User emp);

    void updateEmployee(User emp);

    void executeUpdateEmployee(User emp);

    void deleteEmployee(User emp);

}
