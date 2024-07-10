package com.example.schoolmanagement.repository;

import com.example.schoolmanagement.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
