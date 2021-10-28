package com.example.E_commerce.Service;

import com.example.E_commerce.DTO.OrderDTO;
import com.example.E_commerce.Entity_or_Model.Order;

public interface OrderInterface {
    Order addOrder(OrderDTO orderDTO);

    Order getOrder();

    Order updateOrder(OrderDTO orderDTO);

    Order deleteOrder(Long orderId);
}
