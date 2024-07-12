package ru.ramazanov.UrbanWheels.dto;

import org.springframework.stereotype.Component;

import javax.persistence.Column;

@Component
public class RoleDto {
    private int id;
    @Column(name = "role")
    private String role;

    public RoleDto() {
    }

    public RoleDto(int id, String role) {
        this.id = id;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }
}
