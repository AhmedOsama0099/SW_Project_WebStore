package com.example.webstore.dao.Buyer;

import com.example.webstore.model.Buyer;
import com.example.webstore.model.User;

import java.util.List;

public interface BuyerDao {
    List<User> findAll();
    void insertBuyer(Buyer buyer);
    void updateBuyer(User buyer);
    void executeUpdateBuyer(User buyer);
    public void deleteBuyer(User buyer);
}