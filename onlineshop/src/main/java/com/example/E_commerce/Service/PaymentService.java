package com.example.E_commerce.Service;

import com.example.E_commerce.BaseReponse.BaseResponse;
import com.example.E_commerce.DTO.PaymentDTO;
import com.example.E_commerce.Entity_or_Model.Payment;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface PaymentService {
    Payment create(PaymentDTO paymentDTO);

    Optional<Payment> getbyid(Long id);

    String deletebyid(Long id);

    Optional<Payment> putupdate(Long id, PaymentDTO paymentDTO);
}
