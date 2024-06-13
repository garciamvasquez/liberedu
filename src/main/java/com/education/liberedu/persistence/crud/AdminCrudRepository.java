package com.education.liberedu.persistence.crud;

import com.education.liberedu.persistence.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminCrudRepository extends JpaRepository<Admin, Long> {
}
