package com.geekhub.service;

import com.geekhub.model.Engine;

import java.util.List;

public interface EngineService {
    Engine addEngine(Engine engine);
    void deleteEngine(long id);
    Engine updateEngine(Engine engine);
    Engine getEngineById(long id);
    List<Engine> getAllEngine();
}
