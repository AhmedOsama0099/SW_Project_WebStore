package com.example.webstore.api;


import com.example.webstore.model.User;
import com.example.webstore.request.LoginRequest;
import com.example.webstore.request.SignupRequest;

import com.example.webstore.security.jwt.JwtResponse;
import com.example.webstore.security.jwt.JwtUtils;
import com.example.webstore.security.services.UserDetailsImpl;
import com.example.webstore.service.BuyerService;
import com.example.webstore.service.StoreOwnerService;
import com.example.webstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserService userService;
    @Autowired
    StoreOwnerService storeOwnerService;
    @Autowired
    BuyerService buyerService;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtUtils jwtUtils;


    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtResponse("Bearer " + jwt,
                userDetails.getUsername(),
                userDetails.getEmail()));
    }


    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
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
        if (signUpRequest.getRole().equals("admin"))
            return new ResponseEntity<>("u couldn't create admin", HttpStatus.BAD_REQUEST);
        if (!signUpRequest.getRole().equals("buyer") &&
                !signUpRequest.getRole().equals("StoreOwner")) {
            return new ResponseEntity<>("Error: " + signUpRequest.getRole() + " Not Found", HttpStatus.NOT_FOUND);
        }
        if (signUpRequest.getRole().equals("buyer")) {
            buyerService.insertUser(user);
        } else if (signUpRequest.getRole().equals("StoreOwner")) {
            storeOwnerService.insertUser(user);
        }
        return ResponseEntity.ok("User registered successfully!");
    }
}
