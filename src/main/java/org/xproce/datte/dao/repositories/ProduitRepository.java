package org.xproce.datte.dao.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.xproce.datte.dao.entities.Produit;
@Transactional
public interface ProduitRepository extends JpaRepository<Produit,Integer> {
    Page<Produit> findByNomContains(String keyword, Pageable pageable);
    
}
