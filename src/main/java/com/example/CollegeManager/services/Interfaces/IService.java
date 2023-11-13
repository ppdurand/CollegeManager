package com.example.CollegeManager.services.Interfaces;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

public interface IService<T> {
    ModelAndView getAll();
    ModelAndView post(T entity, BindingResult bindingResult);
}
