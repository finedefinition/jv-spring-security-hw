package mate.academy.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/")
    public String hello(Authentication authentication) {

        //String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return String.format("Hello blyadi %s comes!", authentication.getName());
    }
}
