package com.example.webstore.service;

import java.util.List;

import javax.annotation.Resource;

import com.example.webstore.dao.Buyer.BuyerDao;
import com.example.webstore.dao.Buyer.BuyerDaoImpl;
import com.example.webstore.model.Buyer;
import com.example.webstore.model.User;
import org.springframework.stereotype.Component;


@Component
public class BuyerService implements CommonServiceInt{

   @Resource
    BuyerDaoImpl buyerDao;

    public List<Buyer> findAll() {
        return buyerDao.findAll();
    }

    /*public Buyer loginBuyer(String userName, String pw) {
        return buyerDao.loginBuyer(userName, pw);
    }*/

    @Override
    public void insertUser(User user) {
        buyerDao.insertUser(user);
    }

   /* public void updateBuyer(Buyer buyer) {
        buyerDao.updateBuyer(buyer);
    }


    public void deleteBuyer(Buyer buyer) {
        buyerDao.deleteBuyer(buyer);
    }*/
}
