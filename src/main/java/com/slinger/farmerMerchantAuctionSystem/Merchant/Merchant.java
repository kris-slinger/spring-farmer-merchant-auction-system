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
    private  Integer merchantCustomUserId;

    public Merchant(Integer merchantCustomUserId) {
        this.merchantCustomUserId = merchantCustomUserId;
    }

    public Merchant() {
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getMerchantCustomUserId() {
        return merchantCustomUserId;
    }

    public void setMerchantCustomUserId(Integer merchantCustomUserId) {
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