package com.education.liberedu.controller;

import com.education.liberedu.service.GroupService;
import com.education.liberedu.persistence.entity.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/groups")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @PostMapping
    public Group saveGroup(@RequestBody Group group) {
        return groupService.save(group);
    }

    @GetMapping
    public Optional<List<Group>> findAllGroups() {
        return groupService.findAll();
    }

    @RequestMapping(path = "/{id}")
    public Optional<Group> findGroup(@PathVariable("id") Long id) {
        return groupService.findById(id);
    }

    @PutMapping(path = "/{id}")
    public Group updateGroup(@PathVariable("id") Long id,
                             @RequestBody Group request) {
        return groupService.update(id, request);
    }

    @DeleteMapping(path = "/{id}")
    public Boolean deleteGroup(@PathVariable("id") Long id) {
        return groupService.deleteById(id);
    }
}
