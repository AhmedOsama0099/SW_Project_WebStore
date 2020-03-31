package com.example.webstore.dao.Admin;

import com.example.webstore.model.Admin;
import com.example.webstore.model.User;

import java.util.List;

public interface AdminDao {
    List<Admin> findAll();

    Admin getAdmin(String userName, String pw);
    void insertAdmin(Admin admin);
    void updateAdmin(User admin);
    void executeUpdateAdmin(User admin);
    public void deleteAdmin(User admin);
}
