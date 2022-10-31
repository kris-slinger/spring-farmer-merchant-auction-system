package com.slinger.farmerMerchantAuctionSystem.Farmer;

import com.slinger.farmerMerchantAuctionSystem.CustomUser.CustomUser;
import com.slinger.farmerMerchantAuctionSystem.CustomUser.CustomUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FarmerService {
    FarmerRepository farmerRepository;
    CustomUserRepository customUserRepository;
    @Autowired
    public  FarmerService(FarmerRepository farmerRepository,CustomUserRepository customUserRepository){
        this.farmerRepository=farmerRepository;
        this.customUserRepository=customUserRepository;
    }
    public Farmer createNewFarmer(Farmer farmer){
        CustomUser user=customUserRepository.findById(farmer.getFarmerCustomUserId().getCustomUserId()).orElseThrow(
                () -> new IllegalStateException(
                        "custom user with id "+farmer.getFarmerCustomUserId().getCustomUserId()+" does not exist"

                )
        );

        return farmerRepository.save(farmer);
    }
    public List<Farmer> getAllFarmers() {
        return  farmerRepository.findAll();
    }

    public Optional<Farmer> getFarmerById(Integer farmerId){
        return farmerRepository.findById(farmerId);
    }

    public Farmer updateFarmerById(Farmer farmerData,Integer farmerDataId){
        Farmer farmer = farmerRepository.findById(farmerDataId).orElseThrow(
                () -> new IllegalStateException(
                        "Farmer with id " + farmerDataId+" does not exist"
                )
        );
        farmer.setFarmerCustomUserId(farmerData.getFarmerCustomUserId());
        return farmerRepository.save(farmer);
    }
    public void deleteFarmerById(Integer farmerId){
        farmerRepository.deleteById(farmerId);
    }
}
