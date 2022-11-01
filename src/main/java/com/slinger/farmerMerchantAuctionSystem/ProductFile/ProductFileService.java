package com.slinger.farmerMerchantAuctionSystem.ProductFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductFileService {
    ProductFileRepository productFileRepository;
    @Autowired
    public ProductFileService(ProductFileRepository productFileRepository){
        this.productFileRepository=productFileRepository;
    }
    public List<ProductFile> getAllProductFiles(){
        return productFileRepository.findAll();
    }
    public Optional<ProductFile> getProductFileById(Integer productFileId){
        return productFileRepository.findById(productFileId);
    }
}
