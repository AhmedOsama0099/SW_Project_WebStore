package com.example.webstore.api;

import com.example.webstore.Exceptions.login.LoginUserNotFoundException;
import com.example.webstore.Exceptions.signUp.SignUpUserFoundException;
import com.example.webstore.model.Admin;
import com.example.webstore.model.User;
import com.example.webstore.request.SignupRequest;
import com.example.webstore.service.AdminService;
import com.example.webstore.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
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
    @Autowired
    PasswordEncoder encoder;

    @PostMapping(value = "/createAdmin")
    @Secured("admin")
    public ResponseEntity<?> addAdmin(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userService.getUserByUserName(signUpRequest.getUsername()) != null) {
            return ResponseEntity
                    .badRequest()
                    .body("User Found before");
        }
        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));


        if (signUpRequest.getRole() == null) {
            return new ResponseEntity<>("Error: role shouldn't be null", HttpStatus.NOT_FOUND);
        }
        adminService.insertUser(user);
        return ResponseEntity.ok("User registered successfully!");
    }

    /*@PostMapping(value = "/loginAdmin")
    public Admin loginAdmin(@RequestBody Admin admin) {
        Admin tmp = adminService.loginAdmin(admin.getUserName(), admin.getPw());
        if (tmp == null) {
            throw new LoginUserNotFoundException();
        }
        //tmp.setToken(getJWTToken(tmp.getUserName()));
        return tmp;
    }*/

    @GetMapping(value = "/adminList")
    @Secured("admin")
    public List<Admin> getAdmins() {
        return adminService.findAll();
    }

    @GetMapping(value = "/getAllUsersList")
    @Secured("admin")
    public List<User> getAllUsers() {
        return userService.findAll();
    }



    /*private String getJWTToken(String username) {
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
    }*/

/*    @PutMapping(value = "/updateAdmin")
    public void updateAdmin(@RequestBody Admin admin) {
        adminService.updateAdmin(admin);
    }
    @DeleteMapping(value = "/deleteAdmin")
    public void deleteAdmin(@RequestBody Admin admin) {
        userService.deleteUser(admin);
    }*/
}