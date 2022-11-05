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
    public ProductFile createProductFile(ProductFile productFileDetail){
        return productFileRepository.save(productFileDetail);
    }
    public List<ProductFile> getAllProductFiles(){
        return productFileRepository.findAll();
    }
    public Optional<ProductFile> getProductFileById(Integer productFileId){
        return productFileRepository.findById(productFileId);
    }
    public ProductFile updateProductFileById(ProductFile productFileDetail, Integer productFileId){
        ProductFile productFile=productFileRepository.findById(productFileId).orElseThrow(
                () -> {
                    throw new IllegalStateException("productfile with id "+productFileId+" does not exist");
                });
        productFile.setProductFileName(productFileDetail.getProductFileName());
        productFile.setProductFileType(productFileDetail.getProductFileType());
        productFile.setProductFileFile(productFileDetail.getProductFileFile());
        return productFile;

    }
    public void deleteProductFileById(Integer productFileId){
         ProductFile productFile=productFileRepository.findById(productFileId).orElseThrow(
                () -> {
                    throw new IllegalStateException("product file with id "+productFileId+" does not exist");
                });
         productFileRepository.deleteById(productFileId);
    }
}
