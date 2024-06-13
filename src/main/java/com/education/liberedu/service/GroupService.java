package com.education.liberedu.service;

import com.education.liberedu.persistence.crud.GroupCrudRepository;
import com.education.liberedu.persistence.entity.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService
{
    @Autowired
    private GroupCrudRepository groupCrudRepository;
    
    public Group save(Group group) {
        return groupCrudRepository.save(group);
    }
    
    public Optional<List<Group>> findAll() {
        return Optional.of(groupCrudRepository.findAll());
    }
    
    public Optional<Group> findById(Long id) {
        return groupCrudRepository.findById(id);
    }
    
    public Optional<Group> findByTeacherId(Long teacherId) {
        return groupCrudRepository.findByTeacherId(teacherId);
    }
    
    public Group update(Long id, Group request) {
        Group group = groupCrudRepository.findById(id).get();
        
        group.setGroupname(request.getGroupname());
        
        return group;
    }
    
    public Boolean deleteById(Long id) {
        try {
            groupCrudRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
