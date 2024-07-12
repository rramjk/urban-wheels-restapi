package ru.ramazanov.UrbanWheels.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Component
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    @Size(min = 1, max = 45, message = "Value size between 1 and 45")
    private String name;
    @Size(min = 1, max = 45, message = "Value size between 1 and 45")
    @Column(name = "last_name")
    private String lastName;
    @Size(min = 1, max = 45, message = "Value size between 1 and 45")
    @Column(name = "email")
    @Email(message = "This field must be Email!")
    private String email;
    @Size(min = 1, max = 10, message = "Value size between 1 and 10")
    @Column(name = "passport_id")
    private String passport;
    @Size(min = 1, max = 10, message = "Value size between 1 and 10")
    @Column(name = "driving_licence")
    private String driverLicence;
    @Size(min = 1, max = 300, message = "Value size between 1 and 300")
    @Column(name = "photo_link")
    private String photo;
    @ManyToOne
    @JoinColumn(name = "role")
    private Role role;
    @Column(name = "password")
    @Size(min = 1, max = 45, message = "Value size between 1 and 45")
    private String password;

    public User() {
    }

    public User(int id, String name, String lastName, String email, String passport, String driverLicence, String photo, Role role, String password) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.passport = passport;
        this.driverLicence = driverLicence;
        this.photo = photo;
        this.role = role;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getDriverLicence() {
        return driverLicence;
    }

    public void setDriverLicence(String driverLicence) {
        this.driverLicence = driverLicence;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", passport='" + passport + '\'' +
                ", driverLicence='" + driverLicence + '\'' +
                ", photo='" + photo + '\'' +
                ", role=" + role +
                ", password='" + password + '\'' +
                '}';
    }
}
