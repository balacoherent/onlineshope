package com.example.E_commerce.ServiceImpl;

import com.example.E_commerce.DTO.DeliveryDTO;
import com.example.E_commerce.Entity_or_Model.Delivery;
import com.example.E_commerce.Entity_or_Model.Order;
import com.example.E_commerce.Repository.DeliveryRepo;
import com.example.E_commerce.Repository.OrderRepo;
import com.example.E_commerce.Service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private DeliveryRepo deliveryRepo;
    @Autowired
    private OrderRepo orderRepo;



    @Override
    public Delivery createDelivery(DeliveryDTO deliveryDTO) {
        Delivery delivery = new Delivery();
        delivery.setLocation(deliveryDTO.getLocation());
        delivery.setDeliveryDate(deliveryDTO.getDeliveryDate());

            Optional<Order> orderobj = orderRepo.findById(deliveryDTO.getOrderId());
            if (orderobj.isPresent()) {
                delivery.setOrder(orderobj.get());
            }
            else {
                throw new RuntimeException("id not found");
            }
        delivery.setLocation(deliveryDTO.getLocation());
        delivery.setDeliveryDate(deliveryDTO.getDeliveryDate());
        deliveryRepo.save(delivery);
        return delivery;
    }

    @Override
    public Optional<Delivery> findByDeliveryId(Long deliveryId) {
        Optional<Delivery> delivery = deliveryRepo.findById(deliveryId);
        if (delivery.isPresent() && delivery.get().getIsDelete() == 0) {
            return delivery;
        }else {
            throw new RuntimeException("id not found");
        }
    }

    @Override
    public List<Delivery> getAll() {
        return deliveryRepo.findAll();
    }

    @Override
    public Optional<Delivery> updateDelivery(DeliveryDTO deliveryDTO) {
        Optional<Delivery> delivery = deliveryRepo.findById(deliveryDTO.getDeliveryId());
        if (delivery.isPresent() && delivery.get().getIsDelete() == 0) {
            delivery.get().setLocation(deliveryDTO.getLocation());
            delivery.get().setDeliveryDate(deliveryDTO.getDeliveryDate());
        } else {
            throw new RuntimeException("id not found");
        }
        deliveryRepo.save(delivery.get());
        return delivery;
    }

    @Override
    public Optional<Delivery> deleteDelivery(DeliveryDTO deliveryDTO) {
        Optional<Delivery> delivery = deliveryRepo.findById(deliveryDTO.getDeliveryId());
        if (delivery.isPresent()) {
            delivery.get().setIsDelete(1);
            deliveryRepo.save(delivery.get());
        } else {
            throw new RuntimeException("id not found");
        }
        return delivery;
    }
}
