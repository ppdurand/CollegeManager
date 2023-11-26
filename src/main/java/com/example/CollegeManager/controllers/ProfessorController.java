package com.example.CollegeManager.controllers;

import com.example.CollegeManager.dto.CreateProfessor;
import com.example.CollegeManager.services.ProfessorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/professors")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public ModelAndView index(){
        return this.professorService.getAll();
    }

    @GetMapping("/show/{id}")
    public ModelAndView getById(@PathVariable Long id){
        return this.professorService.getById(id);
    }

    @GetMapping("/new")
    public ModelAndView getAll(){
        return this.professorService.createPage();
    }

    @PostMapping()
    public ModelAndView post(@Valid CreateProfessor createProfessor, BindingResult bindingResult){
        return this.professorService.post(createProfessor, bindingResult);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteById(@PathVariable Long id){
        return this.professorService.deleteById(id);
    }
}
