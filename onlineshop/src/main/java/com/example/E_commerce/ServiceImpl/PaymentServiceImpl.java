package com.example.E_commerce.ServiceImpl;

import com.example.E_commerce.BaseReponse.BaseResponse;
import com.example.E_commerce.DTO.PaymentDTO;
import com.example.E_commerce.Entity_or_Model.Payment;
import com.example.E_commerce.Repository.PaymentRepo;
import com.example.E_commerce.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepo paymentRepo;


   @Override
   public Payment create(PaymentDTO paymentDTO){
       Payment payment= new Payment();
       payment.setPaymentType(paymentDTO.getPaymentType());
       payment=paymentRepo.save(payment);
       return payment;
   }

    @Override
    public Optional<Payment> getbyid(Long id) {
       Optional<Payment> payment= paymentRepo.findById(id);
       if(payment.isPresent()) {
           if (payment.get().getIsDelete() == 0) {
                    return payment;
           }
           else {
               throw new RuntimeException("This Payment ID is Deleted");
           }
       }
       else {
           throw new RuntimeException("Please Enter a valid Payment Id");
       }
   }

   @Override
   public String deletebyid(Long id) {
       Optional<Payment> payment = paymentRepo.findById(id);
       if(payment.isPresent()) {
           if(payment.get().getIsDelete()==0) {
               payment.get().setIsDelete(1);
               paymentRepo.save(payment.get());
               String response ="This ID "+ id + "is Successfully Deleted";
               return response;
           }
           else {
               throw new RuntimeException("This ID "+ id +" is already deleted");
           }
       }
       else {
           throw new RuntimeException("Please Enter a valid Payment Id");
       }
   }

   @Override
   public Optional<Payment> putupdate(Long id, PaymentDTO paymentDTO) {
       Optional<Payment> payment = paymentRepo.findById(id);
       if(payment.isPresent()) {
           payment.get().setPaymentType(paymentDTO.getPaymentType());
           payment.get().setIsDelete(payment.get().getIsDelete());
           payment.get().setIsActive(payment.get().getIsActive());
           paymentRepo.save(payment.get());
           return payment;
       }
       else {
           throw new RuntimeException("Please Enter a valid Payment Id");
       }
   }

}
