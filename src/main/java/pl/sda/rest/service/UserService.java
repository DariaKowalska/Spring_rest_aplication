package pl.sda.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.rest.model.User;
import pl.sda.rest.repository.UserRepository;


@Service
public class UserService {

    UserRepository userRepository;
@Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(String login, String password){
        User user = new User(login, password);
        //zapis do bazy danych
        userRepository.save(user);
    }

    public User loginUser(String login, String password){
    return userRepository.findFirstByLoginAndPassword(login,password);
    }
}
