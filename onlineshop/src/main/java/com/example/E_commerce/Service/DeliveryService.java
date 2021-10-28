package com.example.E_commerce.Service;

import com.example.E_commerce.DTO.DeliveryDTO;
import com.example.E_commerce.Entity_or_Model.Delivery;
import java.util.List;
import java.util.Optional;

public interface DeliveryService {
    Delivery createDelivery(DeliveryDTO deliveryDTO);
    Optional<Delivery> findByDeliveryId(Long deliveryId);
    List<Delivery> getAll();
    Optional<Delivery> updateDelivery(DeliveryDTO deliveryDTO);
    Optional<Delivery> deleteDelivery(DeliveryDTO deliveryDTO);
}
