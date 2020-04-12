package com.example.webstore.api;

import com.example.webstore.Exceptions.login.LoginUserNotFoundException;
import com.example.webstore.Exceptions.signUp.SignUpUserFoundException;
import com.example.webstore.model.StoreOwner;
import com.example.webstore.service.StoreOwnerService;
import com.example.webstore.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/app")
public class StoreOwnerController {
    @Resource
    StoreOwnerService storeOwnerService;
    @Resource
    UserService userService;

    @PostMapping(value = "/createStoreOwner")
    public String addStoreOwner(@RequestBody StoreOwner storeOwner) {
        if(userService.getUserByUserName(storeOwner.getUserName())!=null){
            throw new SignUpUserFoundException();
        }
        else{
            userService.insertUser(storeOwner);
            storeOwnerService.insertStoreOwner(storeOwner);
            return "SignUp Successfully";
        }
    }
    @PostMapping(path = "/loginStoreOwner")
    public StoreOwner loginStoreOwner(@RequestBody StoreOwner storeOwner){
        StoreOwner tmp=storeOwnerService.loginStoreOwner(storeOwner.getUserName(),storeOwner.getPw());
        if(tmp==null){
            throw new LoginUserNotFoundException();
        }
        return tmp;
    }

    @GetMapping(value = "/storeOwnerList")
    public List<StoreOwner> getStoreOwners() {
        return storeOwnerService.findAll();
    }

    /*@PutMapping(value = "/updateStoreOwner")
    public void updateStoreOwner(@RequestBody StoreOwner storeOwner) {
        storeOwnerService.updateStoreOwner(storeOwner);
    }
    @DeleteMapping(value = "/deleteStoreOwner")
    public void deleteStoreOwner(@RequestBody StoreOwner storeOwner) {
        userService.deleteUser(storeOwner);
    }*/
}
