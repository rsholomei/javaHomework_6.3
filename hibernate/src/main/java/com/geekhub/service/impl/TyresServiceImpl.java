package com.geekhub.service.impl;

import com.geekhub.model.Tyres;
import com.geekhub.repository.TyresRepository;
import com.geekhub.service.TyresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TyresServiceImpl implements TyresService{

    @Autowired
    private TyresRepository tyresRepository;

    @Override
    public Tyres addTyres(Tyres tyres) {
        return tyresRepository.save(tyres);
    }

    @Override
    public void deleteTyres(long id) {
        tyresRepository.delete(id);
    }

    @Override
    public Tyres updateTyres(Tyres tyres) {
        return tyresRepository.save(tyres);
    }

    @Override
    public Tyres getTyresById(long id) {
        return tyresRepository.findOne(id);
    }

    @Override
    public List<Tyres> getAllTyres() {
        return (List<Tyres>) tyresRepository.findAll();
    }
}
