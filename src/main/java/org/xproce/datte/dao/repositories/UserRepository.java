package org.xproce.datte.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.xproce.datte.dao.entities.User;

public interface UserRepository extends JpaRepository<User,Integer> {
}
