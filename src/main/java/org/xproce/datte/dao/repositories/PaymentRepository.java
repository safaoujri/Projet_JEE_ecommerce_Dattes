package org.xproce.datte.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.xproce.datte.dao.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
}
