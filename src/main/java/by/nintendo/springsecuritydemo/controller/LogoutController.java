package by.nintendo.springsecuritydemo.controller;

import by.nintendo.springsecuritydemo.entity.MyUser;
import by.nintendo.springsecuritydemo.entity.Role;
import by.nintendo.springsecuritydemo.servise.SessionService;
import by.nintendo.springsecuritydemo.storage.HistoryStorage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/myLogout")
public class LogoutController {
    private final SessionService sessionService;
    private final HistoryStorage historyStorage;

    public LogoutController(SessionService sessionService, HistoryStorage historyStorage) {
        this.sessionService = sessionService;
        this.historyStorage = historyStorage;
    }

    @GetMapping
    public ModelAndView logout(HttpSession session, ModelAndView modelAndView) {
        MyUser user = sessionService.getSession();
        if (!user.getRole().equals(Role.ADMIN)) {
            historyStorage.addInHistory(user);
        }
        session.invalidate();
        modelAndView.setViewName("redirect:index");
        return modelAndView;
    }
}
