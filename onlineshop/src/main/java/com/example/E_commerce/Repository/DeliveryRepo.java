package com.example.E_commerce.Repository;

import com.example.E_commerce.Entity_or_Model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepo extends JpaRepository<Delivery, Long> {
}
