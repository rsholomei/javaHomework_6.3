package com.geekhub;

import com.geekhub.model.Car;
import com.geekhub.model.Engine;
import com.geekhub.model.Tyres;
import com.geekhub.model.Wheels;
import com.geekhub.service.CarService;
import com.geekhub.service.EngineService;
import com.geekhub.service.TyresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private CarService carService;

    @Autowired
    private TyresService tyresService;

    @Autowired
    private EngineService engineService;

    @RequestMapping("/")
    @ResponseBody
    public String addCar(){

        Tyres tyres = new Tyres();
        tyres.setSizeTyres(20);
        tyres.setNameTyres("Matador");
        tyresService.addTyres(tyres);
        Tyres tyres1 = tyresService.getTyresById(1);

        Engine engine = new Engine();
        engine.setEngineСapacity(17.4);
        engineService.addEngine(engine);
        Engine engine1 = engineService.getEngineById(1);

        Car car = new Car();
        car.setId(1L);

        Wheels wheels = new Wheels();
        wheels.setTyres(tyres1);
        wheels.setCar(car);

        List<Wheels> wheelsList = new ArrayList<>();
        wheelsList.add(wheels);
        wheelsList.add(wheels);
        wheelsList.add(wheels);
        wheelsList.add(wheels);

        car.setNameCar("Honda");
        car.setWheels(wheelsList);
        car.setEngine(engine1);
        carService.addCar(car);
        return carService.getAllCar().toString();
    }
}
