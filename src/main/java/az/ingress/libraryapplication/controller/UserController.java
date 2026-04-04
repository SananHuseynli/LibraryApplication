package az.ingress.libraryapplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

public class UserController {

    @GetMapping
    public ModelAndView showUser(){
        return new ModelAndView("User");
    }
}
