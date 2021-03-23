package by.nintendo.springsecuritydemo.controller;

import by.nintendo.springsecuritydemo.entity.MyUser;
import by.nintendo.springsecuritydemo.servise.SessionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/history")
public class HistoryUserCalculatorController {
    private final SessionService sessionService;

    public HistoryUserCalculatorController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping
    public ModelAndView usersHistory(ModelAndView modelAndView) {
        MyUser user = sessionService.getSession();
        modelAndView.setViewName("userHistory");
        modelAndView.addObject("userLogin",user.getLogin());
        modelAndView.addObject("usersHistory", user.getList());
        return modelAndView;
    }
}
