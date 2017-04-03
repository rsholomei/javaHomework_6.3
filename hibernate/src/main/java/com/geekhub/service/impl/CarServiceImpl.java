package com.geekhub.service.impl;

import com.geekhub.model.Car;
import com.geekhub.repository.CarRepository;
import com.geekhub.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CarServiceImpl implements CarService{

    @Autowired
    private CarRepository carRepository;

    @Override
    public void addCar(Car car) {
         carRepository.save(car);
    }

    @Override
    public void deleteCar(long id) {
        carRepository.delete(id);
    }

    @Override
    public void updateCar(Car car) {
        carRepository.update(car);
    }

    @Override
    public Car getCarById(long id) {
        return carRepository.findOne(id);
    }

    @Override
    public List<Car> getAllCar() {
        return carRepository.findAll();
    }
}
