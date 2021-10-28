package com.example.E_commerce.ServiceImpl;

import com.example.E_commerce.DTO.OrderDTO;
import com.example.E_commerce.Entity_or_Model.Order;
import com.example.E_commerce.Entity_or_Model.Payment;
import com.example.E_commerce.Entity_or_Model.Product;
import com.example.E_commerce.Entity_or_Model.User;
import com.example.E_commerce.Repository.OrderRepo;
import com.example.E_commerce.Repository.PaymentRepo;
import com.example.E_commerce.Repository.ProductRepo;
import com.example.E_commerce.Repository.UserRepo;
import com.example.E_commerce.Service.OrderInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderServiceImplements implements OrderInterface {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Order addOrder(OrderDTO orderDTO) {

        Order order =new Order();
        order.setQuantity(orderDTO.getQuantity());
        order.setTotalPrice(orderDTO.getTotalPrice());

        User user = userRepo.findByUserId(orderDTO.getUserId());
        order.setUserId(user);

        Order order1=order;
        Payment payment=paymentRepo.findByPaymentId(orderDTO.getPaymentId());
        order1.setPaymentId(payment);

       Order order2 =order;
       orderDTO.getProductId().forEach(productDTO -> {
           Product product = productRepo.findByProductId(productDTO.getProductId());
           order2.setProductId(product);
       });
        
        orderRepo.save(order);

        return order;
    }

    @Override
    public Order getOrder() {
        Order order=new Order();
        orderRepo.findAll();
        return order;
    }

    @Override
    public Order updateOrder(OrderDTO orderDTO) {
        Order existOrder =orderRepo.findByOrderId(orderDTO.getOrderId());
        existOrder.setQuantity(orderDTO.getQuantity());
        existOrder.setTotalPrice(orderDTO.getTotalPrice());

        User user=userRepo.findByUserId(orderDTO.getUserId());
        existOrder.setUserId(user);

        Payment payment=paymentRepo.findByPaymentId(orderDTO.getPaymentId());
        existOrder.setPaymentId(payment);

        orderDTO.getProductId().forEach(productDTO -> {
            Product product=productRepo.findByProductId(productDTO.getProductId());
            existOrder.setProductId(product);
        });
        
        orderRepo.save(existOrder);

        return existOrder;
    }

    @Override
    public Order deleteOrder(Long orderId) {
        Order order = new Order();

        orderRepo.deleteById(orderId);
        return order;
    }
}
