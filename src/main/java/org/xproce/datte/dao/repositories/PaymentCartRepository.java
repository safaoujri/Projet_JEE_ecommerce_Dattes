package org.xproce.datte.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.xproce.datte.dao.entities.PaymentCart;

public interface PaymentCartRepository extends JpaRepository<PaymentCart,Integer> {
}
