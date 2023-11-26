package com.example.CollegeManager.services.Interfaces;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

public interface IService<T> {
    ModelAndView getAll();

    ModelAndView getById(Long id);

    ModelAndView createPage();

    ModelAndView post(T entity, BindingResult bindingResult);

    ModelAndView deleteById(Long Id);
}
