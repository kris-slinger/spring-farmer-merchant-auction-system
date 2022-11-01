package com.slinger.farmerMerchantAuctionSystem.ProductCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product/productCategory")
public class ProductCategoryController {
    ProductCategoryService productCategoryService;

    @Autowired
    public ProductCategoryController(ProductCategoryService productCategoryService){
        this.productCategoryService=productCategoryService;
    }

    @PostMapping(path="/new")
    public ProductCategory createNewProductCategory(@Valid @RequestBody ProductCategory productCategoryDetail){
        return productCategoryService.createNewProductCategory(productCategoryDetail);
    }
    @GetMapping
    public List<ProductCategory> getAllProductCategories(){
        return  productCategoryService.getAllProductCategories();
    }
    @GetMapping(path="{productCategoryId}")
    public Optional<ProductCategory> getProductCategoryById(@PathVariable Integer productCategoryId){
        return productCategoryService.getProductCategoryById(productCategoryId);
    }
    @PutMapping(path="{productCategoryId}")
    public ProductCategory updateProductCategoryById(@PathVariable Integer productCategoryId,@Valid @RequestBody ProductCategory productCategoryDetail){
        return productCategoryService.updateProductCategoryById(productCategoryId,productCategoryDetail);
    }
    @DeleteMapping(path="{productCategoryId}")
    public void deleteProductCategoryById(@PathVariable Integer productCategoryId){
        productCategoryService.deleteProductCategoryById(productCategoryId);
    }
}
