package com.education.liberedu.persistence.crud;

import com.education.liberedu.persistence.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleCrudRepository extends JpaRepository<Role, Long> {
}
