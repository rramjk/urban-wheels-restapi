package ru.ramazanov.UrbanWheels.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.ramazanov.UrbanWheels.dto.CarDto;
import ru.ramazanov.UrbanWheels.dto.UserDto;
import ru.ramazanov.UrbanWheels.models.Car;
import ru.ramazanov.UrbanWheels.models.User;
import ru.ramazanov.UrbanWheels.services.CarService;
import ru.ramazanov.UrbanWheels.services.UserService;
import ru.ramazanov.UrbanWheels.util.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/")
public class ApiRestController {
    private UserService userService;
    private ModelMapper modelMapper;
    private UserValidator validator;
    private CarService carService;

    @Autowired
    public ApiRestController(UserService userService, ModelMapper modelMapper, UserValidator validator, CarService carService) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.validator = validator;
        this.carService = carService;
    }

    @GetMapping("/users")
    public List<UserDto> getUsers() {
        return userService.getUsers().stream().map(this::convertToUserDto).collect(Collectors.toList());
    }

    @GetMapping("/users/{id}")
    public UserDto getUserById(@PathVariable int id) {
        return convertToUserDto(userService.getUserById(id));
    }

    @PostMapping("/users")
    public ResponseEntity<HttpStatus> createUser(@RequestBody @Valid UserDto userDto,
                                                 BindingResult result) {
        User user = convertToUser(userDto);
        validator.validate(user, result);
        if (result.hasErrors()) {
            throw new UserHasInvalidValuesException("Invalid values!");
        }

        userService.createUser(user);
        return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
    }
    @PatchMapping("/users/{id}")
    public ResponseEntity<HttpStatus> editUser(@PathVariable int id, @RequestBody @Valid UserDto userDto,
                                                 BindingResult result) {
        User user = convertToUser(userDto);
        user.setId(id);
        validator.validate(user, result);
        if (result.hasErrors()) {
            throw new UserHasInvalidValuesException("Invalid values!");
        }

        userService.createUser(user);
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable int id) {
        userService.deleteUserById(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }
    @GetMapping("/cars")
    public List<CarDto> getCars() {
        return carService.getCars().stream().map(this::convertToCarDto).collect(Collectors.toList());
    }

    @GetMapping("/cars/{id}")
    public CarDto getCarById(@PathVariable int id) {
        return convertToCarDto(carService.getCarById(id));
    }

    @PostMapping("/cars")
    public ResponseEntity<HttpStatus> createCar(@RequestBody @Valid CarDto carDto,
                                                 BindingResult result) {
        Car car = convertToCar(carDto);
        if (result.hasErrors()) {
            throw new UserHasInvalidValuesException("Invalid values!");
        }

        carService.createCar(car);
        return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
    }
    @PatchMapping("/cars/{id}")
    public ResponseEntity<HttpStatus> editCar(@PathVariable int id, @RequestBody @Valid CarDto carDto,
                                               BindingResult result) {
        Car car = convertToCar(carDto);
        car.setId(id);
        if (result.hasErrors()) {
            throw new UserHasInvalidValuesException("Invalid values!");
        }

        carService.createCar(car);
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }
    @DeleteMapping("/cars/{id}")
    public ResponseEntity<HttpStatus> deleteCar(@PathVariable int id) {
        carService.deleteCarById(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> userNotFound(UserNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> userHasInvalidValues(UserHasInvalidValuesException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> userNotFound(CarNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> userHasInvalidValues(CarHasInvalidValueException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    private UserDto convertToUserDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    private User convertToUser(UserDto userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

    private CarDto convertToCarDto(Car car) {
        return modelMapper.map(car, CarDto.class);
    }

    private Car convertToCar(CarDto carDto) {
        return modelMapper.map(carDto, Car.class);
    }

}
