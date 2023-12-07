package com.example.softUniProject.model.Entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "user_activation_codes")
public class UserActivationLinkEntity extends BaseEntity {
    private String activationCode;
    private Instant created;
    @ManyToOne
    private UserEntity user;

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
