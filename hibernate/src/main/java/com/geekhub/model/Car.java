package com.geekhub.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_CAR")
public class Car{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String nameCar;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Wheels> wheels;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "engine_id")
    private Engine engine;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCar() {
        return nameCar;
    }

    public void setNameCar(String nameCar) {
        this.nameCar = nameCar;
    }

    public List<Wheels> getWheels() {
        return wheels;
    }

    public void setWheels(List<Wheels> wheels) {
        this.wheels = wheels;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", nameCar='" + nameCar + '\'' +
                ", wheels=" + wheels +
                ", engine=" + engine +
                '}';
    }
}
