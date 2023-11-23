package com.example.softUniProject.model.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class UserEntity extends BaseEntity{

    @Column(unique = true)
    private String email;
    private String password;
    private String username;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<RolesEntity> roles = new ArrayList<>();
    @ManyToMany
    private List<WrittenStoriesEntity> writtenStories;
    @ManyToMany
    private List<ReadStoriesEntity> readStories;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<RolesEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RolesEntity> roles) {
        this.roles = roles;
    }

    public List<WrittenStoriesEntity> getWrittenStories() {
        return writtenStories;
    }

    public void setWrittenStories(List<WrittenStoriesEntity> writtenStories) {
        this.writtenStories = writtenStories;
    }

    public List<ReadStoriesEntity> getReadStories() {
        return readStories;
    }

    public void setReadStories(List<ReadStoriesEntity> readStories) {
        this.readStories = readStories;
    }
}
