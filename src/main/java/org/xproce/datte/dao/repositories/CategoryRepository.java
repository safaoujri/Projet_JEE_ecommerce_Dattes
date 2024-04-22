package org.xproce.datte.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.xproce.datte.dao.entities.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
