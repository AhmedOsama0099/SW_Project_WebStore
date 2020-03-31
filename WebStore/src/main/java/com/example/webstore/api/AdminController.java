package com.example.webstore.api;

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
    public void addAdmin(@RequestBody Admin admin) {
        userService.insertUser(admin);
        adminService.insertAdmin(admin);
    }

    @GetMapping(path = "/getAdmin/{userName}")
    public Admin getAdmin(@PathVariable("userName") String userName, String pw){
        return adminService.getAdmin(userName,pw);
    }

    @GetMapping(value = "/adminList")
    public List<Admin> getAdmins() {
        return adminService.findAll();
    }

    @PutMapping(value = "/updateAdmin")
    public void updateAdmin(@RequestBody Admin admin) {
        adminService.updateAdmin(admin);
    }

    @PutMapping(value = "/executeUpdateAdmin")
    public void executeUpdateAdmin(@RequestBody Admin admin) {
        adminService.executeUpdateAdmin(admin);
    }

    @DeleteMapping(value = "/deleteAdmin")
    public void deleteAdmin(@RequestBody Admin admin) {
        userService.deleteUser(admin);
    }
}
