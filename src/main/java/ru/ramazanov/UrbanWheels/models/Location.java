package ru.ramazanov.UrbanWheels.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "city")
    @NotEmpty(message = "Value can`t be empty!")
    @Size(min = 1, max = 100, message = "Value size between 1 and 100")
    private String city;
    @Column(name = "address")
    @NotEmpty(message = "Value can`t be empty!")
    @Size(min = 1, max = 300, message = "Value size between 1 and 300")
    private String address;

    public Location() {

    }

    public Location(int id, String city, String address) {
        this.id = id;
        this.city = city;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
