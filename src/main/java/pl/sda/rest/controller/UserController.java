package pl.sda.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import pl.sda.rest.model.User;
import pl.sda.rest.service.UserService;

public class UserController {

    //pole do wstrzyknięcia
    UserService userService;

    //wstrzyknięcie zależnosci przez konstruktor
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //rejestracja

    @PostMapping("/registration")
    public void registration(String login, String password) {
        userService.saveUser(login, password);
    }

    //potwierdzenie
    //zmienna ścieżki URL
    @PutMapping("/confirmation/{login}")  //zmienna pobrana z URL
    public void confirmation(@PathVariable String login) {
        userService.confirmedUser(login);
    }


    //logowanie
    @GetMapping("/login")
    public String login(String login, String password) {
        User loggedUser = userService.loginUser(login, password);
        if (loggedUser != null) {
            if (loggedUser.getActive() == true) {
                return "zalogowano";
            }
            return "konto jest nieaktywne";
        }

        return "błąd logowania";
    }
}
