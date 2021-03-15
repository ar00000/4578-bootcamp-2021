package com.bootcamp.Payment.controller;

import com.bootcamp.Payment.entities.Check;
import com.bootcamp.Payment.entities.CreditCard;
import com.bootcamp.Payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Autowired
    public PaymentService service;

    @PostMapping("/payment/check")
    public void createCheckPayment(@RequestBody Check check){
        service.createCheckPayment(check);
    }

    @PostMapping("/payment/credit")
    public void createCheckPayment(@RequestBody CreditCard creditCard){
        service.createCreditCartPayment(creditCard);
    }

}
