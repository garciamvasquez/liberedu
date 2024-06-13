package com.education.liberedu.controller;

import com.education.liberedu.persistence.entity.Admin;
import com.education.liberedu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping
    public ResponseEntity<Admin> saveAdmin(@RequestBody Admin admin) {
        Admin savedAdmin = adminService.saveAdmin(admin);
        return ResponseEntity.ok(savedAdmin);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> findAdminById(@PathVariable Long id) {
        Admin admin = adminService.findAdminById(id)
                                  .get();
        if (admin != null) {
            return ResponseEntity.ok(admin);
        } else {
            return ResponseEntity.notFound()
                                 .build();
        }
    }

    @GetMapping
    public Optional<List<Admin>> findAllAdmins() {
        return adminService.findAllAdmins();
    }

    @PutMapping(path = "/{id}")
    public Admin updateAdmin(@PathVariable("id") Long id,
                             @RequestBody Admin request) {
        return adminService.updateAdmin(id, request);
    }

    @DeleteMapping(path = "/{id}")
    public Boolean deleteAdmin(@PathVariable("id") Long id) {
        return adminService.deleteAdmin(id);
    }
}
