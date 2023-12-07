package com.example.softUniProject.model.Entity;

import com.example.softUniProject.model.Enums.RolesEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "user_role")
public class RolesEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RolesEnum role;

    public RolesEnum getRole() {
        return role;
    }

    public RolesEntity setRole(RolesEnum role) {
        this.role = role;
        return this;
    }


    public Long getId() {
        return id;
    }

    public RolesEntity setId(Long id) {
        this.id = id;
        return this;
    }
}
