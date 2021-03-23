package by.nintendo.springsecuritydemo.controller;

import by.nintendo.springsecuritydemo.entity.MyUser;
import by.nintendo.springsecuritydemo.entity.Role;
import by.nintendo.springsecuritydemo.exeption.NoSuchUserExeption;
import by.nintendo.springsecuritydemo.storage.UserStorage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
@RequestMapping(path = "/")
public class AuthorithationController {
    private final UserStorage userStorage;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthorithationController(BCryptPasswordEncoder passwordEncoder, @Qualifier("userInMemory") UserStorage userStorage) {
        this.passwordEncoder = passwordEncoder;
        this.userStorage = userStorage;
    }

    @GetMapping(path = "/reg")
    public ModelAndView registView(ModelAndView modelAndView) {
        modelAndView.addObject("newUser", new MyUser());
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping(path = "/reg")
    public ModelAndView regist(@Valid @ModelAttribute("newUser") MyUser user, BindingResult result, ModelAndView modelAndView) {
        if (result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            for (FieldError fieldError : result.getFieldErrors()) {
                errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            modelAndView.setViewName("registration");
        } else {
            if (!userStorage.userInMemori(user)) {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                user.setRole(Role.USER);
                userStorage.addInMemory(user);
                modelAndView.setViewName("index");
            } else {
                throw new NoSuchUserExeption("Such a user already exists");
            }
        }
        return modelAndView;
    }

    @GetMapping(path = "/auth")
    public ModelAndView authorView(ModelAndView modelAndView) {
        modelAndView.addObject("userSession", new MyUser());
        modelAndView.setViewName("authorithation");
        return modelAndView;
    }
}
