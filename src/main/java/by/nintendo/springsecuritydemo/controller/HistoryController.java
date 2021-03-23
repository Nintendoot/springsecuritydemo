package by.nintendo.springsecuritydemo.controller;

import by.nintendo.springsecuritydemo.storage.HistoryStorage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(path = "/allistory")
public class HistoryController {
    private final HistoryStorage historyStorage;

    public HistoryController(@Qualifier("historyInMemory") HistoryStorage historyStorage) {
        this.historyStorage = historyStorage;
    }

    @GetMapping
    public ModelAndView history(ModelAndView modelAndView) {
        modelAndView.addObject("history", historyStorage.allHistory());
        modelAndView.setViewName("history");
        return modelAndView;
    }
}
