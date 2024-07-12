package ru.ramazanov.UrbanWheels.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ramazanov.UrbanWheels.models.Car;
import ru.ramazanov.UrbanWheels.models.User;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    Optional<Car> getCarById(int id);
}
