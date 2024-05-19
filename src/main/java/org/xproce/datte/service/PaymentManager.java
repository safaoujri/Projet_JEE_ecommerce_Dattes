package org.xproce.datte.service;

import org.springframework.stereotype.Component;
import org.xproce.datte.dao.entities.PaymentCart;
import org.xproce.datte.dao.entities.Produit;

import java.util.List;

@Component
public interface PaymentManager {

    public PaymentCart creePayment(PaymentCart paymentCart);
    public PaymentCart updatePayment(PaymentCart paymentCart);
    public boolean deletePayment(Integer id);
    public List<PaymentCart> getAllPayment();
    public PaymentCart getPaymentById(Integer id);

}
