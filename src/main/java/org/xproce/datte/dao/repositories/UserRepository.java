package org.xproce.datte.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.xproce.datte.dao.entities.Utilisateur;

public interface UserRepository extends JpaRepository<Utilisateur,Integer> {
}
