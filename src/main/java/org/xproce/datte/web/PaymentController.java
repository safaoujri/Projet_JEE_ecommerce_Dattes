package org.xproce.datte.web;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.xproce.datte.dao.entities.Command;
import org.xproce.datte.dao.entities.PaymentCart;
import org.xproce.datte.dao.entities.Utilisateur;
import org.xproce.datte.service.PaymentManager;

import java.util.List;

@Controller
public class PaymentController {
    @Autowired
    private PaymentManager paymentManager;

    @PostMapping("/payment")
    public String CreePayment(Model model, @RequestParam(name = "id" ,defaultValue = "") Integer id,
                              @RequestParam(name = "montant") double montant,
                              @RequestParam(name = "cardName") String cardName,
                              @RequestParam(name = "cardNumber") String cardNumber,
                              @RequestParam(name = "expiryMonth") int expiryMonth,
                              @RequestParam(name = "expiryYear") int expiryYear,
                              @RequestParam(name = "commande") Command commande,
                              @RequestParam(name = "customer") Utilisateur customer,
                              @RequestParam(name = "typePaiement") String typePaiement){
        PaymentCart paymentCart =new PaymentCart();
        paymentCart.setMontant(montant);
        paymentCart.setId(id);
        paymentCart.setCardName(cardName);
        paymentCart.setExpiryMonth(expiryMonth);
        paymentCart.setCardNumber(cardNumber);
        paymentCart.setExpiryYear(expiryYear);
        paymentCart.setCustomer(customer);
        paymentCart.setTypePaiement(typePaiement);
        paymentCart.setCommande(commande);
        paymentManager.creePayment(paymentCart);
        return "redirect:/listPayment";

    }
    @PostMapping("/creerOnce")
    public String ajouterProduit(Model model,
                                 @Valid PaymentCart paymentCart,
                                 BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "ajouterpayment" ;
        }

        paymentManager.creePayment(paymentCart);
        return "redirect:listPayment";
    }
    @GetMapping("ajouterpayment")
    public String ajouterpayment(Model model){
        model.addAttribute("payment",new PaymentCart());
        return "ajouterpayment";
    }
    @GetMapping("/listPayment")
    public  String listPayment(Model model){
//        List<PaymentCart> paymentCart =paymentManager.getAllPayment();
//        model.addAttribute("listpay", paymentCart);
        return "paymentLayout";
    }
    @GetMapping("/deletePayment")
    public String deletePayment(Model model, @RequestParam(name = "id") Integer id) {
        if (paymentManager.deletePayment(id)) {
            return "redirect:listPayment";
        } else {
            return "error";
        }
    }
    @GetMapping("/editPayment")
    public String editProduit(Model model, @RequestParam(name = "id") Integer id) {
        PaymentCart payment = paymentManager.getPaymentById(id);
        if (payment != null) {
            model.addAttribute("updatepayment", payment);
            return "updatePayment";
        } else {
            return "error";
        }
    }

}
