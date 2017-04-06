package com.geekhub.controller;

import com.geekhub.model.Tyres;
import com.geekhub.service.TyresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/tyres")
public class TyresController {

    @Autowired
    private TyresService tyresService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String saveTyres(Model model){
        model.addAttribute("tyres", new Tyres());
        return "tyresForm";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveTyres(@ModelAttribute("tyres") @Valid Tyres tyres,
                          BindingResult result){
        if (result.hasErrors()){
            return "tyresForm";
        }
        tyresService.addTyres(tyres);
        return "redirect:/tyres/tyresList";
    }

    @RequestMapping(value = "/tyresList", method = RequestMethod.GET)
    public String tyresList(Model model){
        model.addAttribute("tyres", tyresService.getAllTyres());
        return "tyresList";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Integer id){
        tyresService.deleteTyres(id);
        return "redirect:/tyres/tyresList";
    }

    @RequestMapping(value = "/update/{id}")
    public String update(@PathVariable("id") Integer id, Model model){
        model.addAttribute("tyres", tyresService.getTyresById(id));
        return "tyresForm";
    }

    @RequestMapping(value = "/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model){
        model.addAttribute("tyres", tyresService.getTyresById(id));
        return "tyresDetails";
    }
}
