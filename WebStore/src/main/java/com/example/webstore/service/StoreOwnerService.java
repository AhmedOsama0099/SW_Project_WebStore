package com.example.webstore.service;

import com.example.webstore.dao.StoreOwner.StoreOwnerDao;
import com.example.webstore.model.StoreOwner;
import com.example.webstore.model.User;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class StoreOwnerService{
    @Resource
    StoreOwnerDao storeOwnerDao;

    public List<User> findAll() {
        return storeOwnerDao.findAll();
    }

    public void insertStoreOwner(StoreOwner user) {
        storeOwnerDao.insertStoreOwner(user);
    }

    public void updateStoreOwner(StoreOwner user) {
        storeOwnerDao.updateStoreOwner(user);
    }

    public void executeUpdateStoreOwner(StoreOwner user) {
        storeOwnerDao.executeUpdateStoreOwner(user);
    }

    public void deleteStoreOwner(StoreOwner user) {
        storeOwnerDao.deleteStoreOwner(user);
    }
}
