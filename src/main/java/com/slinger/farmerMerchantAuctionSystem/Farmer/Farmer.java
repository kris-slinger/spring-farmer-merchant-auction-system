package com.slinger.farmerMerchantAuctionSystem.Farmer;
import javax.persistence.*;
import com.slinger.farmerMerchantAuctionSystem.CustomUser.CustomUser;

@Entity
@Table
public class Farmer {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer farmerId;
    @OneToOne( targetEntity = CustomUser.class)
    @JoinColumn(name="farmer_custom_user_id")
    private  CustomUser farmerCustomUserId;

    public Farmer() {
    }

    public Farmer(CustomUser farmerCustomUserId) {
        this.farmerCustomUserId = farmerCustomUserId;
    }

    public Integer getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(Integer farmerId) {
        this.farmerId = farmerId;
    }

    public CustomUser getFarmerCustomUserId() {
        return farmerCustomUserId;
    }

    public void setFarmerCustomUserId(CustomUser farmerCustomUserId) {
        this.farmerCustomUserId = farmerCustomUserId;
    }

    @Override
    public String toString() {
        return "Farmer{" +
                "farmerId=" + farmerId +
                ", farmerCustomUserId=" + farmerCustomUserId +
                '}';
    }
}
