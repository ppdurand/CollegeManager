package com.example.CollegeManager.services;

import com.example.CollegeManager.dto.CreateProfessor;
import com.example.CollegeManager.models.Professor;
import com.example.CollegeManager.repository.ProfessorRepository;
import com.example.CollegeManager.services.Interfaces.IService;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

@Service
public class ProfessorService implements IService<CreateProfessor> {

    @Autowired
    private ProfessorRepository professorRepository;
    @Override
    public ModelAndView getAll() {
        return new ModelAndView("professors/index")
                .addObject("professors", this.professorRepository.findAll());
    }

    @Override
    public ModelAndView createPage() {
        return new ModelAndView("professors/new")
                .addObject("createProfessor", new CreateProfessor());
    }

    @Override
    public ModelAndView post(CreateProfessor request, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return new ModelAndView("professors/new")
                    .addObject("createProfessor", new CreateProfessor());
        }
        this.professorRepository.save(request.toProfessor());
        return new ModelAndView("redirect:/professors");
    }

    @Override
    public ModelAndView deleteById(Long id) {
        Professor response = this.professorRepository.findById(id)
                .orElseThrow(() -> new NoResultException("Professor não encontrado"));
        this.professorRepository.delete(response);
        return new ModelAndView("redirect:/professors");
    }
}
