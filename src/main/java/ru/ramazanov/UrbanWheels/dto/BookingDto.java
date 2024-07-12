package ru.ramazanov.UrbanWheels.dto;

import org.springframework.stereotype.Component;
import ru.ramazanov.UrbanWheels.models.Car;
import ru.ramazanov.UrbanWheels.models.User;

import javax.persistence.*;
import java.util.Date;

@Component
public class BookingDto {
    private int id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
    @Column(name = "date_for_start")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "date_for_end")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    public BookingDto() {
    }

    public BookingDto(int id, User user, Car car, Date startDate, Date endDate) {
        this.id = id;
        this.user = user;
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "CarBooking{" +
                "id=" + id +
                ", user=" + user +
                ", car=" + car +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
