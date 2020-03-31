package com.example.webstore.service.User;

import java.util.List;

import javax.annotation.Resource;

import com.example.webstore.deo.User.UserDao;
import com.example.webstore.model.User;
import org.springframework.stereotype.Component;


@Component
public class UserServiceImpl implements UserService{
    @Resource
    UserDao employeeDao;
    @Override
    public List<User> findAll() {
        return employeeDao.findAll();
    }
    @Override
    public void insertEmployee(User emp) {
        employeeDao.insertEmployee(emp);

    }
    @Override
    public void updateEmployee(User emp) {
        employeeDao.updateEmployee(emp);

    }
    @Override
    public void executeUpdateEmployee(User emp) {
        employeeDao.executeUpdateEmployee(emp);

    }

    @Override
    public void deleteEmployee(User emp) {
        employeeDao.deleteEmployee(emp);

    }
}
