package com.example.CollegeManager.services;

import com.example.CollegeManager.dto.CreateStudent;
import com.example.CollegeManager.models.Student;
import com.example.CollegeManager.repository.StudentRepository;
import com.example.CollegeManager.services.Interfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

@Service
public class StudentService implements IService<CreateStudent> {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public ModelAndView getAll() {
        return new ModelAndView("students/index")
                .addObject("students", studentRepository.findAll());
    }

    public ModelAndView createStudent(){
        return new ModelAndView("students/new")
                .addObject("createStudent", new CreateStudent());
    }

    @Override
    public ModelAndView post(CreateStudent request, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return new ModelAndView("students/new");
        }
        this.studentRepository.save(request.toStudent());
        return new ModelAndView("redirect:/students");
    }
}
