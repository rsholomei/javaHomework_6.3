package com.geekhub.service;

import com.geekhub.model.Tyres;

import java.util.List;

public interface TyresService {
    Tyres addTyres(Tyres tyres);
    void deleteTyres(long id);
    Tyres updateTyres(Tyres tyres);
    Tyres getTyresById(long id);
    List<Tyres> getAllTyres();
}
