package pl.sda.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.rest.model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class MainController {

    private List<String> logins = new ArrayList<>(Arrays.asList("xx", "kk", "pp", "ll"));
    private User user;

    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/logins")
    public List<String> getLogins() {
        return logins;
    }

    @PostMapping("/addUser")
    public User addUser(String login, String password) {
        user = new User(login, password);
        return user;
    }

    @PutMapping("/confirmRegistration")
    public User confirmRegistration() {
        user.setActive(true);
        return user;
    }

    @GetMapping("/getUser")
    public User getUser() {
        return user;
    }

}
