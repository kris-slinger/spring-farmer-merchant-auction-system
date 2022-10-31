package com.slinger.farmerMerchantAuctionSystem.CustomUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<CustomUser>> getCustomUsers(){
        List<CustomUser> users=customUserService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }
    @GetMapping(path = "{userId}")
    public Optional<CustomUser> getUserById(@PathVariable Integer userId){
        return customUserService.getUserById(userId);
    }
    @PostMapping(path="/new")
    public ResponseEntity<CustomUser> createNewCustomUser(
            @Valid @RequestBody CustomUser customUser
    ){
            System.out.println(customUser);
            CustomUser user=customUserService.createUser(customUser);
            return new ResponseEntity<CustomUser>(user,HttpStatus.OK);
    }
    @PutMapping(path="{userId}")
    public ResponseEntity<CustomUser> updateUserById(@Valid @RequestBody CustomUser user, @PathVariable Integer userId){
        try{
            CustomUser updatedUser=customUserService.updateUser(userId,user);
            return new ResponseEntity<CustomUser>(updatedUser,HttpStatus.ACCEPTED);
        }
        catch (IllegalStateException e){
            return new ResponseEntity<CustomUser>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping(path="{userId}")
    public ResponseEntity<CustomUser> deleteUSerById(@PathVariable Integer userId){
        customUserService.deleteUserById(userId);
        return new ResponseEntity<CustomUser>(HttpStatus.OK);
    }
}
