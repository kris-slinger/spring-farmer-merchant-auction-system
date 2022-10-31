package com.slinger.farmerMerchantAuctionSystem.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CustomUserService {
    CustomUserRepository customUserRepository;
    @Autowired
    public CustomUserService(CustomUserRepository customUserRepository) {
        this.customUserRepository = customUserRepository;
    }
    public CustomUser createUser(CustomUser user){
        Optional<CustomUser> emailExists=customUserRepository.findByEmail(user.getCustomUserEmail());
        Optional<CustomUser> userNameExists=customUserRepository.findByName(user.getCustomUserName());
        if(emailExists.isPresent()){
            throw new IllegalStateException("email already taken");
        }
        else if (userNameExists.isPresent()) {
            throw new IllegalStateException("userName already taken");

        }
        return customUserRepository.save(user);
    }
    public List<CustomUser> getAllUsers(){
        return customUserRepository.findAll();
    }
    public Optional<CustomUser> getUserById(Integer id){
        return customUserRepository.findById(id);
    }

    @Transactional
    public CustomUser updateUser(Integer userId,CustomUser user){
        CustomUser customUser= customUserRepository.findById(userId).orElseThrow(
                ()-> new IllegalStateException(
                        "User with id"+userId+"does not exist"
                )
        );
        customUser.setCustomUserEmail(user.getCustomUserEmail());
        customUser.setCustomUserName(user.getCustomUserName());
        customUser.setCustomUserPassword(user.getCustomUserPassword());
        customUser.setCustomUserNationalId(user.getCustomUserNationalId());
        customUser.setCustomUserRole(user.getCustomUserRole());

        return customUser;
    }

     public void deleteUserById(Integer id){
        customUserRepository.deleteById(id);
     }
}
