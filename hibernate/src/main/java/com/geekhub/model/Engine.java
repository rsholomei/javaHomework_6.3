package com.geekhub.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_ENGINE")
public class Engine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "capacity")
    private Double engineСapacity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getEngineСapacity() {
        return engineСapacity;
    }

    public void setEngineСapacity(Double engineСapacity) {
        this.engineСapacity = engineСapacity;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "id=" + id +
                ", engineСapacity=" + engineСapacity +
                '}';
    }
}
