package com.example.webstore.dao.Buyer;

import com.example.webstore.model.Buyer;
import com.example.webstore.model.User;

import java.util.List;

public interface BuyerDao {
    //Buyer loginBuyer(String userName, String pw);

    List<Buyer> findAll();

    //void insertBuyer(String userName);

    // void updateBuyer(User buyer);


    //void deleteBuyer(User buyer);


}
