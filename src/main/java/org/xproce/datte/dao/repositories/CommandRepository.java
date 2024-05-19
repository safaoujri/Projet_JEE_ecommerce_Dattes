package org.xproce.datte.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.xproce.datte.dao.entities.Command;

public interface CommandRepository extends JpaRepository<Command,Integer> {
}
