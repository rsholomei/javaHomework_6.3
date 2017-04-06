package com.geekhub.controller;

import com.geekhub.model.*;
import com.geekhub.service.CarService;
import com.geekhub.service.EngineService;
import com.geekhub.service.TyresService;
import com.geekhub.service.WheelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private WheelsService wheelsService;

    @Autowired
    private EngineService engineService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String saveCar(Model model){
        model.addAttribute("car", new CarForm());
        return "carForm";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveCar(@ModelAttribute("car") CarForm car,
                            BindingResult result){
        if (result.hasErrors()){
            return "carForm";
        }
        Car car1 = new Car();
        car1.setNameCar(car.getNameCar());
        List<Wheels> wheelsList = Arrays.asList(wheelsService.getWheelsById(car.getWheels()));
        car1.setWheels(wheelsList);
        Engine engine = engineService.getEngineById(car.getEngine());
        car1.setEngine(engine);
        carService.addCar(car1);
        return "redirect:/car/carList";
    }

    @RequestMapping(value = "/carList", method = RequestMethod.GET)
    public String carList(Model model){
        model.addAttribute("car", carService.getAllCar());
        return "carList";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Integer id){
        carService.deleteCar(id);
        return "redirect:/car/carList";
    }

    @RequestMapping(value = "/update/{id}")
    public String update(@PathVariable("id") Integer id, Model model){
        model.addAttribute("car", carService.getCarById(id));
        return "carForm";
    }

    @RequestMapping(value = "/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model){
        model.addAttribute("car", carService.getCarById(id));
        return "carDetails";
    }
}
