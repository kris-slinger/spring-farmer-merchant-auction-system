package com.slinger.farmerMerchantAuctionSystem.ProductFile;
import com.slinger.farmerMerchantAuctionSystem.Product.Product;

import javax.persistence.*;

@Entity
@Table
public class ProductFile {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer productFileId;
    private String productFileName;
    private String productFileType;
    private String productFileFile;
    @OneToOne(targetEntity = Product.class)
    @JoinColumn(name="product_file_product_id")
    private Integer productFileProductId;

    public ProductFile(String productFileName, String productFileType, String productFileFile, Integer productFileProductId) {
        this.productFileName = productFileName;
        this.productFileType = productFileType;
        this.productFileFile = productFileFile;
        this.productFileProductId = productFileProductId;
    }

    public ProductFile() {
    }

    public Integer getProductFileId() {
        return productFileId;
    }

    public void setProductFileId(Integer productFileId) {
        this.productFileId = productFileId;
    }

    public String getProductFileName() {
        return productFileName;
    }

    public void setProductFileName(String productFileName) {
        this.productFileName = productFileName;
    }

    public String getProductFileType() {
        return productFileType;
    }

    public void setProductFileType(String productFileType) {
        this.productFileType = productFileType;
    }

    public String getProductFileFile() {
        return productFileFile;
    }

    public void setProductFileFile(String productFileFile) {
        this.productFileFile = productFileFile;
    }

    public Integer getProductFileProductId() {
        return productFileProductId;
    }

    public void setProductFileProductId(Integer productFileProductId) {
        this.productFileProductId = productFileProductId;
    }

    @Override
    public String toString() {
        return "ProductFile{" +
                "productFileId=" + productFileId +
                ", productFileName='" + productFileName + '\'' +
                ", productFileType='" + productFileType + '\'' +
                ", productFileFile='" + productFileFile + '\'' +
                ", productFileProductId=" + productFileProductId +
                '}';
    }
}
