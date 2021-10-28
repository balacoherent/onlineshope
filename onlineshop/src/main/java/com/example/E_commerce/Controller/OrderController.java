package com.example.E_commerce.Controller;

import com.example.E_commerce.BaseReponse.BaseResponse;
import com.example.E_commerce.DTO.OrderDTO;
import com.example.E_commerce.Entity_or_Model.Order;
import com.example.E_commerce.Service.OrderInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderInterface orderInterface;

    @PostMapping("/create")
    public BaseResponse<Order> SaveOrder(@RequestBody OrderDTO orderDTO){
        BaseResponse baseResponse;
        baseResponse=BaseResponse.builder().data(orderInterface.addOrder(orderDTO)).build();
        return baseResponse;
    }
    @GetMapping("/getAll")
    public BaseResponse<Order> getAll(){
        BaseResponse<Order>baseResponse;
        baseResponse=BaseResponse.<Order>builder().data(orderInterface.getOrder()).build();
        return baseResponse;
    }

    @PutMapping("/update")
    public BaseResponse updateOrder(@RequestBody OrderDTO orderDTO){
        BaseResponse baseResponse;
        baseResponse= BaseResponse.builder().data(orderInterface.updateOrder(orderDTO)).build();
        return baseResponse;
    }

    @DeleteMapping("/delete/{orderId}")
    public BaseResponse<Order> deleteOrder(@PathVariable Long orderId){
        BaseResponse<Order> baseResponse;
        baseResponse= BaseResponse.<Order>builder().data(orderInterface.deleteOrder(orderId)).build();
        return baseResponse;
    }


}
