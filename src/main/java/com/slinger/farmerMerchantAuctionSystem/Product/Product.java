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
    private Farmer productFarmer;

    @ManyToOne(targetEntity = ProductCategory.class,cascade =CascadeType.REMOVE)
    @JoinColumn(name="product_category_id")
    private ProductCategory productCategory;

    @OneToOne(targetEntity = Product.class)
    @JoinColumn(name="product_file_product_id")
    private Product productFile;
    public Product() {
    }

    public Product(String productName, Double productPrice, String productDescription, String productLocation, Farmer productFarmer, ProductCategory productCategory, Product productFile) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productLocation = productLocation;
        this.productFarmer = productFarmer;
        this.productCategory = productCategory;
        this.productFile = productFile;
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

    public Farmer getProductFarmer() {
        return productFarmer;
    }

    public void setProductFarmer(Farmer productFarmer) {
        this.productFarmer = productFarmer;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public Product getProductFile() {
        return productFile;
    }

    public void setProductFile(Product productFile) {
        this.productFile = productFile;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productDescription='" + productDescription + '\'' +
                ", productLocation='" + productLocation + '\'' +
                ", productFarmer=" + productFarmer +
                ", productCategory=" + productCategory +
                ", productFile=" + productFile +
                '}';
    }
}
