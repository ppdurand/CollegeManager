package com.example.CollegeManager.controllers;

import com.example.CollegeManager.dto.CreateCourse;
import com.example.CollegeManager.models.Course;
import com.example.CollegeManager.repository.CourseRepository;
import com.example.CollegeManager.services.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @GetMapping
    public ModelAndView index(){
        return this.courseService.getAll();
    }

    @GetMapping("/new")
    public ModelAndView createPage(){
        return this.courseService.createPage();
    }

    @PostMapping()
    public ModelAndView post(@Valid CreateCourse request, BindingResult bindingResult){
        return this.courseService.post(request, bindingResult);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteById(@PathVariable Long id){
        return this.courseService.deleteById(id);
    }
}
