package com.slinger.farmerMerchantAuctionSystem.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    OrderRepository orderRepository;
    @Autowired
    public OrderService(OrderRepository orderRepository){
        this.orderRepository=orderRepository;
    }

    public Order createNewOrder(Order orderDetail){
        return orderRepository.save(orderDetail);
    }
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }
    public Order getOrderById(Integer orderId){
        Order order=orderRepository.findById(orderId).orElseThrow(
                ()->{
                    throw  new IllegalStateException(
                            "order with id"+orderId+"doesn't exist"
                    );
                }

        );
        return order;
    }
    public Order updateOrderById(Integer orderId,Order orderDetail){
        Order order=orderRepository.findById(orderId).orElseThrow(
                ()->{
                    throw  new IllegalStateException(
                            "order with id"+orderId+"doesn't exist"
                    );
                }

        );
        order.setOrderQuantity(orderDetail.getOrderQuantity());
        order.setOrderStatus(orderDetail.getOrderStatus());
        order.setOrderCreationTime(orderDetail.getOrderCreationTime());
        order.setOrderMerchantId(orderDetail.getOrderMerchantId());
        order.setOrderExpirationTime(orderDetail.getOrderExpirationTime());
        order.setOrderProductId(orderDetail.getOrderProductId());
        return order;
    }
    public void deleteOrderById(Integer orderId){
       orderRepository.deleteById(orderId);

    }
}
