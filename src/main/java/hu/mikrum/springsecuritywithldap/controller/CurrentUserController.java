package hu.mikrum.springsecuritywithldap.controller;

import hu.mikrum.springsecuritywithldap.model.RestRespone;
import hu.mikrum.springsecuritywithldap.model.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest")
public class CurrentUserController {

    @GetMapping("/current-user")
    public ResponseEntity<RestRespone> currentUser() {
        RestRespone restRespone = new RestRespone();
        restRespone.setResponse(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        return new ResponseEntity<>(restRespone, HttpStatus.OK);
    }

    @PostMapping("authorities")
    public ResponseEntity<UserDTO> teszt(@RequestBody String username) {
        Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(username);
        userDTO.setAuthorities(authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

}
