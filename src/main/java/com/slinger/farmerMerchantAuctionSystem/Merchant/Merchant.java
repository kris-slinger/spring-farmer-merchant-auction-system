package com.slinger.farmerMerchantAuctionSystem.Merchant;
import com.slinger.farmerMerchantAuctionSystem.CustomUser.CustomUser;

import javax.persistence.*;

@Entity
@Table
public class Merchant {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer merchantId;
    @OneToOne(targetEntity = CustomUser.class,cascade = CascadeType.REMOVE)
    @JoinColumn(name="merchant_custom_user_id")
    private  CustomUser merchantCustomUserId;

    public Merchant() {
    }

    public Merchant(CustomUser merchantCustomUserId) {
        this.merchantCustomUserId = merchantCustomUserId;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public CustomUser getMerchantCustomUserId() {
        return merchantCustomUserId;
    }

    public void setMerchantCustomUserId(CustomUser merchantCustomUserId) {
        this.merchantCustomUserId = merchantCustomUserId;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "merchantId=" + merchantId +
                ", merchantCustomUserId=" + merchantCustomUserId +
                '}';
    }
}