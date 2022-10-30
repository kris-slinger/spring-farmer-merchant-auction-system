package com.slinger.farmerMerchantAuctionSystem.Review;
import com.slinger.farmerMerchantAuctionSystem.Farmer.Farmer;
import com.slinger.farmerMerchantAuctionSystem.Merchant.Merchant;

import javax.persistence.*;

@Entity
@Table
public class Review {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer reviewId;
    private Integer reviewRatings;
    private String reviewMessage;
    @ManyToOne(targetEntity = Merchant.class,cascade= CascadeType.REMOVE)
    @JoinColumn(name="review_merchant_id")
    private Integer reviewMerchantId;
    @ManyToOne(targetEntity = Farmer.class,cascade= CascadeType.REMOVE)
    @JoinColumn(name="review_farmer_id")
    private Integer reviewFarmerId;

    public Review() {
    }

    public Review(Integer reviewRatings, String reviewMessage, Integer reviewMerchantId, Integer reviewFarmerId) {
        this.reviewRatings = reviewRatings;
        this.reviewMessage = reviewMessage;
        this.reviewMerchantId = reviewMerchantId;
        this.reviewFarmerId = reviewFarmerId;
    }


    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Integer getReviewRatings() {
        return reviewRatings;
    }

    public void setReviewRatings(Integer reviewRatings) {
        this.reviewRatings = reviewRatings;
    }

    public String getReviewMessage() {
        return reviewMessage;
    }

    public void setReviewMessage(String reviewMessage) {
        this.reviewMessage = reviewMessage;
    }

    public Integer getReviewMerchantId() {
        return reviewMerchantId;
    }

    public void setReviewMerchantId(Integer reviewMerchantId) {
        this.reviewMerchantId = reviewMerchantId;
    }

    public Integer getReviewFarmerId() {
        return reviewFarmerId;
    }

    public void setReviewFarmerId(Integer reviewFarmerId) {
        this.reviewFarmerId = reviewFarmerId;
    }
    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", reviewRatings=" + reviewRatings +
                ", reviewMessage='" + reviewMessage + '\'' +
                ", reviewMerchantId=" + reviewMerchantId +
                ", reviewFarmerId=" + reviewFarmerId +
                '}';
    }

}
