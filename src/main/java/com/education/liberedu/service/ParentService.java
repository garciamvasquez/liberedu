package com.education.liberedu.service;

import com.education.liberedu.persistence.crud.ParentCrudRepository;
import com.education.liberedu.persistence.entity.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ParentService {
    @Autowired
    private ParentCrudRepository parentCrudRepository;

    @Transactional
    public Parent saveParent(Parent parent) {
        return parentCrudRepository.save(parent);
    }

    public Optional<Parent> findParentById(Long id) {
        return parentCrudRepository.findById(id);
    }

    public Optional<List<Parent>> findAllParents() {
        return Optional.of(parentCrudRepository.findAll());
    }

    @Transactional
    public Parent updateParent(Long id, Parent request) {
        Parent parent = parentCrudRepository.findById(id).get();

        parent.setFirstname(request.getFirstname());
        parent.setLastname(request.getLastname());
        parent.setEmail(request.getEmail());

        return parent;
    }

    public Boolean deleteParent(Long id) {
        try {
            parentCrudRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
