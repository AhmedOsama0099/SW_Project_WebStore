package com.example.webstore.api;

import com.example.webstore.model.Buyer;
import com.example.webstore.model.StoreOwner;
import com.example.webstore.model.User;
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
    public void addStoreOwner(@RequestBody StoreOwner storeOwner) {
        userService.insertUser(storeOwner);
        storeOwnerService.insertStoreOwner(storeOwner);
    }
    @GetMapping(path = "/loginStoreOwner/{userName}/{pw}")
    public StoreOwner loginStoreOwner(@PathVariable("userName") String userName, @PathVariable("pw") String pw){
        return storeOwnerService.loginStoreOwner(userName,pw);
    }

    @GetMapping(value = "/storeOwnerList")
    public List<StoreOwner> getStoreOwners() {
        return storeOwnerService.findAll();
    }

    @PutMapping(value = "/updateStoreOwner")
    public void updateStoreOwner(@RequestBody StoreOwner storeOwner) {
        storeOwnerService.updateStoreOwner(storeOwner);
    }

    @PutMapping(value = "/executeUpdateStoreOwner")
    public void executeUpdateStoreOwner(@RequestBody StoreOwner storeOwner) {
        storeOwnerService.executeUpdateStoreOwner(storeOwner);
    }

    @DeleteMapping(value = "/deleteStoreOwner")
    public void deleteStoreOwner(@RequestBody StoreOwner storeOwner) {
        userService.deleteUser(storeOwner);
    }
}
