package ru.ramazanov.UrbanWheels.dto;

import org.springframework.stereotype.Component;
import ru.ramazanov.UrbanWheels.models.Location;
import ru.ramazanov.UrbanWheels.models.Status;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Component
public class CarDto {
    private int id;
    @Column(name = "maker")
    @NotEmpty(message = "Value can`t be empty!")
    @Size(min = 1, max = 45, message = "Value size between 1 and 45")
    private String maker;
    @Column(name = "model")
    @NotEmpty(message = "Value can`t be empty!")
    @Size(min = 1, max = 45, message = "Value size between 1 and 45")
    private String model;
    @Column(name = "price_for_day")
    @Min(value = 1, message = "Min value of price is 1")
    private int dayPrice;
    @ManyToOne
    @JoinColumn(name = "status")
    private Status status;
    @ManyToOne
    @JoinColumn(name = "location")
    private Location location;

    public CarDto() {
    }

    public CarDto(int id, String maker, String model, int dayPrice, Status status, Location location) {
        this.id = id;
        this.maker = maker;
        this.model = model;
        this.dayPrice = dayPrice;
        this.status = status;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getDayPrice() {
        return dayPrice;
    }

    public void setDayPrice(int dayPrice) {
        this.dayPrice = dayPrice;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
