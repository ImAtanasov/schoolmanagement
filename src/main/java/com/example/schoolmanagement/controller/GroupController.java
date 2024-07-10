package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.model.Group;
import com.example.schoolmanagement.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping("/all")
    public List<Group> getAllGroups() {
        return groupService.getAllGroups();
    }

    @PostMapping
    public Group addGroup(@RequestBody Group group) {
        return groupService.addGroup(group);
    }

    @PutMapping("/{id}")
    public Group updateGroup(@PathVariable Long id, @RequestBody Group group) {
        return groupService.updateGroup(id, group);
    }

    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable Long id) {
        groupService.deleteGroup(id);
    }
}
