package com.education.liberedu.controller;

import com.education.liberedu.persistence.entity.Parent;
import com.education.liberedu.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/parents")
public class ParentController {
    @Autowired
    private ParentService parentService;

    @PostMapping
    public ResponseEntity<Parent> saveParent(@RequestBody Parent parent) {
        Parent savedParent = parentService.saveParent(parent);
        return ResponseEntity.ok(savedParent);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Parent> findParentById(@PathVariable Long id) {
        Parent parent = parentService.findParentById(id)
                                     .get();
        if (parent != null) {
            return ResponseEntity.ok(parent);
        } else {
            return ResponseEntity.notFound()
                                 .build();
        }
    }

    @GetMapping
    public Optional<List<Parent>> findAllParents() {
        return parentService.findAllParents();
    }

    @PutMapping(path = "/{id}")
    public Parent updateParent(@PathVariable("id") Long id,
                               @RequestBody Parent request) {
        return parentService.updateParent(id, request);
    }

    @DeleteMapping(path = "/{id}")
    public Boolean deleteParent(@PathVariable("id") Long id) {
        return parentService.deleteParent(id);
    }
}
