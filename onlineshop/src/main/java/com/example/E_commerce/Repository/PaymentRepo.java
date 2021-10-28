package com.example.E_commerce.Repository;

import com.example.E_commerce.Entity_or_Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepo extends JpaRepository<Payment,Long> {
    Payment findByPaymentId(Long paymentId);
}
