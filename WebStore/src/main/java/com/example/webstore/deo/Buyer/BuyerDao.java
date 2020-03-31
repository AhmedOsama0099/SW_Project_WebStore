package com.example.webstore.deo.Buyer;

import com.example.webstore.model.Buyer;
import com.example.webstore.model.User;

import java.util.List;

public interface BuyerDao {
    List<User> findAll();
    void insertEmployee(Buyer user);
    void updateEmployee(User user);
    void executeUpdateEmployee(User user);
    public void deleteEmployee(User user);
}
