package pl.sda.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.rest.model.User;
import pl.sda.rest.repository.RoleRepository;
import pl.sda.rest.repository.UserRepository;


@Service
public class UserService {

    UserRepository userRepository;
    RoleRepository roleRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public void saveUser(String login, String password) {
        User user = new User(login, password);
// odwołanie do rekordu
        user.addRole(roleRepository.getOne(2L));

        //zapis do bazy danych
        userRepository.save(user);
    }

    public void confirmedUser(String login) {
        User confirmedUser = userRepository.findFirstByLogin(login);
        confirmedUser.setActive(true);
        userRepository.save(confirmedUser);
    }

    public User loginUser(String login, String password) {
        return userRepository.findFirstByLoginAndPassword(login, password);
    }
}
