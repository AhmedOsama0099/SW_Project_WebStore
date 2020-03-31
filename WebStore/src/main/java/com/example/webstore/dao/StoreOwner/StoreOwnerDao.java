package com.example.webstore.dao.StoreOwner;

import com.example.webstore.model.StoreOwner;
import com.example.webstore.model.User;

import java.util.List;

public interface StoreOwnerDao {
    StoreOwner loginStoreOwner(String userName, String pw);

    List<StoreOwner> findAll();

    void insertStoreOwner(StoreOwner storeOwner);

    //void updateStoreOwner(User storeOwner);

    //void deleteStoreOwner(User storeOwner);

}
