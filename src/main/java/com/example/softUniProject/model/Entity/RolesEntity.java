package com.example.softUniProject.model.Entity;

import com.example.softUniProject.model.Enums.RolesEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_role")
public class RolesEntity extends BaseEntity{
    public RolesEnum getRole() {
        return role;
    }

    public void setRole(RolesEnum role) {
        this.role = role;
    }

    @Enumerated(EnumType.STRING)
    private RolesEnum role;
}