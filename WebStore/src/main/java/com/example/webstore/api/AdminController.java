package com.example.webstore.api;

import com.example.webstore.Exceptions.login.LoginUserNotFoundException;
import com.example.webstore.Exceptions.signUp.SignUpUserNotFoundException;
import com.example.webstore.model.Admin;
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
            throw new SignUpUserNotFoundException();
        } else {
            userService.insertUser(admin);
            adminService.insertAdmin(admin);
            return "SignUp Successfully";
        }
    }

    @GetMapping(path = "/loginAdmin/{userName}/{pw}")
    public Admin loginAdmin(@PathVariable("userName") String userName, @PathVariable("pw") String pw) {
        Admin admin = adminService.loginAdmin(userName, pw);
        if (admin == null) {
            throw new LoginUserNotFoundException();
        }
        return admin;
    }

    @GetMapping(value = "/adminList")
    public List<Admin> getAdmins() {
        return adminService.findAll();
    }

/*    @PutMapping(value = "/updateAdmin")
    public void updateAdmin(@RequestBody Admin admin) {
        adminService.updateAdmin(admin);
    }
    @DeleteMapping(value = "/deleteAdmin")
    public void deleteAdmin(@RequestBody Admin admin) {
        userService.deleteUser(admin);
    }*/
}
