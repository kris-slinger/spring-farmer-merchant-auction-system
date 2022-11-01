package com.slinger.farmerMerchantAuctionSystem.ProductCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductCategoryRepository  extends JpaRepository<ProductCategory,Integer> {
    @Query("select u from ProductCategory u where u.productCategoryName=?1")
    Optional<ProductCategory> getProductCategoriesByName(String productCategoryName);
}
