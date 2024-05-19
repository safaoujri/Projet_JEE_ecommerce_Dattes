package org.xproce.datte.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xproce.datte.dao.entities.PaymentCart;
import org.xproce.datte.dao.entities.Produit;
import org.xproce.datte.dao.repositories.PaymentCartRepository;

import java.util.List;

@Service
public class PaymentService implements PaymentManager {
    @Autowired
    private PaymentCartRepository paymentCartRepository;

    @Override
    public PaymentCart creePayment(PaymentCart paymentCart) {
        return paymentCartRepository.save(paymentCart);
    }

    @Override
    public PaymentCart updatePayment(PaymentCart paymentCart) {
        return paymentCartRepository.save(paymentCart);
    }

    @Override
    public boolean deletePayment(Integer id) {
        try{
            paymentCartRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public List<PaymentCart> getAllPayment() {
        return paymentCartRepository.findAll();
    }

    @Override
    public PaymentCart getPaymentById(Integer id) {
        return  paymentCartRepository.findById(id).get();
    }
}
