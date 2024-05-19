package org.xproce.datte.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.xproce.datte.dao.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
}
