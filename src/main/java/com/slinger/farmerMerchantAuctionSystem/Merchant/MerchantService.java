package com.slinger.farmerMerchantAuctionSystem.Merchant;

import com.slinger.farmerMerchantAuctionSystem.CustomUser.CustomUser;
import com.slinger.farmerMerchantAuctionSystem.CustomUser.CustomUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class MerchantService {
    MerchantRepository merchantRepository;
    CustomUserRepository customUserRepository;
    @Autowired
    public MerchantService(MerchantRepository merchantRepository,CustomUserRepository customUserRepository){
        this.merchantRepository=merchantRepository;
        this.customUserRepository=customUserRepository;
    };

    public Merchant createNewMerchant(Merchant merchantDetails){
        Optional<Merchant> merchantExist=merchantRepository.findByCustomUserId(merchantDetails.getMerchantCustomUserId());
        if(merchantExist.isEmpty()){
                return merchantRepository.save(merchantDetails);
        }
        else{
            throw new IllegalStateException(
                    "CustomUser already used"
            );
        }
    }
    public List<Merchant> getAllMerchants(){
        return merchantRepository.findAll();
    }
    public Optional<Merchant> getMerchantById(Integer merchantDetailId){
        return  merchantRepository.findById(merchantDetailId);
    }

    public Merchant updateMerchantById(Integer  merchantDetailId,Merchant merchantDetail){
        Merchant merchant = merchantRepository.findById(merchantDetailId).orElseThrow(
                ()-> new IllegalStateException(
                        "Merchant with Id"+merchantDetail + " doesnt exist"
                )
        );
        merchant.setMerchantCustomUserId(
                merchantDetail.getMerchantCustomUserId()
        );
        return merchantRepository.save(merchant);
    }
    public void deleteMerchant(Integer merchantId){
        merchantRepository.deleteById(merchantId);
    }

}
