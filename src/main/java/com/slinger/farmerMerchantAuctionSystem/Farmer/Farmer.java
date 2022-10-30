package com.slinger.farmerMerchantAuctionSystem.Farmer;
import javax.persistence.*;
import com.slinger.farmerMerchantAuctionSystem.CustomUser.CustomUser;

@Entity
@Table
public class Farmer {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer farmerId;
    @OneToOne( targetEntity = CustomUser.class,cascade = CascadeType.REMOVE)
    @JoinColumn(name="farmer_custom_user_id")
    private  Integer farmerCustomUserId;



    public Farmer(Integer farmerCustomUserId) {
        this.farmerCustomUserId = farmerCustomUserId;
    }

    public Farmer() {
    }

    public Integer getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(Integer farmerId) {
        this.farmerId = farmerId;
    }

    public Integer getFarmerCustomUserId() {
        return farmerCustomUserId;
    }

    public void setFarmerCustomUserId(Integer farmerCustomUserId) {
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
