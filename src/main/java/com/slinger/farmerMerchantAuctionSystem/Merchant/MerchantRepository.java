package com.slinger.farmerMerchantAuctionSystem.Merchant;

import com.slinger.farmerMerchantAuctionSystem.CustomUser.CustomUser;
import com.slinger.farmerMerchantAuctionSystem.Farmer.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Integer> {
    @Query("select u from Merchant u where u.merchantCustomUserId=?1")
    Optional<Merchant> findByCustomUserId(CustomUser customUserId);

}
