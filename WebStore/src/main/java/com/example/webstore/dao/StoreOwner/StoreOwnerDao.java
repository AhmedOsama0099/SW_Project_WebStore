package com.example.webstore.dao.StoreOwner;

import com.example.webstore.model.StoreOwner;
import com.example.webstore.model.User;

import java.util.List;

public interface StoreOwnerDao {
    List<StoreOwner> findAll();
    void insertStoreOwner(StoreOwner storeOwner);
    void updateStoreOwner(User storeOwner);
    void executeUpdateStoreOwner(User storeOwner);
    public void deleteStoreOwner(User storeOwner);

    StoreOwner loginStoreOwner(String userName, String pw);
}
