package com.geekhub.repository;

import com.geekhub.model.Wheels;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WheelsRepository{

    private final SessionFactory sessionFactory;

    @Autowired
    public WheelsRepository(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public void save(Wheels wheels){
        Session session = sessionFactory.openSession();
        session.save(wheels);
    }

    public void delete(long id){
        Session session = sessionFactory.getCurrentSession();
        Wheels object = session.load(Wheels.class, id);
        session.delete(object);
    }

    public void update(Wheels wheels){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(wheels);
    }

    public Wheels findOne(long id){
        Session session = sessionFactory.getCurrentSession();
        return session.get(Wheels.class, id);
    }

    public List<Wheels> findAll(){
        Session session = sessionFactory.openSession();
        return session.createCriteria(Wheels.class).list();
    }
}
