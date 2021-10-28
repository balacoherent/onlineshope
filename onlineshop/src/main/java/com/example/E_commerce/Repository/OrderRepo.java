package com.example.E_commerce.Repository;

import com.example.E_commerce.Entity_or_Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order,Long> {
    Order findByOrderId(Long orderId);
}
