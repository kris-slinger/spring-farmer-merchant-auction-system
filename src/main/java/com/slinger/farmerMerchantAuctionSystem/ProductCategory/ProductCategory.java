package com.slinger.farmerMerchantAuctionSystem.ProductCategory;
import javax.persistence.*;

@Entity
@Table
public class ProductCategory {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer productCategoryId;
    private String productCategoryName;
    @Column(columnDefinition = "TEXT")
    private String productDescription;

    public ProductCategory() {
    }
    public ProductCategory(String productCategoryName, String productDescription) {
        this.productCategoryName = productCategoryName;
        this.productDescription = productDescription;
    }

    public Integer getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Integer productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "productCategoryId=" + productCategoryId +
                ", productCategoryName='" + productCategoryName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                '}';
    }
}
