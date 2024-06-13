package com.education.liberedu.service;

import com.education.liberedu.persistence.crud.RoleCrudRepository;
import com.education.liberedu.persistence.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private RoleCrudRepository roleCrudRepository;

    @Transactional
    public Role saveRole(Role role) {
        return roleCrudRepository.save(role);
    }

    public Optional<Role> findRoleById(Long id) {
        return roleCrudRepository.findById(id);
    }

    public Optional<List<Role>> findAllRoles() {
        return Optional.of(roleCrudRepository.findAll());
    }

    @Transactional
    public Role updateRole(Long id, Role request) {
        Role role = roleCrudRepository.findById(id).get();

        role.setRole(request.getRole());

        return role;
    }

    public Boolean deleteRole(Long id) {
        try {
            roleCrudRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
