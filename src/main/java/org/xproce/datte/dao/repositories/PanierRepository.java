package org.xproce.datte.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.xproce.datte.dao.entities.Panier;

import java.util.Optional;

public interface PanierRepository extends JpaRepository<Panier,Integer> {
    Optional<Panier> findByProduitId(Integer produitId);

}
