package com.example.webstore.dao.Admin;

import com.example.webstore.model.Admin;
import com.example.webstore.model.User;

import java.util.List;

public interface AdminDao {
    //Admin loginAdmin(String userName, String pw);

    List<Admin> findAll();

    //void insertAdmin(Admin admin);

    //void updateAdmin(User admin);

    //void deleteAdmin(User admin);
}
