package com.example.CollegeManager.services;


import com.example.CollegeManager.dto.CreateCourse;
import com.example.CollegeManager.dto.EditStudent;
import com.example.CollegeManager.models.Course;
import com.example.CollegeManager.repository.CourseRepository;
import com.example.CollegeManager.repository.ProfessorRepository;
import com.example.CollegeManager.services.Interfaces.IService;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

@Service
public class CourseService implements IService<CreateCourse, EditStudent> {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public ModelAndView getAll() {
        return new ModelAndView("courses/index")
                .addObject("courses", this.courseRepository.findAll());
    }

    @Override
    public ModelAndView getById(Long id) {
        return this.courseRepository.findById(id)
                .map(course -> new ModelAndView("courses/show")
                        .addObject("course", course))
                .orElseGet(() -> new ModelAndView("redirect:/courses")
                        .addObject("courses", this.courseRepository.findAll()));
    }

    @Override
    public ModelAndView createPage() {
        return new ModelAndView("courses/new")
                .addObject("createCourse", new CreateCourse())
                .addObject("professors", this.professorRepository.findAll());
    }

    @Override
    public ModelAndView post(CreateCourse request, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return new ModelAndView("courses/new")
                    .addObject("createCourse", new CreateCourse())
                    .addObject("professors", this.professorRepository.findAll());
        }
        this.courseRepository.save(request.toCourse(request.getProfessor()));
        return new ModelAndView("redirect:/courses");
    }

    @Override
    public ModelAndView editPage(Long id, EditStudent entity) {
        return null;
    }

    @Override
    public ModelAndView update(Long id, EditStudent entity, BindingResult bindingResult) {
        return null;
    }

    @Override
    public ModelAndView deleteById(Long id) {
        Course response = this.courseRepository.findById(id)
                .orElseThrow(() -> new NoResultException("Cadeira nao encontrada"));
        this.courseRepository.delete(response);
        return new ModelAndView("redirect:/courses");
    }
}
