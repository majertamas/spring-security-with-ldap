package hu.mikrum.springsecuritywithldap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AngularController {

    @GetMapping("/ui/**")
    public String index() {
        return "/index.html";
    }
}
