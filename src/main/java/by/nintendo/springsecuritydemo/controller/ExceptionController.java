package by.nintendo.springsecuritydemo.controller;

import by.nintendo.springsecuritydemo.exeption.NoSuchUserExeption;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

@ExceptionHandler(NoSuchUserExeption.class)
public String noUserException(NoSuchUserExeption e, Model model){
        model.addAttribute("errorMessage",e.getMessage());
        return "errorPage";

    }
}
