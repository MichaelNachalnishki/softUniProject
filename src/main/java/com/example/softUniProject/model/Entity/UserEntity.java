package com.example.softUniProject.model.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.util.ArrayList;
import java.util.List;

@Entity
public class UserEntity extends BaseEntity{

    @Column(unique = true, nullable = false)
    @Email
    private String email;
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String username;
    @ManyToMany(fetch = FetchType.EAGER)
    @Column(nullable = false)
    private List<RolesEntity> roles = new ArrayList<>();
    @ManyToMany
    private List<WrittenStoriesEntity> writtenStories;
@Column(name = "is_active")
    private boolean isActive;

    public boolean isActive() {
        return isActive;
    }

    public UserEntity setActive(boolean active) {
        this.isActive= active;
        return this;
    }


    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public List<RolesEntity> getRoles() {
        return roles;
    }

    public UserEntity setRoles(List<RolesEntity> roles) {
        this.roles = roles;
        return this;
    }

    public List<WrittenStoriesEntity> getWrittenStories() {
        return writtenStories;
    }

    public UserEntity setWrittenStories(List<WrittenStoriesEntity> writtenStories) {
        this.writtenStories = writtenStories;
        return this;
    }


}
