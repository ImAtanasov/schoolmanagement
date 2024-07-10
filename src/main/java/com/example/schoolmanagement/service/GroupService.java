package com.example.schoolmanagement.service;

import com.example.schoolmanagement.model.Group;
import com.example.schoolmanagement.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public Group addGroup(Group group) {
        return groupRepository.save(group);
    }

    public Group updateGroup(Long id, Group group) {
        group.setId(id);
        return groupRepository.save(group);
    }

    public void deleteGroup(Long id) {
        groupRepository.deleteById(id);
    }
}
