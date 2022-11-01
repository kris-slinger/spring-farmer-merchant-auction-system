package com.slinger.farmerMerchantAuctionSystem.ProductCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryService {
    ProductCategoryRepository productCategoryRepository;
    @Autowired
    public ProductCategoryService(ProductCategoryRepository productCategoryRepository){
        this.productCategoryRepository=productCategoryRepository;
    }
    public ProductCategory createNewProductCategory(ProductCategory productCategoryDetail){
        Optional<ProductCategory> productExist=productCategoryRepository.getProductCategoriesByName(productCategoryDetail.getProductCategoryName());
        if(productExist.isEmpty()){
            return productCategoryRepository.save(productCategoryDetail);
        }
        else{
            throw   new IllegalStateException(
                    "Product category already exists"
            );
        }

    }

    public List<ProductCategory> getAllProductCategories(){
        return productCategoryRepository.findAll();
    }
    public Optional<ProductCategory> getProductCategoryById(Integer productCategoryId) {
        return productCategoryRepository.findById(productCategoryId);
    }
    public ProductCategory updateProductCategoryById(Integer productCategoryId,ProductCategory productCategoryDetail){
        ProductCategory productCategory=productCategoryRepository.findById(productCategoryId).orElseThrow(
                () -> new IllegalStateException(
                        "Product with id "+productCategoryId+" does not exist"
                )
        );
        productCategory.setProductCategoryName(productCategoryDetail.getProductCategoryName());
        productCategory.setProductDescription(productCategoryDetail.getProductDescription());

        return productCategoryRepository.save(productCategory);
    }

    public void deleteProductCategoryById(Integer productcategoryId){
        productCategoryRepository.deleteById(productcategoryId);
    }
}
