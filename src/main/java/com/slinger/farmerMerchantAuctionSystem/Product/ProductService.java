package com.slinger.farmerMerchantAuctionSystem.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }
    public Product createNewProduct(Product productDetail){
        return productRepository.save(productDetail);
    }
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public Product getProductById(Integer productId){
       return productRepository.findById(productId).orElseThrow(
               () ->{throw new IllegalStateException((
                       "product with id"+productId+" not found"
                       )
               );
               }
        );
    }
    public Product updateProductById(Integer productId,Product productDetail){
        Product product=productRepository.findById(productId).orElseThrow(
               () ->{throw new IllegalStateException((
                       "product with id"+productId+" not found"
                       )
               );
               }
        );
        product.setProductFarmer(productDetail.getProductFarmer());
        product.setProductCategory(productDetail.getProductCategory());
        product.setProductName(productDetail.getProductName());
        product.setProductLocation(productDetail.getProductLocation());
        product.setProductDescription(productDetail.getProductDescription());
        product.setProductPrice((productDetail.getProductPrice()));
        product.setProductFile(productDetail.getProductFile());
        return product;
    }
    public void deleteProduct(Integer productId){
        productRepository.deleteById(productId);
    }

}
