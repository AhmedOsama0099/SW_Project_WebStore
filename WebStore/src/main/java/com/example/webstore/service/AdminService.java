package com.example.webstore.service;

import com.example.webstore.dao.Admin.AdminDao;
import com.example.webstore.model.Admin;
import com.example.webstore.model.User;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class AdminService {
    @Resource
    AdminDao adminDao;

    public Admin loginAdmin(String userName, String pw) {
        return adminDao.loginAdmin(userName, pw);
    }

    public List<Admin> findAll() {
        return adminDao.findAll();
    }

    public void insertAdmin(Admin admin) {
        adminDao.insertAdmin(admin);
    }

    /*public void updateAdmin(Admin admin) {
        adminDao.updateAdmin(admin);
    }

    public void deleteAdmin(Admin admin) {
        adminDao.deleteAdmin(admin);
    }*/
}
