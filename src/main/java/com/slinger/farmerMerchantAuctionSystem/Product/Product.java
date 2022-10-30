package com.slinger.farmerMerchantAuctionSystem.Product;
import com.slinger.farmerMerchantAuctionSystem.Farmer.Farmer;
import com.slinger.farmerMerchantAuctionSystem.ProductCategory.ProductCategory;

import javax.persistence.*;

@Entity
@Table
public class Product {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer productId;
    private String productName;
    private Double productPrice;
    private String productDescription;
    private String productLocation;
    @ManyToOne(targetEntity = Farmer.class,cascade = CascadeType.REMOVE)
    @JoinColumn(name="product_farmer_id")
    private Integer productFarmerId;
    @ManyToOne(targetEntity = ProductCategory.class,cascade =CascadeType.REMOVE)
    @JoinColumn(name="product_category_id")
    private Integer productCategoryId;

    public Product() {
    }

    public Product(String productName, Double productPrice, String productDescription, String productLocation, Integer productFarmerId, Integer productCategoryId) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productLocation = productLocation;
        this.productFarmerId = productFarmerId;
        this.productCategoryId = productCategoryId;
    }


    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductLocation() {
        return productLocation;
    }

    public void setProductLocation(String productLocation) {
        this.productLocation = productLocation;
    }

    public Integer getProductFarmerUserId() {
        return productFarmerId;
    }

    public void setProductFarmerUserId(Integer productFarmerId) {
        this.productFarmerId = productFarmerId;
    }

    public Integer getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Integer productCategoryId) {
        this.productCategoryId = productCategoryId;
    }
    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productDescription='" + productDescription + '\'' +
                ", productLocation='" + productLocation + '\'' +
                ", productFarmerId=" + productFarmerId +
                ", productCategoryId=" + productCategoryId +
                '}';
    }

}
