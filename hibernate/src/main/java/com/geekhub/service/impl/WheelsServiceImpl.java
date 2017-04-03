package com.geekhub.service.impl;

import com.geekhub.model.Wheels;
import com.geekhub.repository.WheelsRepository;
import com.geekhub.service.WheelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WheelsServiceImpl implements WheelsService{

    @Autowired
    private WheelsRepository wheelsRepository;

    @Override
    public void addWheels(Wheels wheels) {
        wheelsRepository.save(wheels);
    }

    @Override
    public void deleteWheels(long id) {
        wheelsRepository.delete(id);
    }

    @Override
    public void updateWheels(Wheels wheels) {
        wheelsRepository.update(wheels);
    }

    @Override
    public Wheels getWheelsById(long id) {
        return wheelsRepository.findOne(id);
    }

    @Override
    public List<Wheels> getAllWheels() {
        return wheelsRepository.findAll();
    }
}
