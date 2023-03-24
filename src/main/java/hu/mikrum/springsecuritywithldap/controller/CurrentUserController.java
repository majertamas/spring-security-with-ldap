package hu.mikrum.springsecuritywithldap.controller;

import hu.mikrum.springsecuritywithldap.model.RestRespone;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/")
public class CurrentUserController {

    @GetMapping("/current-user")
    public ResponseEntity<RestRespone> currentUser() {
        RestRespone restRespone = new RestRespone();
        restRespone.setResponse(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        return new ResponseEntity<>(restRespone, HttpStatus.OK);
    }

}
