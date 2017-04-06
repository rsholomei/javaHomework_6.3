package com.geekhub.controller;

import com.geekhub.model.Engine;
import com.geekhub.service.EngineService;
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
@RequestMapping("/engine")
public class EngineController {

    @Autowired
    private EngineService engineService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String saveEngine(Model model){
        model.addAttribute("engine", new Engine());
        return "engineForm";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveEngine(@ModelAttribute("engine") @Valid Engine engine,
                            BindingResult result){
        if (result.hasErrors()){
            return "engineForm";
        }
        engineService.addEngine(engine);
        return "redirect:/engine/engineList";
    }

    @RequestMapping(value = "/engineList", method = RequestMethod.GET)
    public String engineList(Model model){
        model.addAttribute("engine", engineService.getAllEngine());
        return "engineList";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Integer id){
        engineService.deleteEngine(id);
        return "redirect:/engine/engineList";
    }

    @RequestMapping(value = "/update/{id}")
    public String update(@PathVariable("id") Integer id, Model model){
        model.addAttribute("engine", engineService.getEngineById(id));
        return "engineForm";
    }

    @RequestMapping(value = "/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model){
        model.addAttribute("engine", engineService.getEngineById(id));
        return "engineDetails";
    }
}
