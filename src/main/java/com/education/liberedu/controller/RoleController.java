package com.education.liberedu.controller;

import com.education.liberedu.persistence.entity.Role;
import com.education.liberedu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        Role savedRole = roleService.saveRole(role);
        return ResponseEntity.ok(savedRole);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> findRoleById(@PathVariable Long id) {
        Role role = roleService.findRoleById(id)
                               .get();
        if (role != null) {
            return ResponseEntity.ok(role);
        } else {
            return ResponseEntity.notFound()
                                 .build();
        }
    }

    @GetMapping
    public Optional<List<Role>> findAllRoles() {
        return roleService.findAllRoles();
    }

    @PutMapping(path = "/{id}")
    public Role updateRole(@PathVariable("id") Long id,
                           @RequestBody Role request) {
        return roleService.updateRole(id, request);
    }

    @DeleteMapping(path = "/{id}")
    public Boolean deleteRole(@PathVariable("id") Long id) {
        return roleService.deleteRole(id);
    }
}