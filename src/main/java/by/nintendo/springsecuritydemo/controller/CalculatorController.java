package by.nintendo.springsecuritydemo.controller;

import by.nintendo.springsecuritydemo.entity.Calculator;
import by.nintendo.springsecuritydemo.entity.MyUser;
import by.nintendo.springsecuritydemo.servise.CalculatorService;
import by.nintendo.springsecuritydemo.servise.SessionService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(path = "/calc")
public class CalculatorController {
    private final SessionService sessionService;
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService, SessionService sessionService) {
        this.calculatorService = calculatorService;
        this.sessionService = sessionService;
    }

    @GetMapping
    public ModelAndView culcView(ModelAndView modelAndView, @ModelAttribute("user") MyUser user) {
        modelAndView.addObject("newCalculator", new Calculator());
        modelAndView.setViewName("calculator");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView calculayor(@Valid @ModelAttribute("newCalculator") Calculator calculator, BindingResult result, ModelAndView modelAndView) {
        MyUser user = sessionService.getSession();
        if (result.hasErrors()) {
            Map<String, String> errorsCalc = new HashMap<>();
            for (FieldError fieldError : result.getFieldErrors()) {
                errorsCalc.put(fieldError.getField(), fieldError.getDefaultMessage());
                modelAndView.setViewName("calculator");
            }
        } else {
            calculatorService.calc(calculator);
            user.getList().add(calculator);
            modelAndView.addObject("result", calculator.getResult());
            modelAndView.setViewName("calculator");
        }
        return modelAndView;
    }
}
