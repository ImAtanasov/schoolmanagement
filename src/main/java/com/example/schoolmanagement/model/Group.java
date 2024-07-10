package com.example.schoolmanagement.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "_group") // To avoid SQL keyword conflict
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
