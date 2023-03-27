package hu.mikrum.springsecuritywithldap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class HomeController {

    @GetMapping("/")
    public void index(HttpServletResponse response) throws IOException {
        response.sendRedirect("ui");
    }

}
