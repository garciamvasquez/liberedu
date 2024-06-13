package com.education.liberedu.service;

import com.education.liberedu.persistence.crud.AdminCrudRepository;
import com.education.liberedu.persistence.crud.RoleCrudRepository;
import com.education.liberedu.persistence.entity.Admin;
import com.education.liberedu.persistence.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminCrudRepository adminCrudRepository;
    @Autowired
    private RoleCrudRepository  roleCrudRepository;

    @Transactional
    public Admin saveAdmin(Admin admin) {

        if (admin.getRoleId() != null) {
            Role role = roleCrudRepository.findById(admin.getRoleId())
                                          .orElseThrow(() -> new RuntimeException(
                                                  "Role not found"));
            admin.setRole(role);
        }
        return adminCrudRepository.save(admin);
    }

    public Optional<Admin> findAdminById(Long id) {
        return adminCrudRepository.findById(id);
    }

    public Optional<List<Admin>> findAllAdmins() {
        return Optional.of(adminCrudRepository.findAll());
    }

    @Transactional
    public Admin updateAdmin(Long id,
                             Admin request) {
        Admin admin = adminCrudRepository.findById(id)
                                         .get();

        admin.setFirstname(request.getFirstname());
        admin.setLastname(request.getLastname());
        admin.setEmail(request.getEmail());

        if (request.getRoleId() != null) {
            Role role = roleCrudRepository.findById(request.getRoleId())
                                          .orElseThrow(
                                                  () -> new RuntimeException("Role not found"));
            admin.setRole(role);
        }

        adminCrudRepository.save(admin);

        return admin;
    }

    public Boolean deleteAdmin(Long id) {
        try {
            adminCrudRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
