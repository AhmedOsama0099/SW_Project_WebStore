package com.example.webstore.api;

import com.example.webstore.model.Buyer;
import com.example.webstore.model.User;
import com.example.webstore.service.Buyer.BuyerService;
import com.example.webstore.service.User.UserService;
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
    public void addUser(@RequestBody Buyer buyer) {
        userService.insertEmployee(buyer);
        buyerService.insertEmployee(buyer);
    }
    @GetMapping(value = "/buyerList")
    public List<User> getBuyers() {
        return buyerService.findAll();
    }
    @PutMapping(value = "/updateBuyer")
    public void updateBuyer(@RequestBody Buyer buyer) {
        buyerService.updateEmployee(buyer);
    }
    @PutMapping(value = "/executeUpdateBuyer")
    public void executeUpdateEmployee(@RequestBody Buyer buyer) {
        buyerService.executeUpdateEmployee(buyer);

    }

    @DeleteMapping(value = "/deleteBuyer")
    public void deleteEmployee(@RequestBody Buyer emp) {
        userService.deleteEmployee(emp);

    }
}
