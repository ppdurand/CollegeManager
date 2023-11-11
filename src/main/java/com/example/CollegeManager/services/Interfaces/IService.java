package com.example.CollegeManager.services.Interfaces;

import org.springframework.web.servlet.ModelAndView;

public interface IService<T> {
    ModelAndView getAll();
}
