package com.education.liberedu.persistence.crud;

import com.education.liberedu.persistence.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentCrudRepository extends JpaRepository<Parent, Long> {
}
