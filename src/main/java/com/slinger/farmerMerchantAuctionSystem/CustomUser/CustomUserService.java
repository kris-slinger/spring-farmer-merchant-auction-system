package com.slinger.farmerMerchantAuctionSystem.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomUserService {
    CustomUserRepository customUserRepository;
    @Autowired
    public CustomUserService(CustomUserRepository customUserRepository) {
        this.customUserRepository = customUserRepository;
    }
    public void createUser(CustomUser user){
        customUserRepository.save(user);
    }
    public List<CustomUser> getAllUsers(){
        return customUserRepository.findAll();
    }
    public Optional<CustomUser> getUserById(Integer id){
        return customUserRepository.findById(id);
    }
    public void deleteUserById(Integer id){
        customUserRepository.deleteById(id);
    }

}
