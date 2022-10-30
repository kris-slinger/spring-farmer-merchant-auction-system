package com.slinger.farmerMerchantAuctionSystem.CustomUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
    @GetMapping(path = "{userId}")
    public Optional<CustomUser> getUserById(@PathVariable Integer userId){
        return customUserService.getUserById(userId);
    }
    @PostMapping(path="/new")
    public void createNewCustomUser(
            @Valid @RequestBody CustomUser customUser
    ){
        customUserService.createUser(customUser);
    }
    @PutMapping(path="{userId}")
    public void updateUserById( @Valid @RequestBody CustomUser user,@PathVariable Integer userId){
        customUserService.updateUser(userId,user);
    }
}
