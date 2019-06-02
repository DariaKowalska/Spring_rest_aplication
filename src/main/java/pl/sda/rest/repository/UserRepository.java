package pl.sda.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.rest.model.User;



@Repository
                                                    // <tabelka, typ klucza>
public interface UserRepository extends JpaRepository<User, Long> {
// SELECT * FROM user WHERE login = ? and password=?;
    User findFirstByLoginAndPassword(String login, String password);
}
