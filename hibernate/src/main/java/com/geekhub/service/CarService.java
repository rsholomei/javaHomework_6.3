package com.geekhub.service;

import com.geekhub.model.Car;

import java.util.List;

public interface CarService {
    void addCar(Car car);
    void deleteCar(long id);
    void updateCar(Car car);
    Car getCarById(long id);
    List<Car> getAllCar();
}
