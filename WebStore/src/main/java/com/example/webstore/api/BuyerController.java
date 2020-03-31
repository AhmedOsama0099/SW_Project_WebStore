package com.example.webstore.api;

import com.example.webstore.model.Admin;
import com.example.webstore.model.Buyer;
import com.example.webstore.model.User;
import com.example.webstore.service.BuyerService;
import com.example.webstore.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/app")
public class BuyerController {

    @Resource
    BuyerService buyerService;
    @Resource
    UserService userService;

    @PostMapping(value = "/createBuyer")
    public void addBuyer(@RequestBody Buyer buyer) {
        userService.insertUser(buyer);
        buyerService.insertBuyer(buyer);
    }
    @GetMapping(path = "/loginBuyer/{userName}/{pw}")
    public Buyer loginBuyer(@PathVariable("userName") String userName, @PathVariable("pw") String pw){
        return buyerService.loginBuyer(userName,pw);
    }
    @GetMapping(value = "/buyerList")
    public List<Buyer> getBuyers() {
        return buyerService.findAll();
    }
    @PutMapping(value = "/updateBuyer")
    public void updateBuyer(@RequestBody Buyer buyer) {
        buyerService.updateBuyer(buyer);
    }
    @PutMapping(value = "/executeUpdateBuyer")
    public void executeUpdateBuyer(@RequestBody Buyer buyer) {
        buyerService.executeUpdateBuyer(buyer);
    }

    @DeleteMapping(value = "/deleteBuyer")
    public void deleteBuyere(@RequestBody Buyer buyer) {
        userService.deleteUser(buyer);
    }
}
