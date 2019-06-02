package pl.sda.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

public class User {
    String login;
    String password;
    LocalDateTime registration_date;
    Boolean active;

    public User(String login, String password, LocalDateTime registration_date, Boolean active) {
        this.login = login;
        this.password = password;
        this.registration_date = registration_date;
        this.active = active;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(LocalDateTime registration_date) {
        this.registration_date = registration_date;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}

