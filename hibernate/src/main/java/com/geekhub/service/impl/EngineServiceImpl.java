package com.geekhub.service.impl;

import com.geekhub.model.Engine;
import com.geekhub.repository.EngineRepository;
import com.geekhub.service.EngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EngineServiceImpl implements EngineService {

    @Autowired
    private EngineRepository engineRepository;

    @Override
    public Engine addEngine(Engine engine) {
        return engineRepository.save(engine);
    }

    @Override
    public void deleteEngine(long id) {
        engineRepository.delete(id);
    }

    @Override
    public Engine updateEngine(Engine engine) {
        return engineRepository.save(engine);
    }

    @Override
    public Engine getEngineById(long id) {
        return engineRepository.findOne(id);
    }

    @Override
    public List<Engine> getAllEngine() {
        return (List<Engine>) engineRepository.findAll();
    }
}
