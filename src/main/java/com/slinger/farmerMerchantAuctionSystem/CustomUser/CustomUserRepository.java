package com.slinger.farmerMerchantAuctionSystem.CustomUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomUserRepository extends JpaRepository<CustomUser,Integer> {
//    ?1 - positional query parameter
    @Query("select u from CustomUser u where u.customUserEmail=?1")
    Optional<CustomUser> findByEmail(String email);
    @Query("select u from CustomUser u where u.customUserName=?1")
    Optional<CustomUser> findByName(String name);
}
