package com.geekhub.service;

import com.geekhub.model.Wheels;

import java.util.List;

public interface WheelsService {
    void addWheels(Wheels wheels);
    void deleteWheels(long id);
    void updateWheels(Wheels wheels);
    Wheels getWheelsById(long id);
    List<Wheels> getAllWheels();
}
