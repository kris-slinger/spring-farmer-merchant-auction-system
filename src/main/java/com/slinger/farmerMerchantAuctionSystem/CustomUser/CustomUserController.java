package com.slinger.farmerMerchantAuctionSystem.CustomUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/users")
public class CustomUserController {
    CustomUserService customUserService;
    @Autowired
    public CustomUserController(CustomUserService customUserService) {
        this.customUserService = customUserService;
    }
    @GetMapping
    public List<CustomUser> getCustomUsers(){
        return customUserService.getAllUsers();
    }
    @PostMapping(path="/new")
    public void createNewCustomUser(
            @RequestBody CustomUser customUser
    ){
        customUserService.createUser(customUser);
    }
}
