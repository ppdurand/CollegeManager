package com.example.CollegeManager.services;

import com.example.CollegeManager.models.Student;
import com.example.CollegeManager.repository.StudentRepository;
import com.example.CollegeManager.services.Interfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class StudentService implements IService<Student> {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public ModelAndView getAll() {
        return new ModelAndView("students/index")
                .addObject("students", studentRepository.findAll());
    }
}
