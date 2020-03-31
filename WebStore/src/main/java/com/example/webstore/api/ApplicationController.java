package com.example.webstore.api;

import javax.annotation.Resource;

import com.example.webstore.model.User;
import com.example.webstore.service.User.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*@RestController
@RequestMapping("/app")
public class ApplicationController {
    @Resource
    UserService userService;

    @PostMapping(value = "/createUser")
    public void createUser(@RequestBody User emp) {
        userService.insertEmployee(emp);
    }
    @GetMapping(value = "/employeeList")
    public List<User> getUsers() {
        return userService.findAll();
    }
    @PutMapping(value = "/updateEmp")
    public void updateUser(@RequestBody User user) {
        userService.updateEmployee(user);
    }
    @PutMapping(value = "/executeUpdateEmp")
    public void executeUpdateEmployee(@RequestBody Employee emp) {
        employeeService.executeUpdateEmployee(emp);

    }

    @DeleteMapping(value = "/deleteEmpById")
    public void deleteEmployee(@RequestBody Employee emp) {
        employeeService.deleteEmployee(emp);

    }
}*/
