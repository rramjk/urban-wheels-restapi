package ru.ramazanov.UrbanWheels.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ramazanov.UrbanWheels.models.Car;
import ru.ramazanov.UrbanWheels.models.User;
import ru.ramazanov.UrbanWheels.repositories.CarRepository;
import ru.ramazanov.UrbanWheels.repositories.UserRepository;
import ru.ramazanov.UrbanWheels.util.CarNotFoundException;
import ru.ramazanov.UrbanWheels.util.UserNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    private CarRepository repository;

    @Autowired
    public CarService( CarRepository repository) {
        this.repository = repository;
    }

    public List<Car> getCars() {
        return repository.findAll();
    }

    public Car getCarById(int id) {
        Optional<Car> findingCar = repository.getCarById(id);
        if (findingCar.isEmpty()) {
            throw new CarNotFoundException("Car with entered id is not found!");
        }
        return findingCar.get();
    }
    public void createCar(Car car) {
        repository.save(car);
    }

    public void deleteCarById(int id) {
        Optional<Car> findingCar = repository.getCarById(id);
        if (findingCar.isEmpty()) {
            throw new CarNotFoundException("Car with entered id is not found!");
        }
        repository.deleteById(id);
    }
}
