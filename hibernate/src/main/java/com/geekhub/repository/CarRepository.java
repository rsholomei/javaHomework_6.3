package com.geekhub.repository;

import com.geekhub.model.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarRepository{

    private final SessionFactory sessionFactory;

    @Autowired
    public CarRepository(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public void save(Car car){
        Session session = sessionFactory.openSession();
        session.save(car);
    }

    public void delete(long id){
        Session session = sessionFactory.getCurrentSession();
        Car object = session.load(Car.class, id);
        session.delete(object);
    }

    public void update(Car car){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(car);
    }

    public Car findOne(long id){
        Session session = sessionFactory.getCurrentSession();
        return session.get(Car.class, id);
    }

    public List<Car> findAll(){
        Session session = sessionFactory.openSession();
        return session.createCriteria(Car.class).list();
    }
}
