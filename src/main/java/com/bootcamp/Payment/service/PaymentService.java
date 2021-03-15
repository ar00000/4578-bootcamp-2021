package com.bootcamp.Payment.service;

import com.bootcamp.Payment.entities.Check;
import com.bootcamp.Payment.entities.CreditCard;
import com.bootcamp.Payment.repo.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    @Autowired
    public PaymentRepository repository;

    public void createCreditCartPayment(CreditCard card){
        CreditCard cc = new CreditCard();
        cc.setId(card.getId());
        cc.setAmount(card.getAmount());
        cc.setCardNumber(card.getCardNumber());
        repository.save(cc);
    }

    public void createCheckPayment(Check check){
        Check ch =new Check();
        ch.setId(check.getId());
        ch.setCheckNumber(check.getCheckNumber());
        ch.setAmount(check.getAmount());
        repository.save(ch);
    }
}
