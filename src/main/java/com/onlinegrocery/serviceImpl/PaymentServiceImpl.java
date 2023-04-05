package com.onlinegrocery.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinegrocery.dto.PaymentDto;
import com.onlinegrocery.entity.Payment;
import com.onlinegrocery.repo.PaymentRepo;
import com.onlinegrocery.service.PaymentService;

import javax.transaction.Transactional;
import javax.validation.Valid;

 

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
 
    @Autowired
    PaymentRepo paymentRepo;

//    double totalAmount = orderItemObj.getAmount();
//    double tax =  ((totalAmount*18)/100);
//    totalAmount+=tax;
//    double final_amount =totalAmount;
 
    @Override
    public PaymentDto payBill(@Valid PaymentDto paymentDTO) {
        double amount = paymentDTO.getAmount();
        double taxRate = 0.10; // 10% tax rate
        double taxAmount = amount * taxRate;
        double totalAmount = amount + taxAmount;
 
        Payment payment = new Payment();
        payment.setAmount(totalAmount);
        payment.setType(paymentDTO.getType());
 
        paymentRepo.save(payment);
 
        paymentDTO.setPaymentId(payment.getPaymentId());
        paymentDTO.setAmount(totalAmount);
 
        return paymentDTO;
    }
 
    @Override
    public List<Payment> viewBill() {
        List<Payment> findAll = this.paymentRepo.findAll();
        return findAll;
    }


}

