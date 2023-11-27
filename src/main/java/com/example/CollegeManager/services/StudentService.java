package com.example.CollegeManager.services;

import com.example.CollegeManager.dto.CreateStudent;
import com.example.CollegeManager.dto.EditStudent;
import com.example.CollegeManager.models.Student;
import com.example.CollegeManager.repository.CourseRepository;
import com.example.CollegeManager.repository.StudentRepository;
import com.example.CollegeManager.services.Interfaces.IService;
import jakarta.persistence.NoResultException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

@Service
public class StudentService implements IService<CreateStudent, EditStudent> {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public ModelAndView getAll() {
        return new ModelAndView("students/index")
                .addObject("students", studentRepository.findAll());
    }

    @Override
    public ModelAndView getById(Long id) {
        return this.studentRepository.findById(id)
                .map(student -> new ModelAndView("students/show")
                        .addObject("student", student))
                .orElseGet(() -> new ModelAndView("redirect:/students")
                        .addObject("students", this.studentRepository.findAll()));
    }

    @Override
    public ModelAndView createPage() {
        return new ModelAndView("students/new")
                .addObject("createStudent", new CreateStudent())
                .addObject("courses", courseRepository.findAll());
    }

    @Override
    public ModelAndView post(CreateStudent request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("students/new")
                    .addObject("createStudent", new CreateStudent())
                    .addObject("courses", courseRepository.findAll());
        }
        this.studentRepository.save(request.toStudent());
        return new ModelAndView("redirect:/students");
    }

    @Override
    public ModelAndView editPage(Long id, EditStudent entity) {
        return studentRepository.findById(id)
                .map(student -> {
                    entity.fromStudent(student);
                    return new ModelAndView("students/edit")
                            .addObject("editStudent", entity)
                            .addObject("courses", courseRepository.findAll());
                })
                .orElseGet(() -> new ModelAndView("redirect:/students"));
    }
    @Override
    public ModelAndView update(Long id, @Valid EditStudent entity, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return getAll();
        }
        return this.studentRepository.findById(id).map(student ->{
                this.studentRepository.save(entity.toStudent(student));
                return new ModelAndView("redirect:/students");
        }).orElseGet(() -> new ModelAndView("redirect:/students"));
    }

    @Override
    public ModelAndView deleteById(Long id) {
        Student response = this.studentRepository.findById(id)
                .orElseThrow(() -> new NoResultException("Estudante nao encontrado"));
        this.studentRepository.delete(response);
        return new ModelAndView("redirect:/students");
    }
}
