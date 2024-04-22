package org.xproce.datte.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.xproce.datte.dao.entities.Cart;

public interface CartRepository extends JpaRepository<Cart,Integer> {
}
