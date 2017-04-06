package com.geekhub.controller;

import com.geekhub.model.Tyres;
import com.geekhub.model.Wheels;
import com.geekhub.service.TyresService;
import com.geekhub.service.WheelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/wheels")
public class WheelsController {

    @Autowired
    private WheelsService wheelsService;

    @Autowired
    private TyresService tyresService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String saveWheels(Model model){
        model.addAttribute("tyres", tyresService.getAllTyres());
        return "wheelsForm";
    }

    @RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
    public String saveWheels(@PathVariable("id") Integer id){
        Tyres tyres = tyresService.getTyresById(id);
        Wheels wheels = new Wheels();
        wheels.setTyres(tyres);
        wheelsService.addWheels(wheels);
        return "redirect:/wheels/wheelsList";
    }

    @RequestMapping(value = "/wheelsList", method = RequestMethod.GET)
    public String wheelsList(Model model){
        model.addAttribute("wheels", wheelsService.getAllWheels());
        return "wheelsList";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Integer id){
        wheelsService.deleteWheels(id);
        return "redirect:/wheels/wheelsList";
    }

    @RequestMapping(value = "/update/{id}")
    public String update(@PathVariable("id") Integer id, Model model){
        model.addAttribute("wheels", wheelsService.getWheelsById(id));
        return "wheelsForm";
    }

    @RequestMapping(value = "/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model){
        model.addAttribute("wheels", wheelsService.getWheelsById(id));
        return "wheelsDetails";
    }
}
