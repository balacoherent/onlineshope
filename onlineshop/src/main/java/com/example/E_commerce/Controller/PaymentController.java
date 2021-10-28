package com.example.E_commerce.Controller;


import com.example.E_commerce.BaseReponse.BaseResponse;
import com.example.E_commerce.DTO.PaymentDTO;
import com.example.E_commerce.Entity_or_Model.Payment;
import com.example.E_commerce.Entity_or_Model.User;
import com.example.E_commerce.Service.PaymentService;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping("/post")
    public BaseResponse<Payment> create(@RequestBody PaymentDTO paymentDTO)
    {
        BaseResponse<Payment> baseResponse;
        baseResponse = BaseResponse.<Payment>builder().data(paymentService.create(paymentDTO)).build();
        return baseResponse;
    }

    @GetMapping("/getbyid")
    public BaseResponse<Optional<Payment>> getbyid(@RequestParam Long id)
    {
        BaseResponse<Optional<Payment>> baseResponse;
        baseResponse = BaseResponse.<Optional<Payment>>builder().data(paymentService.getbyid(id)).build();
        return baseResponse;
    }

    @DeleteMapping("/deletebyid")
    public BaseResponse deletebyid(@RequestParam Long id)
    {
        BaseResponse baseResponse;
        baseResponse=BaseResponse.builder().data(paymentService.deletebyid(id)).build();
        return baseResponse;
    }

    @PutMapping("/putupdate")
    public BaseResponse<Optional<Payment>> putupdate(@RequestParam Long id,@RequestBody PaymentDTO paymentDTO)
    {
        BaseResponse<Optional<Payment>> baseResponse;
        baseResponse= BaseResponse.<Optional<Payment>>builder().data(paymentService.putupdate(id, paymentDTO)).build();
        return baseResponse;
    }

}
