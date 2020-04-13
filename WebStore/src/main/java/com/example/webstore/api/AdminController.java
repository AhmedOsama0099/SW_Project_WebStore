package com.example.webstore.api;

import com.example.webstore.Exceptions.login.LoginUserNotFoundException;
import com.example.webstore.Exceptions.signUp.SignUpUserFoundException;
import com.example.webstore.model.Admin;
import com.example.webstore.model.User;
import com.example.webstore.service.AdminService;
import com.example.webstore.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
        tmp.setToken(getJWTToken(tmp.getUserName()));
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
    public String helloWorld(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hello " + name + "!!";
    }

    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + (5 * 60 * 60) * 1000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
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
