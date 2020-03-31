package com.example.webstore.api;

import com.example.webstore.Exceptions.login.LoginUserNotFoundException;
import com.example.webstore.Exceptions.signUp.SignUpUserNotFoundException;
import com.example.webstore.model.Buyer;
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
    public String addBuyer(@RequestBody Buyer buyer) {
        if(userService.getUserByUserName(buyer.getUserName())!=null){
            throw new SignUpUserNotFoundException();
        }
        else{
            userService.insertUser(buyer);
            buyerService.insertBuyer(buyer);
            return "SignUp Successfully";
        }
    }
    @GetMapping(path = "/loginBuyer/{userName}/{pw}")
    public Buyer loginBuyer(@PathVariable("userName") String userName, @PathVariable("pw") String pw){
        Buyer buyer=buyerService.loginBuyer(userName,pw);
        if(buyer==null){
            throw  new LoginUserNotFoundException();
        }
        return buyer;
    }
    @GetMapping(value = "/buyerList")
    public List<Buyer> getBuyers() {
        return buyerService.findAll();
    }
    /*@PutMapping(value = "/updateBuyer")
    public void updateBuyer(@RequestBody Buyer buyer) {
        buyerService.updateBuyer(buyer);
    }
    @DeleteMapping(value = "/deleteBuyer")
    public void deleteBuyere(@RequestBody Buyer buyer) {
        userService.deleteUser(buyer);
    }*/
}
