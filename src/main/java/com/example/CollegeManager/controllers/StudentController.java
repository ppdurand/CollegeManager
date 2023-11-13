package com.example.CollegeManager.controllers;

import com.example.CollegeManager.dto.CreateStudent;
import com.example.CollegeManager.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @GetMapping
    public ModelAndView index(){
        return studentService.getAll();
    }

    @GetMapping("/new")
    public ModelAndView create(){
        return this.studentService.createStudent();
    }

    @PostMapping()
    public ModelAndView post(@Valid CreateStudent request, BindingResult bindingResult){
        return this.studentService.post(request, bindingResult);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteById(@PathVariable Long id){
        return this.studentService.deleteById(id);
    }
}
