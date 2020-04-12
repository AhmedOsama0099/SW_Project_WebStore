package com.example.webstore.api;

import com.example.webstore.Exceptions.login.LoginUserNotFoundException;
import com.example.webstore.Exceptions.signUp.SignUpUserFoundException;
import com.example.webstore.model.Admin;
import com.example.webstore.model.User;
import com.example.webstore.service.AdminService;
import com.example.webstore.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/app")
public class AdminController {
    @Resource
    AdminService adminService;
    @Resource
    UserService userService;

    @PostMapping(value = "/createAdmin")
    public String addAdmin(@RequestBody Admin admin) {

        if (userService.getUserByUserName(admin.getUserName()) != null) {
            throw new SignUpUserFoundException();
        } else {
            userService.insertUser(admin);
            adminService.insertAdmin(admin);
            return "SignUp Successfully";
        }
    }

    @PostMapping(value = "/loginAdmin")
    public Admin loginAdmin(@RequestBody Admin admin) {
        Admin tmp = adminService.loginAdmin(admin.getUserName(), admin.getPw());
        if (tmp == null) {
            throw new LoginUserNotFoundException();
        }
        return tmp;
    }

    @GetMapping(value = "/adminList")
    public List<Admin> getAdmins() {
        return adminService.findAll();
    }

    @GetMapping(value = "/getAllUsersList")
    public List<User> getAllUsers() {
        return userService.findAll();
    }
    @RequestMapping("/hello")
    public String helloWorld(@RequestParam(value="name", defaultValue="World") String name) {
        return "Hello "+name+"!!";}
/*    @PutMapping(value = "/updateAdmin")
    public void updateAdmin(@RequestBody Admin admin) {
        adminService.updateAdmin(admin);
    }
    @DeleteMapping(value = "/deleteAdmin")
    public void deleteAdmin(@RequestBody Admin admin) {
        userService.deleteUser(admin);
    }*/
}
