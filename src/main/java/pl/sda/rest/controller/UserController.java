package pl.sda.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.rest.model.User;
import pl.sda.rest.service.UserService;

public class UserController {

    //pole do wstrzyknięcia
    UserService userService;
    //wstrzyknięcie zależnosci przez konstruktor
    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    //rejestracja

    @PostMapping("/registration")
    public void registration(String login, String password){
        userService.saveUser(login, password);
    }

    //potwierdzenie
    



    //logowanie
@GetMapping ("/login")
    public String login (String login, String password){
        if(userService.loginUser(login,password)!=null) {
            return "zalogowano";
        }
        // zablokowane konto


    return "błąd logowania";
}
}