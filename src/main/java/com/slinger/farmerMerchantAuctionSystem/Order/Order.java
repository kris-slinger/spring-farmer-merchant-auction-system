package com.slinger.farmerMerchantAuctionSystem.Order;

import com.slinger.farmerMerchantAuctionSystem.Merchant.Merchant;
import com.slinger.farmerMerchantAuctionSystem.Product.Product;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Order {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer orderId;
    private Integer orderQuantity;
    private String orderStatus;
    private LocalDate orderCreationTime;
    private LocalDate orderExpirationTime;
    @ManyToOne(targetEntity = Product.class,cascade = CascadeType.REMOVE)
    @JoinColumn(name="order_product_id")
    private Integer orderProductId;
    @ManyToOne(targetEntity = Merchant.class,cascade=CascadeType.REMOVE)
    @JoinColumn(name="order_merchant_id")
    private Integer orderMerchantId;

    public Order() {
    }

    public Order(Integer orderQuantity, String orderStatus, LocalDate orderCreationTime, LocalDate orderExpirationTime, Integer orderProductId, Integer orderMerchantId) {
        this.orderQuantity = orderQuantity;
        this.orderStatus = orderStatus;
        this.orderCreationTime = orderCreationTime;
        this.orderExpirationTime = orderExpirationTime;
        this.orderProductId = orderProductId;
        this.orderMerchantId = orderMerchantId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(Integer orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public LocalDate getOrderCreationTime() {
        return orderCreationTime;
    }

    public void setOrderCreationTime(LocalDate orderCreationTime) {
        this.orderCreationTime = orderCreationTime;
    }

    public LocalDate getOrderExpirationTime() {
        return orderExpirationTime;
    }

    public void setOrderExpirationTime(LocalDate orderExpirationTime) {
        this.orderExpirationTime = orderExpirationTime;
    }

    public Integer getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(Integer orderProductId) {
        this.orderProductId = orderProductId;
    }

    public Integer getOrderMerchantId() {
        return orderMerchantId;
    }

    public void setOrderMerchantId(Integer orderMerchantId) {
        this.orderMerchantId = orderMerchantId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderQuantity=" + orderQuantity +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderCreationTime=" + orderCreationTime +
                ", orderExpirationTime=" + orderExpirationTime +
                ", orderProductId=" + orderProductId +
                ", orderMerchantId=" + orderMerchantId +
                '}';
    }
}
