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

    public ProductFile() {
    }

    public ProductFile(String productFileName, String productFileType, String productFileFile) {
        this.productFileName = productFileName;
        this.productFileType = productFileType;
        this.productFileFile = productFileFile;
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

    @Override
    public String toString() {
        return "ProductFile{" +
                "productFileId=" + productFileId +
                ", productFileName='" + productFileName + '\'' +
                ", productFileType='" + productFileType + '\'' +
                ", productFileFile='" + productFileFile + '\'' +
                '}';
    }
}
