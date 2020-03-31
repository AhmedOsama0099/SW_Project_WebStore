package com.example.webstore.service;

import java.util.List;

import javax.annotation.Resource;

import com.example.webstore.dao.Buyer.BuyerDao;
import com.example.webstore.model.Buyer;
import com.example.webstore.model.User;
import org.springframework.stereotype.Component;


@Component
public class BuyerService {

    @Resource
    BuyerDao buyerDao;

    public List<Buyer> findAll() {
        return buyerDao.findAll();
    }

    public Buyer loginBuyer(String userName, String pw) {
        return buyerDao.loginBuyer(userName, pw);
    }

    public void insertBuyer(Buyer buyer) {
        buyerDao.insertBuyer(buyer);
    }

    public void updateBuyer(Buyer buyer) {
        buyerDao.updateBuyer(buyer);
    }

    public void executeUpdateBuyer(Buyer buyer) {
        buyerDao.executeUpdateBuyer(buyer);
    }

    public void deleteBuyer(Buyer buyer) {
        buyerDao.deleteBuyer(buyer);
    }
}
