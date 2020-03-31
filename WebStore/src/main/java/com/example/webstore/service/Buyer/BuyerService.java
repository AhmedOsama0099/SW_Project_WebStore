package com.example.webstore.service.Buyer;

import com.example.webstore.model.Buyer;
import com.example.webstore.model.User;

import java.util.List;

public interface BuyerService {
    List<User> findAll();

    void insertEmployee(Buyer emp);

    void updateEmployee(Buyer emp);

    void executeUpdateEmployee(Buyer emp);

    void deleteEmployee(Buyer emp);
}
