package com.example.webstore.service.Buyer;

import java.util.List;

import javax.annotation.Resource;

import com.example.webstore.deo.Buyer.BuyerDao;
import com.example.webstore.model.Buyer;
import com.example.webstore.model.User;
import org.springframework.stereotype.Component;


@Component
public class BuyerServiceImpl implements BuyerService{
    @Resource
    BuyerDao buyerDao;
    @Override
    public List<User> findAll() {
        return buyerDao.findAll();
    }
    @Override
    public void insertEmployee(Buyer emp) {
        buyerDao.insertEmployee(emp);

    }
    @Override
    public void updateEmployee(Buyer buyer) {
        buyerDao.updateEmployee(buyer);

    }
    @Override
    public void executeUpdateEmployee(Buyer buyer) {
        buyerDao.executeUpdateEmployee(buyer);

    }

    @Override
    public void deleteEmployee(Buyer buyer) {
        buyerDao.deleteEmployee(buyer);

    }
}
