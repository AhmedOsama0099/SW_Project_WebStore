package com.example.webstore.service;

import com.example.webstore.dao.StoreOwner.StoreOwnerDao;
import com.example.webstore.dao.StoreOwner.StoreOwnerDaoImpl;
import com.example.webstore.model.Buyer;
import com.example.webstore.model.StoreOwner;
import com.example.webstore.model.User;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class StoreOwnerService implements CommonServiceInt{
    @Resource
    StoreOwnerDaoImpl storeOwnerDao;
    public List<StoreOwner> findAll() {
        return storeOwnerDao.findAll();
    }

   /* public StoreOwner loginStoreOwner(String userName, String pw) {
        return storeOwnerDao.loginStoreOwner(userName, pw);
    }*/
    @Override
    public void insertUser(User user) {
        storeOwnerDao.insertUser(user);
    }

    /*public void updateStoreOwner(StoreOwner user) {
        storeOwnerDao.updateStoreOwner(user);
    }


    public void deleteStoreOwner(StoreOwner user) {
        storeOwnerDao.deleteStoreOwner(user);
    }*/
}
